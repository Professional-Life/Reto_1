import java.text.Normalizer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> noteMap, magazineMap;

        //Ejemplo: Nota -> La programación estructurada y orientada a objetos son pilares esenciales en la educación moderna.
        //          Revista -> En la actualidad, la enseñanza de ciencias de la computación incluye conceptos clave como la programación estructurada, la orientación a objetos, y metodologías modernas que buscan mejorar el aprendizaje.

        boolean result = false;

        // Leemos desde la terminal el texto
        // Nota: Esto puede ser modificado por un BufferedReader para trabajar con mucho texto. Por cuestión de tiempo, se implementa así.
        System.out.println("¡Bienvenido!");
        System.out.println("Introduce la nota que deseas: ");
        String note = scanner.nextLine();
        System.out.println("Introduce el texto de la revista: ");
        String magazine = scanner.nextLine();

        noteMap = createDictionaries(note, 1);
        magazineMap = createDictionaries(magazine, 1);

        System.out.println("Diccionarios:");
        System.out.println("Nota: " + noteMap);
        System.out.println("Revista: " + magazineMap);

        if (noteMap != null && magazineMap != null){
            result = compareStringsAndCounts(noteMap, magazineMap);
        }
        if (result){
            System.out.println("\nEl resultado es:" + result + ". Por lo tanto es posible escribir su informe.");
        }else{
            System.out.println("\nEl resultado es:" + result + ". Por lo tanto no es posible escribir su informe.");
        }

    }

    /**
     * Función para crear los diccionarios, contando cuántas veces aparece una letra/palabra en un texto
     * determinado, brindado por el usuario.
     * Nota: En caso de modularidad, ésta función podría ir en otra clase.
     * @param text El parámetro text define el texto que se requiere para realizar el procedimiento.
     *             En este contexto, cuenta para el texto de la Nota o de la Revista.
     * @param mode El parámetro mode define si se quiere utilizar la función para separar por palabras, o por letras.
     *             1 si es por letras, 0 (cero) u otro número si es por palabras.
     * @return Diccionario de letras/palabras con la cantidad de aparición. En caso contrario, null.
     */
    public static Map<String, Integer> createDictionaries(String text, int mode){
        // Variables que almacenan las palabras o letras del texto, dependiendo del modo.
        List<String> textWithLetters;
        List<String> textWithWords;

        // En caso de no haber texto, devolver nulo.
        if (text.isEmpty()){
            return null;
        }

        // Procesamos el texto para que no tenga tildes o carácteres especiales.
        text = textWithoutSpecialStrings(text);

        // Diccionario de letras con su respectiva cantidad de aparición.
        Map<String, Integer> letters = new HashMap<>();

        // Configuramos el texto para mejor funcionamiento
        // Caso si se quiere separar por letras.
        if (mode == 1) {
            textWithLetters = Arrays.stream(text.toLowerCase().replaceAll("\\s", "").split("")).toList();

            // Recorremos la lista para guardar en el diccionario.
            for (String letter : textWithLetters) {
                letters.put(letter, letters.getOrDefault(letter, 0) + 1);
            }
            return letters;
        }

        // Caso si se quiere separar por palabras.
        textWithWords  = Arrays.stream(text.toLowerCase().split(" ")).toList();
        // Recorremos la lista para guardar en el diccionario.
        for (String word : textWithWords) {
            letters.put(word, letters.getOrDefault(word, 0) + 1);
        }
        return letters;
    }

    /**
     * Función que compara la cantidad de apariciones de cada diccionario para saber si es posible escribir el informe.
     * Nota: En caso de modularidad, ésta función podría ir en otra clase.
     * @param note El parámetro note define el diccionario de la nota brindada por el usuario. Contiene ya sea letras o palabras.
     * @param magazine El parámetro magazine define el diccionario de la revista brindada por el usuario. Contiene ya sea letras o palabras.
     * @return True en caso de que la cantidad de apariciones de la revista, cumpla con la cantidad encontrada en la nota.
     *          False, en caso contrario, por lo tanto, no se podría escribir el informe.
     */
    public static boolean compareStringsAndCounts(Map<String, Integer> note, Map<String, Integer> magazine){
        int countMagazine;
        int countNote;

        // Se recorre las letras/palabras del diccionario de la revista
        for (String string : magazine.keySet()){
            // Si la nota contiene la letra/palabra, se compara la cantidad y devuelve una respuesta.
            if (note.containsKey(string)){
                countNote = note.get(string);
                countMagazine = magazine.get(string);
                if (countMagazine < countNote){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Función para quitar tildes del texto del usuario. Esto, para facilitar las demás operaciones.
     * Nota: En caso de modularidad, ésta función podría ir en otra clase.
     * @param text El parámetro text define el texto al cual se le quitarán las tildes.
     * @return Texto sin tildes ni carácteres especiales.
     */
    public static String textWithoutSpecialStrings(String text){
        // Descomponemos las letras/palabras con tildes, en sin tilde y con tilde, para luego quitarlas (las letras/palabras con tildes).
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        text = text.replaceAll("[.,;:!?¡¿()\"'-]", "");
        return text;
    }
}