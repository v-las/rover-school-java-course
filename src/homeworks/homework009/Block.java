package homeworks.homework009;

public class Block {
    private int width;
    private int length;
    private int height;

    public Block(int[] dimensions) {
        this.width = dimensions[0];
        this.length = dimensions[1];
        this.height = dimensions[2];
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getVolume() {
        return width * length * height;
    }

    public int getSurfaceArea() {
        return ((width * length) + (height * length) + (width * height)) * 2;
    }

    public static void main(String[] args) {
        Block b = new Block(new int[]{2, 2, 2});
        System.out.println("exp:" + 2 + " | act: " + b.getWidth());
        System.out.println("exp:" + 2 + " | act: " + b.getLength());
        System.out.println("exp:" + 2 + " | act: " + b.getHeight());
        System.out.println("exp:" + 8 + " | act: " + b.getVolume());
        System.out.println("exp:" + 24 + " | act: " + b.getSurfaceArea());
    }
}