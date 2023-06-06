public class Date {
    protected int year; // the year of the date
    protected int month; //the month of the date
    protected int day; // the day of the date

    /**
     * constructor, if an element of the date is illegal it is defaulted to the
     * smallest non-negative value that element can be
     * @param year the year of the date
     * @param month the month of the date
     * @param day the day of the date
     */
    public Date(int year, int month, int day) {
        this.year = (year >= -3999 && year <= 3999) ? year : 0;
        this.month = (month >= 1 && month <= 12) ? month : 1;
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    /*setter for the year of the date, if illegal input then defaulted*/
    public void setYear(int year) {
        this.year = (year >= -3999 && year <= 3999) ? year : 0;
    }

    /*setter for the month of the date, if illegal input then defaulted*/
    public void setMonth(int month) {
        this.month = (month >= 1 && month <= 12) ? month : 1;
    }

    /*setter for the day of the date, if illegal input then defaulted*/
    public void setDay(int day) {
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Date) || other.toString().length() > this.toString().length()) {
            return false;
        }
        Date otherDate = (Date) other;
        return this.year == otherDate.year && this.month == otherDate.month
                && this.day == otherDate.day;
    }

    @Override
    public int hashCode() {
        return this.year * 1000 + this.month * 100 + this.day;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }
}
