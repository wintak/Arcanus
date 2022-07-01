import java.util.*;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        List<Marble> marbles = new ArrayList<>();
        marbles.add(new Marble(1, "blue", "Bob", 0.5));
        marbles.add(new Marble(2,"red", "John Smith", 0.25));
        marbles.add(new Marble(3,"violet", "Bob O'Bob",0.25));
        marbles.add(new Marble(4,"indigo","Bob Dad-Bob",0.75));
        marbles.add(new Marble(5, "yellow", "John",0.5));
        marbles.add(new Marble(6,"orange","Bob",0.25));
        marbles.add(new Marble(7, "blue","Smith",0.5));
        marbles.add(new Marble(8,"blue","Bob", 0.25));
        marbles.add(new Marble(9, "green", "Bobb Ob", 0.75));
        marbles.add(new Marble(10,"blue","Bob",0.75));

        Map<String, Integer> colorOrder = new HashMap<>();

        colorOrder.put("red", 0);
        colorOrder.put("orange", 1);
        colorOrder.put("yellow", 2);
        colorOrder.put("green", 3);
        colorOrder.put("blue", 4);
        colorOrder.put("indigo", 5);
        colorOrder.put("violet", 6);

        /**
         * Time complexity for this stream pipeline will be o(n) for filtering because its doing iteration
         * on the inside. the sort can be (n log n) because it's using Arrays.sort() method internally.
         * overall we can take (n log n) time complexity for this function.
         */

        List<Marble> filtered = marbles.stream().filter(m -> m.getWeight() >= 0.5 && isPalindrome(m.getName()))
                                .sorted(Comparator.comparingInt(m -> colorOrder.get(m.getColor())))
                                .collect(Collectors.toList());


        System.out.println(filtered);



    }

    public static boolean isPalindrome(String s){
        String lower = s.toLowerCase().replaceAll("[^a-z]","");
        String palindrome = new StringBuilder(lower).reverse().toString();

        return lower.equals(palindrome);
    }

}
