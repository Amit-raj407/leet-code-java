package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayListDemo {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        list.add("5");
        list.add("67");
        list.add("1");
        list.add("7");
        list.add("88");
        list.add("88");
        list.add("99");
         list.add("avac");

        list.add(1, "13");

        System.out.println(list);

        List<Integer> result = list.stream()
                                        .map(ArrayListDemo::safeParse)
                                        .flatMap(Optional::stream)
                                        .filter(x -> x > 50)
                                        .map(x -> x*2)
                                        .distinct()
                                        .collect(Collectors.toList());

        System.out.println(result);

      
    }
    
    private static Optional<Integer> safeParse(String s) {
        try {
            return Optional.of(Integer.parseInt(s));

        } catch(NumberFormatException ex) {
            return Optional.empty();
        }
    }
}
