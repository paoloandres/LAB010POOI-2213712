import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Punto a: Crear cadenas de manera aleatoria.
        List<String> cadenaAleatoria = generarCadenasAleatorias(10);
        System.out.println("Cadenas aleatorias: " + cadenaAleatoria);

        // Punto b: Contar cuántas cadenas vacías tiene la lista de cadenas.
        long contadorCadenasVacias = contarCadenasVacias(cadenaAleatoria);
        System.out.println("Cadenas vacías: " + contadorCadenasVacias);

        // Punto c: Contabilizar cuántas cadenas tienen longitud superior a 5.
        long contadorLongitudMayor5 = contarLongitudMayor5(cadenaAleatoria);
        System.out.println("Cadenas con longitud mayor a 5: " + contadorLongitudMayor5);

        // Punto d: Contabilizar cuántas cadenas comienzan con "s".
        long contadorComienzanConS = contarComienzanConS(cadenaAleatoria);
        System.out.println("Cadenas que comienzan con 's': " + contadorComienzanConS);

        // Punto e: Eliminar todas las cadenas vacías de la lista.
        List<String> listaSinCadenasVacias = eliminarCadenasVacias(cadenaAleatoria);
        System.out.println("Lista sin cadenas vacías: " + listaSinCadenasVacias);

        // Punto f: Filtrar la lista anterior con cadenas de más de 5 caracteres.
        List<String> listaLongitudMayor5 = filtrarLongitudMayor5(listaSinCadenasVacias);
        System.out.println("Lista con cadenas de longitud mayor a 5: " + listaLongitudMayor5);

        // Punto g: Convertir las palabras a mayúsculas y concatenar usando una coma ','.
        String resultadoConcatenado = convertirAMayusculasYConcatenar(listaLongitudMayor5);
        System.out.println("Cadenas en mayúsculas y concatenadas: " + resultadoConcatenado);

        // Punto 2: Implementar IntSummaryStatistics para obtener recuento, mínimo, máximo, suma y promedio.
        IntSummaryStatistics stats = obtenerEstadisticasNumericas();
        System.out.println("Estadísticas numéricas: " + stats);
    }

    // Generar n cadenas aleatorias
    public static List<String> generarCadenasAleatorias(int n) {
        return new Random().ints(97, 123)  // Genera números aleatorios correspondientes a letras minúsculas en ASCII
                .limit(n)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.toList());
    }

    // Contar cuántas cadenas vacías hay en la lista
    public static long contarCadenasVacias(List<String> cadenas) {
        return cadenas.stream()
                .filter(String::isEmpty)
                .count();
    }

    // Contar cuántas cadenas tienen longitud superior a 5
    public static long contarLongitudMayor5(List<String> cadenas) {
        return cadenas.stream()
                .filter(s -> s.length() > 5)
                .count();
    }

    // Contar cuántas cadenas comienzan con "s"
    public static long contarComienzanConS(List<String> cadenas) {
        return cadenas.stream()
                .filter(s -> s.startsWith("s"))
                .count();
    }

    // Eliminar todas las cadenas vacías de la lista
    public static List<String> eliminarCadenasVacias(List<String> cadenas) {
        return cadenas.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    // Filtrar la lista con cadenas de más de 5 caracteres
    public static List<String> filtrarLongitudMayor5(List<String> cadenas) {
        return cadenas.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
    }

    // Convertir las palabras a mayúsculas y concatenar usando una coma ','
    public static String convertirAMayusculasYConcatenar(List<String> cadenas) {
        return cadenas.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
    }

    // Implementar IntSummaryStatistics para obtener recuento, mínimo, máximo, suma y promedio de números.
    public static IntSummaryStatistics obtenerEstadisticasNumericas() {
        IntStream numeros = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return numeros.summaryStatistics();
    }
}
