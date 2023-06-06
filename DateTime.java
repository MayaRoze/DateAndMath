public class DateTime extends Date {
    /**the hour of the time of day*/
    protected int hour;
    /**the minutes of the time of day*/
    protected int minute;

    /**
     * constructor, if an element of the date is illegal it is defaulted to the
     * smallest non-negative value that element can be
     *
     * @param year   the year of the date
     * @param month  the month of the date
     * @param day    the day of the date
     * @param hour   the hour of the date
     * @param minute the minute of the date
     */
    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
        this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
    }

    /**setter for the hour of the date, if illegal input then defaulted*/
    public void setHour(int hour) {
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
    }

    /**setter for the minute of the date, if illegal input then defaulted*/
    public void setMinute(int minute) {
        this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        }
        DateTime otherDateTime = (DateTime) other;
        return super.equals(other) && this.hour == otherDateTime.hour
                && this.minute == otherDateTime.minute;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 10000 + this.hour * 100 + this.minute;
    }


    @Override
    public String toString() {
        return String.format("%s %02d:%02d", super.toString(), this.hour, this.minute);
    }
}