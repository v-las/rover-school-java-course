package misc;

public class BitmaskDemo {
    // Флаги — степени двойки
    static final int READ = 1 << 0; // 0001
    static final int WRITE = 1 << 1; // 0010
    static final int EXECUTE = 1 << 2; // 0100
    static final int ADMIN = 1 << 3; // 1000

    static boolean has(int flags, int mask) {
        return (flags & mask) != 0;
    }

    static int add(int flags, int mask) {
        return flags | mask;
    }

    static int remove(int flags, int mask) {
        return flags & ~mask;
    }

    static int toggle(int flags, int mask) {
        return flags ^ mask;
    }

    public static void main(String[] args) {
        int perms = 0;
        perms = add(perms, READ | WRITE);     // установить READ и WRITE
        System.out.println(has(perms, WRITE));      // true
        perms = remove(perms, READ);                // снять READ
        perms = toggle(perms, EXECUTE);
        perms = toggle(perms, EXECUTE);             // переключить EXECUTE (0->1)
        boolean hasRW = (perms & (READ | WRITE)) == (READ | WRITE);
        System.out.println(hasRW);                  // одновременно READ+WRITE?
    }
}

/*
 Полезно помнить:
 & — пересечение,
 | — объединение,
 ^ — XOR,
 ~ — инверсия,
 << — сдвиг влево,
 >> — арифм. сдвиг вправо,
 >>> — логический сдвиг вправо.
 */
