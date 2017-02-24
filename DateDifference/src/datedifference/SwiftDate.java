package datedifference;

public class SwiftDate {

    int year;
    int month;
    int day;

    SwiftDate(int newYear, int newMonth, int newDay) {
        year = newYear;
        month = newMonth;
        day = newDay;
    }

    public boolean isLeapYear() {
        return this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0;
    }

    int getCentury() {
        return this.year%100+1;
    }
    int getDaysDifference (SwiftDate other) {
        
    }
}
