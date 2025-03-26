import java.util.ArrayList;

public class CoolNumbers {
    public static void main(String[] args) {
        ArrayList<String> listCoolNumbers = generateCoolNumbers();
        getIndexSearchNameEnumerate(listCoolNumbers.get(listCoolNumbers.size() - 1), listCoolNumbers);
        getIndexBinarySearchNameEnumerate(listCoolNumbers.get(listCoolNumbers.size() - 1), listCoolNumbers);
    }

    public static void getIndexSearchNameEnumerate(String searchAutoNumber, ArrayList<String> listCoolNumbers) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < listCoolNumbers.size(); i++) {
            String currentAutoNumber = listCoolNumbers.get(i);
            if (currentAutoNumber.equals(searchAutoNumber)) {
                long end = System.currentTimeMillis();
                long difference = end - start;
                System.out.println("За " + difference + " мс был найден искомый номер " + currentAutoNumber +
                        " методом перебора!");
            }
        }
    }

    public static void getIndexBinarySearchNameEnumerate(String searchAutoNumber, ArrayList<String> listCoolNumbers) {
        long start = System.currentTimeMillis();

        int s = 0;
        int e = listCoolNumbers.size() - 1;
        int m = (s + e) / 2;
        while (searchAutoNumber.compareTo(listCoolNumbers.get(m)) != 0) {
            if (searchAutoNumber.compareTo(listCoolNumbers.get(m)) > 0) {
                s = m + 1;
            } else if (searchAutoNumber.compareTo(listCoolNumbers.get(m)) < 0) {
                e = m - 1;
            }
            m = (s + e) / 2;
        }
        long end = System.currentTimeMillis();
        long difference = end - start;
        System.out.println("За " + difference + " мс был найден искомый номер " + listCoolNumbers.get(m) +
                " с помощью бинарного поиска!");
    }

    public static ArrayList<String> generateCoolNumbers() {
        ArrayList<String> listCoolNumbers = new ArrayList<>();
        //А111ХУ193
        for (int i = 0; i < 50_000; i++) {
            String letters = "А, В, Е, К, М, Н, О, Р, С, Т, У, Х";
            String[] arrayLetters = letters.split(", ");

            //1-й символ номера - буква
            int indexRandomLetter = (int) (Math.random() * 12);
            String randomLetter = arrayLetters[indexRandomLetter];

            //2-, 3-, 4-й символы номера - буква
            int randomNumber = (int) (Math.random() * 10);

            //5-й символ номера - буква
            int indexRandomLetter2 = (int) (Math.random() * 12);
            String randomLetter2 = arrayLetters[indexRandomLetter2];

            //6-й символ номера - буква
            int indexRandomLetter3 = (int) (Math.random() * 12);
            String randomLetter3 = arrayLetters[indexRandomLetter3];

            //7-й символ - регион от 01 до 199
            int randomRegion = 1 + (int) (Math.random() * 199);

            String randomAutoNumber = randomLetter +
                    randomNumber + randomNumber + randomNumber +
                    randomLetter2 + randomLetter3 +
                    randomRegion;
            if (!listCoolNumbers.contains(randomAutoNumber)) {
                listCoolNumbers.add(randomAutoNumber);
            }
        }

        for (int i = 0; i < listCoolNumbers.size() - 1; i++) {
            for (int j = i + 1; j < listCoolNumbers.size(); j++) {
                if (listCoolNumbers.get(i).compareTo(listCoolNumbers.get(j)) > 0) {
                    String temp = listCoolNumbers.get(j);
                    listCoolNumbers.set(j, listCoolNumbers.get(i));
                    listCoolNumbers.set(i, temp);
                }
            }
        }

        return listCoolNumbers;
    }
}
