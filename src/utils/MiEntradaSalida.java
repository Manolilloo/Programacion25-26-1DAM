package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class MiEntradaSalida {

    private static final Scanner scanner = new Scanner(System.in);

    // #########################################################################
    // BLOQUE 1: SALIDA DE DATOS (IMPRIMIR)
    // #########################################################################

    /**
     * Imprime un mensaje con salto de línea.
     * @param mensaje El texto a mostrar.
     * Ejemplo: imprimir("Bienvenido al programa");
     */
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Imprime un mensaje sin salto de línea.
     * @param mensaje El texto a mostrar.
     * Ejemplo: imprimirSinSalto("Introduce tu nombre: ");
     */
    public static void imprimirSinSalto(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Imprime un mensaje de error (texto en rojo en la mayoría de consolas).
     * @param mensajeError El texto del error.
     * Ejemplo: imprimirError("El dato no es válido");
     */
    public static void imprimirError(String mensajeError) {
        System.err.println("❗ ERROR: " + mensajeError);
    }

    // #########################################################################
    // BLOQUE 2: LECTURA DE DATOS BÁSICA (SIN RESTRICCIONES)
    // #########################################################################

    /**
     * Lee una cadena de texto (String).
     * @param prompt Mensaje a mostrar al usuario.
     * @return El texto introducido.
     * Ejemplo: String nombre = leerCadena("Nombre: ");
     */
    public static String leerCadena(String prompt) {
        imprimirSinSalto(prompt);
        return scanner.nextLine();
    }

    /**
     * Lee un número entero (int). Controla que no metan letras.
     * @param prompt Mensaje a mostrar.
     * @return El número entero.
     * Ejemplo: int edad = leerEntero("Introduce tu edad: ");
     */
    public static int leerEntero(String prompt) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            imprimirSinSalto(prompt);
            try {
                valor = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                imprimirError("Debes introducir un número entero.");
            } finally {
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return valor;
    }

    /**
     * Lee un número decimal (double).
     * @param prompt Mensaje a mostrar.
     * @return El número decimal.
     * Ejemplo: double precio = leerDoble("Precio del producto: ");
     */
    public static double leerDoble(String prompt) {
        double valor = 0.0;
        boolean valido = false;
        while (!valido) {
            imprimirSinSalto(prompt);
            try {
                valor = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                imprimirError("Debes introducir un número decimal.");
            } finally {
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return valor;
    }

    /**
     * Lee un número decimal pequeño (float).
     * @param prompt Mensaje a mostrar.
     * @return El número float.
     * Ejemplo: float altura = leerFloat("Altura en metros: ");
     */
    public static float leerFloat(String prompt) {
        float valor = 0.0f;
        boolean valido = false;
        while (!valido) {
            imprimirSinSalto(prompt);
            try {
                valor = scanner.nextFloat();
                valido = true;
            } catch (InputMismatchException e) {
                imprimirError("Debes introducir un número decimal (float).");
            } finally {
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return valor;
    }

    /**
     * Lee un número entero largo (long).
     * @param prompt Mensaje a mostrar.
     * @return El número long.
     * Ejemplo: long milisegundos = leerLong("Tiempo en ms: ");
     */
    public static long leerLong(String prompt) {
        long valor = 0;
        boolean valido = false;
        while (!valido) {
            imprimirSinSalto(prompt);
            try {
                valor = scanner.nextLong();
                valido = true;
            } catch (InputMismatchException e) {
                imprimirError("Debes introducir un número entero largo.");
            } finally {
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return valor;
    }

    /**
     * Lee un booleano respondiendo S o N.
     * @param prompt Mensaje a mostrar.
     * @return true si escribe 'S', false si escribe 'N'.
     * Ejemplo: boolean vip = leerBooleano("¿Es cliente VIP?");
     */
    public static boolean leerBooleano(String prompt) {
        while (true) {
            String entrada = leerCadena(prompt + " (S/N): ");
            if (entrada.equalsIgnoreCase("S")) return true;
            if (entrada.equalsIgnoreCase("N")) return false;
            imprimirError("Opción no válida. Escribe 'S' o 'N'.");
        }
    }

    /**
     * Lee un único carácter.
     * @param prompt Mensaje a mostrar.
     * @return El carácter introducido.
     * Ejemplo: char genero = leerCaracter("Género (M/F): ");
     */
    public static char leerCaracter(String prompt) {
        String entrada;
        do {
            entrada = leerCadena(prompt);
            if (entrada.length() != 1) imprimirError("Introduce exactamente un carácter.");
        } while (entrada.length() != 1);
        return entrada.charAt(0);
    }

    // #########################################################################
    // BLOQUE 3: LECTURA CON VALIDACIÓN (RANGOS Y RESTRICCIONES)
    // #########################################################################

    /**
     * Lee un entero dentro de un rango [min, max].
     * @param prompt Mensaje.
     * @param min Valor mínimo aceptado.
     * @param max Valor máximo aceptado.
     * @return El entero validado.
     * Ejemplo: int opcion = leerEnteroRango("Elige una opción", 1, 5);
     */
    public static int leerEnteroRango(String prompt, int min, int max) {
        int valor;
        do {
            valor = leerEntero(prompt + " [" + min + "-" + max + "]: ");
            if (valor < min || valor > max) imprimirError("El valor debe estar entre " + min + " y " + max + ".");
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Lee un entero que debe ser positivo (> 0).
     * @param prompt Mensaje.
     * @return El entero positivo.
     * Ejemplo: int fila = leerEnteroPositivo("Fila del cine: ");
     */
    public static int leerEnteroPositivo(String prompt) {
        int valor;
        do {
            valor = leerEntero(prompt);
            if (valor <= 0) imprimirError("El número debe ser mayor que 0.");
        } while (valor <= 0);
        return valor;
    }

    /**
     * Lee un entero que puede ser 0 o positivo (>= 0).
     * @param prompt Mensaje.
     * @return El entero.
     * Ejemplo: int stock = leerEnteroCeroOPositivo("Unidades en stock: ");
     */
    public static int leerEnteroCeroOPositivo(String prompt) {
        int valor;
        do {
            valor = leerEntero(prompt);
            if (valor < 0) imprimirError("El número no puede ser negativo.");
        } while (valor < 0);
        return valor;
    }

    /**
     * Lee un decimal dentro de un rango [min, max].
     * @param prompt Mensaje.
     * @param min Mínimo.
     * @param max Máximo.
     * @return El double validado.
     * Ejemplo: double nota = leerDobleRango("Nota del examen", 0.0, 10.0);
     */
    public static double leerDobleRango(String prompt, double min, double max) {
        double valor;
        do {
            valor = leerDoble(prompt + " [" + min + "-" + max + "]: ");
            if (valor < min || valor > max) imprimirError("El valor debe estar entre " + min + " y " + max + ".");
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Lee una cadena asegurando que tenga una longitud mínima y máxima.
     * @param prompt Mensaje.
     * @param min Longitud mínima.
     * @param max Longitud máxima.
     * @return La cadena validada.
     * Ejemplo: String pass = leerCadenaRangoLongitud("Contraseña", 8, 20);
     */
    public static String leerCadenaRangoLongitud(String prompt, int min, int max) {
        String cadena;
        do {
            cadena = leerCadena(prompt + " (entre " + min + " y " + max + " caracteres): ").trim();
            if (cadena.length() < min || cadena.length() > max) {
                imprimirError("La longitud debe ser de " + min + " a " + max + " caracteres.");
            }
        } while (cadena.length() < min || cadena.length() > max);
        return cadena;
    }

    // #########################################################################
    // BLOQUE 4: LECTURA DE FECHAS (DATE)
    // #########################################################################

    /**
     * Lee una fecha en formato YYYY-MM-DD.
     * @param prompt Mensaje.
     * @return Objeto LocalDate.
     * Ejemplo: LocalDate nacimiento = leerFecha("Fecha de nacimiento");
     */
    public static LocalDate leerFecha(String prompt) {
        while (true) {
            String entrada = leerCadena(prompt + " (YYYY-MM-DD): ");
            try {
                return LocalDate.parse(entrada);
            } catch (DateTimeParseException e) {
                imprimirError("Formato incorrecto. Usa Año-Mes-Día (ej. 2023-12-31).");
            }
        }
    }

    /**
     * Lee una fecha que debe ser igual o posterior a hoy.
     * @param prompt Mensaje.
     * @return LocalDate validado.
     * Ejemplo: LocalDate reserva = leerFechaFuturaOActual("Día de la reserva");
     */
    public static LocalDate leerFechaFuturaOActual(String prompt) {
        LocalDate f;
        do {
            f = leerFecha(prompt);
            if (f.isBefore(LocalDate.now())) imprimirError("La fecha debe ser hoy o futura.");
        } while (f.isBefore(LocalDate.now()));
        return f;
    }

    // #########################################################################
    // BLOQUE 5: ARRAYS - CREACIÓN (PEDIR DATOS AL USUARIO)
    // #########################################################################

    /**
     * Crea un array de ENTEROS pidiendo los números uno a uno.
     * @param prompt Mensaje para cada número.
     * @param tamano Cuántos números va a tener el array.
     * @return El array lleno.
     * Ejemplo: int[] edades = leerArrayEnteros("Edad alumno", 5);
     */
    public static int[] leerArrayEnteros(String prompt, int tamano) {
        if (tamano <= 0) return new int[0];
        int[] array = new int[tamano];
        imprimir("--- Introduciendo " + tamano + " valores (Enteros) ---");
        for (int i = 0; i < tamano; i++) {
            array[i] = leerEntero(prompt + " [" + (i + 1) + "/" + tamano + "]: ");
        }
        return array;
    }

    /**
     * Crea un array de DECIMALES (double) pidiendo los números uno a uno.
     * @param prompt Mensaje para cada número.
     * @param tamano Cuántos números va a tener.
     * @return El array lleno.
     * Ejemplo: double[] sueldos = leerArrayDoubles("Sueldo empleado", 3);
     */
    public static double[] leerArrayDoubles(String prompt, int tamano) {
        if (tamano <= 0) return new double[0];
        double[] array = new double[tamano];
        imprimir("--- Introduciendo " + tamano + " valores (Decimales) ---");
        for (int i = 0; i < tamano; i++) {
            array[i] = leerDoble(prompt + " [" + (i + 1) + "/" + tamano + "]: ");
        }
        return array;
    }

    /**
     * Crea un array de TEXTOS (String) pidiendo los datos uno a uno.
     * @param prompt Mensaje para cada texto.
     * @param tamano Cuántas cadenas va a tener.
     * @return El array lleno.
     * Ejemplo: String[] platos = leerArrayCadenas("Nombre del plato", 4);
     */
    public static String[] leerArrayCadenas(String prompt, int tamano) {
        if (tamano <= 0) return new String[0];
        String[] array = new String[tamano];
        imprimir("--- Introduciendo " + tamano + " textos ---");
        for (int i = 0; i < tamano; i++) {
            array[i] = leerCadena(prompt + " [" + (i + 1) + "/" + tamano + "]: ");
        }
        return array;
    }

    // #########################################################################
    // BLOQUE 6: ARRAYS - GENERACIÓN AUTOMÁTICA (RANDOM)
    // #########################################################################

    /**
     * Genera un array de enteros con valores ALEATORIOS.
     * @param tamano Tamaño del array.
     * @param min Valor mínimo aleatorio.
     * @param max Valor máximo aleatorio.
     * @return Array con datos aleatorios.
     * Ejemplo: int[] sorteo = generarArrayAleatorio(10, 1, 100);
     */
    public static int[] generarArrayAleatorio(int tamano, int min, int max) {
        if (tamano <= 0) return new int[0];
        int[] array = new int[tamano];
        Random rnd = new Random();
        for (int i = 0; i < tamano; i++) {
            array[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    /**
     * Genera un array de decimales (double) con valores ALEATORIOS.
     * @param tamano Tamaño del array.
     * @param min Valor mínimo.
     * @param max Valor máximo.
     * @return Array con datos aleatorios.
     * Ejemplo: double[] temps = generarArrayAleatorioDecimales(10, 0.0, 40.0);
     */
    public static double[] generarArrayAleatorioDecimales(int tamano, double min, double max) {
        if (tamano <= 0) return new double[0];
        double[] array = new double[tamano];
        Random rnd = new Random();
        for (int i = 0; i < tamano; i++) {
            // Generar double aleatorio entre min y max
            double randomValue = min + (max - min) * rnd.nextDouble();
            // Redondear a 2 decimales para que se vea bonito
            array[i] = Math.round(randomValue * 100.0) / 100.0;
        }
        return array;
    }

    // #########################################################################
    // BLOQUE 7: ARRAYS - VISUALIZACIÓN (IMPRIMIR)
    // #########################################################################

    /**
     * Imprime un array de enteros en horizontal.
     * @param titulo Título opcional.
     * @param array Array a imprimir.
     * Ejemplo: imprimirArrayEnteros("Números de la lotería", loteria);
     */
    public static void imprimirArrayEnteros(String titulo, int[] array) {
        if (titulo != null && !titulo.isEmpty()) imprimir(titulo);
        if (array == null || array.length == 0) {
            imprimir("  [Array vacío]");
            return;
        }
        System.out.print("  [ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }

    /**
     * Imprime un array de decimales (double) en horizontal.
     * @param titulo Título opcional.
     * @param array Array a imprimir.
     * Ejemplo: imprimirArrayDoubles("Temperaturas", temperaturas);
     */
    public static void imprimirArrayDoubles(String titulo, double[] array) {
        if (titulo != null && !titulo.isEmpty()) imprimir(titulo);
        if (array == null || array.length == 0) {
            imprimir("  [Array vacío]");
            return;
        }
        System.out.print("  [ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(" | ");
        }
        System.out.println(" ]");
    }

    /**
     * Imprime un array de Strings en formato lista vertical.
     * @param titulo Título de la lista.
     * @param array Array de cadenas.
     * Ejemplo: imprimirArrayCadenas("Lista de invitados", nombres);
     */
    public static void imprimirArrayCadenas(String titulo, String[] array) {
        if (titulo != null && !titulo.isEmpty()) imprimir(titulo);
        if (array == null || array.length == 0) {
            imprimir("  [Lista vacía]");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("  " + (i + 1) + ". " + array[i]);
        }
    }

    // #########################################################################
    // BLOQUE 8: ARRAYS - SELECCIÓN E INTERACCIÓN
    // #########################################################################

    /**
     * Muestra una lista de opciones (String[]) y devuelve el ÍNDICE elegido.
     * @param mensaje Mensaje para pedir la selección.
     * @param opciones Array con las opciones a mostrar.
     * @return El índice (posición del array) que eligió el usuario.
     * Ejemplo: int i = seleccionarIndiceDeArray("Elige color", colores);
     */
    public static int seleccionarIndiceDeArray(String mensaje, String[] opciones) {
        imprimirArrayCadenas("--- Opciones disponibles ---", opciones);
        int seleccion = leerEnteroRango(mensaje, 1, opciones.length);
        return seleccion - 1; // Ajustamos de 1..N a 0..N-1
    }

    /**
     * Busca si un número existe en un array. Útil para validar IDs.
     * @param array Array donde buscar.
     * @param valorBuscado El número a buscar.
     * @return true si existe, false si no.
     * Ejemplo: boolean existe = existeEnArray(idsClientes, 501);
     */
    public static boolean existeEnArray(int[] array, int valorBuscado) {
        for (int num : array) {
            if (num == valorBuscado) return true;
        }
        return false;
    }
}