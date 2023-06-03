public class Date {
    protected int year;
    protected int month;
    protected int day;

    public Date(int year, int month, int day) {
        this.year = (year >= -3999 && year <= 3999) ? year : 0;
        this.month = (month >= 1 && month <= 12) ? month : 1;
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    public void setYear(int year) {
        this.year = (year >= -3999 && year <= 3999) ? year : 0;
    }

    public void setMonth(int month) {
        this.month = (month >= 1 && month <= 12) ? month : 1;
    }

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
