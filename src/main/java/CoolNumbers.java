import java.util.ArrayList;

public class CoolNumbers {
    public static void main(String[] args) {
        ArrayList<String> listAutoNumbers = generateCoolNumbers();

        for (String currentAutoNumber : listAutoNumbers) {
            System.out.println(currentAutoNumber);
        }
    }

    public static ArrayList<String> generateCoolNumbers() {
        ArrayList<String> listAutoNumbers = new ArrayList<>();

        //А777ХУ23
        for (int i = 0; i < 2_000_000; i++) {
            String letters = "А,В,Е,К,М,Н,О,Р,С,Т,У,Х";
            String[] arrayLetters = letters.split(","); //индексы - от 0 до 11

            int randomNumberLetter = (int) (Math.random() * 12);
            String randomLetter = arrayLetters[randomNumberLetter];

            int randomNumber = (int) (Math.random() * 10);

            int randomNumberLetter2 = (int) (Math.random() * 12);
            String randomLetter2 = arrayLetters[randomNumberLetter2];

            int randomNumberLetter3 = (int) (Math.random() * 12);
            String randomLetter3 = arrayLetters[randomNumberLetter3];

            int randomRegion = 1 + (int) (Math.random() * 199);

            String randomAutoNumber = randomLetter +
                    randomNumber + randomNumber + randomNumber +
                    randomLetter2 + randomLetter3 +
                    randomRegion;
            listAutoNumbers.add(randomAutoNumber);
        }

        return listAutoNumbers;
    }
}
