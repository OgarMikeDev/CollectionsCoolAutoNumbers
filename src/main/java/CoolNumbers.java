import java.util.ArrayList;

public class CoolNumbers {
    public static void main(String[] args) {
        ArrayList<String> listCoolNumbers = generateCoolNumbers();
        getIndexSearchNameEnumerate(listCoolNumbers.get(listCoolNumbers.size() - 1), listCoolNumbers);

    }

    public static void getIndexSearchNameEnumerate(String searchAutoNumber, ArrayList<String> listCoolNumbers) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < listCoolNumbers.size(); i++) {
            String currentAutoNumber = listCoolNumbers.get(i);
            if (currentAutoNumber.equals(searchAutoNumber)){
                long end = System.currentTimeMillis();
                long difference = end - start;
                System.out.println("За " + difference + " мс был найден искомый номер." +
                        "\n" + currentAutoNumber + " находится на позиции " + i);
            }
        }
    }

    public static ArrayList<String> generateCoolNumbers() {
        ArrayList<String> listCoolNumbers = new ArrayList<>();
        //А111ХУ193
        for (int i = 0; i < 2_000_000; i++) {
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
            listCoolNumbers.add(randomAutoNumber);
        }

        return listCoolNumbers;
    }
}
