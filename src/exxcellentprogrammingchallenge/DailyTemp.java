
package exxcellentprogrammingchallenge;

public class DailyTemp extends EntityDetails{
    private int dayOfMonth;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public String toString() {
        return "The day with the smallest temperature spread {" + "dayOfMonth=" + dayOfMonth + ", spread=" + this.getSpread() + '}';
    }

}
