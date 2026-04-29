import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * CLASE IO - LA NAVAJA SUIZA PARA EL EXAMEN DE 1º DAM
 *
 * @author Manuel Perez
 */
public class IO {

    // ====================================================================================
    // 🟢 SECCIÓN 1: GESTIÓN BÁSICA DE ARCHIVOS Y CARPETAS (NIO.2)
    // ====================================================================================

    /**
     * 🟢 1.1 crearDirectorioSeguro
     * Crea una carpeta, y si ya existe, no peta el programa.
     * EJEMPLO: IO.crearDirectorioSeguro("src/Tema7/MiNuevaCarpeta");
     */
    public static void crearDirectorioSeguro(String rutaTexto) {
        Path ruta = Paths.get(rutaTexto);
        try {
            if (!Files.exists(ruta)) {
                Files.createDirectories(ruta); // createDirectories (con s) crea subcarpetas si hacen falta
                System.out.println("✅ Directorio creado: " + ruta.toAbsolutePath());
            } else {
                System.out.println("ℹ️ El directorio ya existía.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error al crear directorio: " + e.getMessage());
        }
    }

    /**
     * 🟢 1.2 escribirArchivoAppend
     * Escribe texto en un archivo. Si no existe, lo crea. Si existe, lo añade al final sin borrar lo anterior.
     * EJEMPLO: IO.escribirArchivoAppend("src/log.txt", "Usuario entró al sistema");
     */
    public static void escribirArchivoAppend(String rutaTexto, String contenido) {
        Path ruta = Paths.get(rutaTexto);
        try {
            // Escribimos el contenido + un salto de linea para que no se pegue todo
            Files.writeString(ruta, contenido + System.lineSeparator(),
                    StandardOpenOption.CREATE, // Si no existe, lo crea
                    StandardOpenOption.APPEND); // Añade al final
            System.out.println("✅ Texto añadido correctamente a: " + ruta.getFileName());
        } catch (IOException e) {
            System.out.println("❌ Error escribiendo: " + e.getMessage());
        }
    }

    // ====================================================================================
    // 🔵 SECCIÓN 2: BÚSQUEDAS Y FILTROS AVANZADOS (REGEX Y WALK)
    // ====================================================================================

    /**
     * 🔵 2.1 buscarArchivosPorRegexRecursivo
     * ¡SÚPER ÚTIL PARA EXÁMENES! Busca archivos en todas las subcarpetas que cumplan un patrón (Regex).
     * EJEMPLO (Examen): Buscar "empleado_001.txt":
     * IO.buscarArchivosPorRegexRecursivo("src/datos", "^empleado_\\d{3}\\.(txt|data)$");
     */
    public static List<Path> buscarArchivosPorRegexRecursivo(String rutaBase, String patronRegex) {
        Path directorio = Paths.get(rutaBase);
        Pattern patron = Pattern.compile(patronRegex); // Compilamos el regex

        try (Stream<Path> arbol = Files.walk(directorio)) { // walk() entra en subcarpetas
            // Pasamos el Stream a Lista para poder devolverlo o usarlo luego sin que se cierre
            return arbol
                    .filter(Files::isRegularFile) // Solo archivos de verdad
                    .filter(archivo -> patron.matcher(archivo.getFileName().toString()).matches()) // ¿El nombre encaja?
                    .collect(Collectors.toList()); // Lo guardamos en una lista
        } catch (IOException e) {
            System.out.println("❌ Error buscando archivos: " + e.getMessage());
            return List.of(); // Devuelve lista vacía si falla
        }
    }

    /**
     * 🔵 2.2 contienePalabraProhibida
     * Lee un archivo y comprueba si tiene una palabra exacta dentro (usando Regex por si está en mayus/minus).
     * EJEMPLO (Examen): IO.contienePalabraProhibida("archivo.txt", "CONFIDENCIAL");
     */
    public static boolean contienePalabraProhibida(Path archivo, String palabra) {
        // La (?i) hace que le den igual mayus/minus. Las \\b aseguran que sea palabra entera (no parte de otra)
        String regexProhibido = "(?i)\\b" + palabra + "\\b";
        Pattern patron = Pattern.compile(regexProhibido);

        try {
            // Leemos todo el texto del archivo de golpe
            String contenido = Files.readString(archivo);
            return patron.matcher(contenido).find(); // .find() busca si está en alguna parte del texto
        } catch (IOException e) {
            System.out.println("❌ Error leyendo para buscar prohibidos: " + e.getMessage());
            return false; // Ante la duda, decimos que no
        }
    }

    // ====================================================================================
    // 🟠 SECCIÓN 3: COMPRESIÓN ZIP (PRÁCTICA ZIP)
    // ====================================================================================

    /**
     * 🟠 3.1 comprimirDirectorioAZip
     * Coge una carpeta entera (con sus subcarpetas) y la mete en un archivo .zip.
     * EJEMPLO: IO.comprimirDirectorioAZip("src/Tema7/BoletinP1", "C:/Users/mdema/Desktop/copia.zip");
     */
    public static void comprimirDirectorioAZip(String rutaOrigen, String rutaDestinoZip) {
        Path origen = Paths.get(rutaOrigen);
        Path destinoZip = Paths.get(rutaDestinoZip);

        if (!Files.exists(origen) || !Files.isDirectory(origen)) {
            System.out.println("❌ Error: El origen no es una carpeta válida.");
            return;
        }

        // Abrimos el creador de ZIPs (ZipOutputStream envuelve a un OutputStream normal)
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(destinoZip));
             Stream<Path> rutas = Files.walk(origen)) {

            rutas.filter(path -> !Files.isDirectory(path)) // No metemos carpetas vacías, solo archivos
                    .forEach(path -> {
                        // relativize() saca la ruta del archivo quitándole el principio (para que no salga "C:/Users/..." dentro del zip)
                        ZipEntry entradaZip = new ZipEntry(origen.relativize(path).toString());
                        try {
                            zos.putNextEntry(entradaZip); // Creamos el "hueco" en el zip
                            Files.copy(path, zos);        // Copiamos los bytes del archivo original al hueco del zip
                            zos.closeEntry();             // Cerramos el hueco
                        } catch (IOException e) {
                            System.out.println("❌ Fallo al comprimir archivo: " + path.getFileName());
                        }
                    });
            System.out.println("✅ ¡Carpeta comprimida con éxito en: " + destinoZip.getFileName() + "!");

        } catch (IOException e) {
            System.out.println("❌ Error general creando el ZIP: " + e.getMessage());
        }
    }
    // ====================================================================================
    // 🟨 SECCIÓN 4: LECTURA Y ESCRITURA DE JSON (LIBRERÍA GSON)
    // ====================================================================================

    // NOTA: Para usar esto en el examen, importa estas cosas arriba:
    // import com.google.gson.Gson;
    // import com.google.gson.GsonBuilder;
    // import com.google.gson.reflect.TypeToken;
    // import java.lang.reflect.Type;

    /**
     * 🟨 4.1 guardarListaEnJSON
     * Convierte cualquier lista de objetos (Videojuegos, Empleados, etc) en un JSON bonito y lo guarda.
     * EJEMPLO (Examen):
     * List<Videojuego> misJuegos = new ArrayList<>();
     * IO.guardarListaEnJSON("src/videojuegos.json", misJuegos);
     */
    public static <T> void guardarListaEnJSON(String rutaTexto, List<T> listaObjetos) {
        Path ruta = Paths.get(rutaTexto);

        // Creamos el conversor a JSON activando el formato bonito (PrettyPrinting) para que el profe lo lea bien
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            // 1. Convertimos la lista de Java a un String gigante en formato JSON
            String textoJson = gson.toJson(listaObjetos);

            // 2. Volcamos el String al archivo de un plumazo (CREATE crea si no existe, TRUNCATE borra lo viejo)
            Files.writeString(ruta, textoJson, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("✅ Lista guardada en JSON correctamente en: " + ruta.getFileName());

        } catch (IOException e) {
            System.out.println("❌ Error guardando el JSON: " + e.getMessage());
        }
    }

    /**
     * 🟨 4.2 leerListaDeJSON
     * Lee un archivo JSON y lo convierte de vuelta a una Lista de objetos de Java listos para usar.
     * OJO: Necesita saber de qué "Tipo" es la lista (el famoso TypeToken del Tema 7).
     * <p>
     * EJEMPLO (Examen):
     * Type tipoLista = new TypeToken<List<Videojuego>>(){}.getType();
     * List<Videojuego> juegosRecuperados = IO.leerListaDeJSON("src/videojuegos.json", tipoLista);
     */
    public static <T> List<T> leerListaDeJSON(String rutaTexto, java.lang.reflect.Type tipoLista) {
        Path ruta = Paths.get(rutaTexto);

        if (!Files.exists(ruta)) {
            System.out.println("❌ Error: El archivo JSON no existe.");
            return List.of(); // Devuelve lista vacía si no hay archivo
        }

        Gson gson = new Gson(); // Para leer no hace falta el PrettyPrinting

        try {
            // 1. Leemos todo el archivo de texto a una variable String
            String jsonLeido = Files.readString(ruta);

            // 2. Lo deserializamos. Le damos el texto y el "Tipo" de Lista para curar su amnesia.
            return gson.fromJson(jsonLeido, tipoLista);

        } catch (IOException e) {
            System.out.println("❌ Error leyendo el JSON: " + e.getMessage());
            return List.of();
        }
    }


    // ====================================================================================
    // 🟣 SECCIÓN 5: HERRAMIENTAS DE TEXTO Y LIMPIEZA (PARA FICHEROS)
    // ====================================================================================

    /**
     * 🟣 5.1 extraerInformacionPorEtiqueta
     * Súper útil para el "Examen Ficheros y Regex" (Ejercicio de Empleados) donde las líneas son: "Nombre: Ana".
     * Le pasas la línea entera ("Nombre: Ana García") y la etiqueta ("Nombre:"), y te devuelve solo el dato ("Ana García").
     * <p>
     * EJEMPLO: String nombre = IO.extraerInformacionPorEtiqueta("Nombre: Juan", "Nombre:"); // Devuelve "Juan"
     */
    public static String extraerInformacionPorEtiqueta(String linea, String etiqueta) {
        // Miramos si la linea empieza por la etiqueta (ignorando mayus/minusculas)
        if (linea.toLowerCase().startsWith(etiqueta.toLowerCase())) {
            // Recortamos la etiqueta, nos quedamos solo con lo de la derecha y le quitamos los espacios de los lados (trim)
            return linea.substring(etiqueta.length()).trim();
        }
        return ""; // Si no tiene la etiqueta, devolvemos texto vacío
    }

    /**
     * 🟣 5.2 normalizarNombreArchivo
     * (Simulación Examen Parte 3): Pide coger un título, pasarlo a minúsculas y quitarle caracteres raros para usarlo de nombre de archivo.
     * EJEMPLO: IO.normalizarNombreArchivo("The Witcher 3: Wild Hunt!"); // Devuelve "the_witcher_3_wild_hunt"
     */
    public static String normalizarNombreArchivo(String textoOriginal) {
        // 1. Lo pasamos todo a minúsculas
        String limpio = textoOriginal.toLowerCase();

        // 2. Con Regex, cambiamos TODO lo que no sea letra o numero ([^a-z0-9]) por un guion bajo "_"
        limpio = limpio.replaceAll("[^a-z0-9]", "_");

        // 3. (Opcional) Si salen varios guiones seguidos "___", los juntamos en uno solo "_"
        limpio = limpio.replaceAll("_+", "_");

        return limpio;
    }

    // ====================================================================================
    // 🟥 SECCIÓN 6: LECTURA Y CREACIÓN DE XML (DOM PARSER)
    // ====================================================================================

    // NOTA: Asegúrate de añadir estos imports arriba del todo para XML:


    /**
     * 🟥 6.1 leerDatosXML
     * (Simulación Examen Parte 2): Extrae información de un XML. Le dices qué "etiqueta base" buscar
     * (ej: "videojuego" o "empleado") y qué "dato" quieres sacar de dentro (ej: "titulo" o "edad").
     * <p>
     * EJEMPLO: IO.leerDatosXML("src/catalogovideojuegos.xml", "videojuego", "titulo");
     */
    public static void leerDatosXML(String rutaTexto, String etiquetaBase, String datoABuscar) {
        try {
            // Magia oscura de Java para preparar el lector de XML
            File archivo = new File(rutaTexto);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);

            // Normalizamos el documento (arregla saltos de linea raros que haya por el medio)
            doc.getDocumentElement().normalize();

            // Cogemos TODOS los bloques que se llamen como la "etiqueta base" (ej: todos los <videojuego>)
            NodeList nodosBase = doc.getElementsByTagName(etiquetaBase);

            System.out.println("🔎 Buscando '<" + datoABuscar + ">' dentro de los " + nodosBase.getLength() + " bloques '<" + etiquetaBase + ">':");

            // Recorremos los bloques uno a uno
            for (int i = 0; i < nodosBase.getLength(); i++) {
                Element elementoActual = (Element) nodosBase.item(i);

                // Buscamos el dato concreto que queremos dentro de ese bloque
                NodeList nodosDato = elementoActual.getElementsByTagName(datoABuscar);

                if (nodosDato.getLength() > 0) {
                    // getTextContent() extrae el texto puro que hay entre <etiqueta> y </etiqueta>
                    String textoExtraido = nodosDato.item(0).getTextContent();
                    System.out.println("  - Encontrado: " + textoExtraido);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error al procesar el XML: " + e.getMessage());
        }
    }

    /**
     * 🟥 6.2 generarInformeXMLBasico
     * (Examen Ficheros y Regex Ejercicio 2): Crea un XML muy simple a partir de listas de datos a mano.
     * Es ideal para cuando te piden generar un "informe_empleados.xml" a partir de un archivo txt.
     * (Uso FileWriter y PrintWriter antiguos porque el enunciado de tu profe dice que se puede usar y es más fácil).
     * <p>
     * EJEMPLO:
     * List<String> nombres = List.of("Juan Perez", "Maria Lopez");
     * List<String> departamentos = List.of("Finanzas", "Informatica");
     * IO.generarInformeXMLBasico("src/informe.xml", "empleados", "empleado", nombres, departamentos);
     */
    public static void generarInformeXMLBasico(String rutaDestino, String etiquetaRaiz, String etiquetaHijo, List<String> nombres, List<String> departamentos) {

        // Abrimos el archivo en modo "NO añadir" (sobrescribir)
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaDestino, false))) {

            // 1. Escribimos la cabecera obligatoria de cualquier archivo XML
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

            // 2. Abrimos la etiqueta padre general (ej: <empleados>)
            pw.println("<" + etiquetaRaiz + ">");

            // 3. Generamos los hijos iterando sobre las listas (suponemos que miden lo mismo)
            for (int i = 0; i < nombres.size(); i++) {
                pw.println("\t<" + etiquetaHijo + ">"); // ej: <empleado>

                pw.println("\t\t<departamento>" + departamentos.get(i) + "</departamento>");
                pw.println("\t\t<nombre>" + nombres.get(i) + "</nombre>");

                pw.println("\t</" + etiquetaHijo + ">"); // ej: </empleado>
            }

            // 4. Cerramos la etiqueta padre general
            pw.println("</" + etiquetaRaiz + ">");

            System.out.println("✅ ¡Informe XML generado con éxito en " + rutaDestino + "!");

        } catch (IOException e) {
            System.out.println("❌ Error al crear el archivo XML: " + e.getMessage());
        }
    }
}

/*
*<dependencies>
 <dependency>
 <groupId>com.google.code.gson</groupId>
 <artifactId>gson</artifactId>
 <version>2.13.2</version>
 </dependency>
 </dependencies>*/
