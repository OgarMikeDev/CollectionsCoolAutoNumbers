import java.util.ArrayList;

public class CoolNumbers {
    public static void main(String[] args) {
        generateCoolNumbers();
    }
    public static ArrayList<String> generateCoolNumbers() {
        ArrayList<String> coolNumbers = new ArrayList<>();
        for (int i = 0; i < 2_000_000; i++) {
            //А000ВХ199
            String letters = "А,В,Е,К,М,Н,О,Р,С,Т,У,Х";
            String[] arrayLetters = letters.split(","); //индексы - от 0 до 11
            int randomNumberLetter1 = (int) (Math.random() * (arrayLetters.length));
            String randomLetter1 = arrayLetters[randomNumberLetter1];

            int randomNumberLetter2 = (int) (Math.random() * (arrayLetters.length));
            String randomLetter2 = arrayLetters[randomNumberLetter2];

            int randomNumberLetter3 = (int) (Math.random() * (arrayLetters.length));
            String randomLetter3 = arrayLetters[randomNumberLetter3];

            int randomNumber = (int) (Math.random() * 10);
            int randomNumberRegion = 1 + (int) (Math.random() * (200));

            String autoNumber = randomLetter1 +
                    randomNumber + randomNumber + randomNumber
                    + randomLetter2 + randomLetter3 +
                    randomNumberRegion;
            System.out.println(autoNumber);
        }
        return coolNumbers;
    }
}
