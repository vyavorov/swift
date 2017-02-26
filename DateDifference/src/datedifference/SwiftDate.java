package datedifference;

public class SwiftDate {

    int year;
    int month;
    static int day;

    SwiftDate(int newYear, int newMonth, int newDay) {
        year = newYear;
        month = newMonth;
        day = newDay;
    }

    public boolean isLeapYear() {
        return this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0;
    }

    int getCentury() {
        return this.year / 100 + 1;
    }

    private int getDaysInMonth(int month) {
        int daysInMonth;

        if (month == 4 || month == 6 || month == 9) {
            daysInMonth = 30;
        } else if (month == 2) {
            daysInMonth = 28;
        } else {
            daysInMonth = 31;
        }
        return daysInMonth;
    }

    private int getDaysInYear(int year) {
        int daysInYear;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            daysInYear = 366;
        } else {
            daysInYear = 365;
        }
        return daysInYear;
    }

    int getDaysDifference(SwiftDate other) {
        int days = 0;
        if (this.month > other.month) {
            other.month += 12;
            other.year--;
        }

        for (int i = this.month + 1; i <= other.month; i++) {
            int month = i;
            if (month > 12) {
                month -= 12;
            }
            days += getDaysInMonth(month);
        }

        for (int i = this.year + 1; i <= other.year; i++) {
            days += getDaysInYear(i);
        }
        return days;
    }

    public static void main(String[] args) {
        SwiftDate date = new SwiftDate(1990, 1, 1);
        SwiftDate date2 = new SwiftDate(1995, 10, 19);
        System.out.println(date.getDaysDifference(date2)+day);
    }
}
