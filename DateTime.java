public class DateTime extends Date {
    protected int hour;
    protected int minute;

    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
        this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
    }

    public void setHour(int hour) {
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
    }

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