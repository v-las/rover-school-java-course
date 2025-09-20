package homeworks.homework009;

// Playing with cubes I
// https://www.codewars.com/kata/55c0a79e20be94c91400014b/train/java
public class Cube {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public static void main(String[] args) {
        Cube c = new Cube();
        c.setSide(3);
        System.out.println("exp:" + 3 + " | act: " + c.getSide());
    }
}