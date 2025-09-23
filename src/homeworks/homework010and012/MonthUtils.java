package homeworks.homework010and012;

public class MonthUtils {
    public static final Month[] MONTHS_2025 = {
            new Month("January", 31, 23),
            new Month("February", 28, 20),
            new Month("March", 31, 21),
            new Month("April", 30, 22),
            new Month("May", 31, 22),
            new Month("June", 30, 21),
            new Month("July", 31, 23),
            new Month("August", 31, 21),
            new Month("September", 30, 22),
            new Month("October", 31, 23),
            new Month("November", 30, 20),
            new Month("December", 31, 23)
    };

    public static final Month[] Q1_2025 = {
            MONTHS_2025[0], // January
            MONTHS_2025[1], // February
            MONTHS_2025[2]  // March
    };

    public static final Month[] Q2_2025 = {
            MONTHS_2025[3], // April
            MONTHS_2025[4], // May
            MONTHS_2025[5]  // June
    };

    public static final Month[] Q3_2025 = {
            MONTHS_2025[6], // July
            MONTHS_2025[7], // August
            MONTHS_2025[8]  // September
    };

    public static final Month[] Q4_2025 = {
            MONTHS_2025[9],  // October
            MONTHS_2025[10], // November
            MONTHS_2025[11]  // December
    };
}
