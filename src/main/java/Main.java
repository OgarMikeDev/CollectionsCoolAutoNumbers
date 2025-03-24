import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>() {{
            add("Артём");
            add("Борис");
            add("Владимир");
            add("Георгий");
            add("Даниил");
            add("Евгений");
            add("Ёзге");
            add("Жанна");
        }};

        int start = 0;
        int end = names.size() - 1;
        int intMiddleName = (start + end) / 2;
        //Иск-е имя - Владимир
        String searchName = "Владимир";
        while (searchName.compareTo(names.get(intMiddleName)) != 0) {
            if (searchName.compareTo(names.get(intMiddleName)) < 0) {
                end = intMiddleName - 1;
            } else if (searchName.compareTo(names.get(intMiddleName)) > 0) {
                start = intMiddleName + 1;
            }
            intMiddleName = (start + end) / 2;
        }
        System.out.println("Индекс искомого элемента: " + intMiddleName);
    }
}
