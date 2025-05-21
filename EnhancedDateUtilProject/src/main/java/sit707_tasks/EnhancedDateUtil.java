package sit707_tasks;

public class EnhancedDateUtil {
    private int day, month, year;

    public EnhancedDateUtil(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1700 || year > 2024) {
            throw new RuntimeException("Invalid date");
        }
        if (day > monthDuration(month, year)) {
            throw new RuntimeException("Invalid day for month/year");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int n) {
        for (int i = 0; i < n; i++) increment();
    }

    public void subtractDays(int n) {
        for (int i = 0; i < n; i++) decrement();
    }

    public void increment() {
        if (day < monthDuration(month, year)) {
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }

    public void decrement() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            month = 12;
            year--;
            day = monthDuration(month, year);
        }
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public boolean isWeekend() {
        return (toOrdinal() % 7 == 0) || (toOrdinal() % 7 == 6); // Approximation
    }

    private int toOrdinal() {
        int days = (year - 1900) * 365 + (year - 1900) / 4;
        for (int i = 1; i < month; i++) {
            days += monthDuration(i, year);
        }
        days += day;
        return days;
    }

    public static int monthDuration(int month, int year) {
        if (month == 2)
            return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
