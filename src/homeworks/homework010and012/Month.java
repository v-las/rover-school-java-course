package homeworks.homework010and012;

public class Month {
    private final String monthName;
    private final int daysOfMonthCount;
    private final int workDaysCount;

    public Month(String monthName, int daysOfMonthCount, int workDaysCount) {
        this.monthName = monthName;
        this.daysOfMonthCount = daysOfMonthCount;
        this.workDaysCount = workDaysCount;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getDaysOfMonthCount() {
        return daysOfMonthCount;
    }

    public int getWorkDaysCount() {
        return workDaysCount;
    }
}
