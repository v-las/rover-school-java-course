import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] matchesInBox = {59, 60, 60, 58, 61, 55, 63, 61, 58, 58};

        System.out.println("Arrays.toString(matchesInBox) = " + Arrays.toString(matchesInBox));
        
        int[] ints = new int[5];
        ints[0] = 5; 
        ints[1] = 1;
        ints[2] = 3;
        ints[3] = 3;
        ints[4] = 5;

        System.out.println("ints = " + Arrays.toString(ints));

        ints[2] = 122;
        System.out.println("ints = " + Arrays.toString(ints));



    }
}
