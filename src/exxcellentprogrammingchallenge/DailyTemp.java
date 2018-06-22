
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
    public String getDescription() {
       return "The day with the smallest temperature spread {dayOfMonth=" + dayOfMonth + ", spread=" + this.getSpread() + "}";
    }
    
    @Override
    public String toString() {
        return getDescription();
    }

}
