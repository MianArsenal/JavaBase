package reprocess;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        double total = 13 + 60 + 92 + 256 + 6 * 16 + 32 + 7 * 64 + 128 * 3 + 8 * 256 + 9 * 512;
        double floor = Math.floor(total/11);
        double result = total - floor * 11;
        System.out.println(total);
//        System.out.println(total/11.0);
        System.out.println(floor);
        System.out.println(result);
        Character a = new Character('a');
        Character a1 = new Character('a');
        System.out.println(a.hashCode());
        System.out.println(a1.hashCode());
        System.out.println(a1.equals(a));
        List<Character> characters = new ArrayList<>();
        characters.add('a');
    }

}
