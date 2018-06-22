
package exxcellentprogrammingchallenge;

public class EntityDetails implements Comparable<EntityDetails>{
    private int minValue;
    private int maxValue;
    private Integer spread;

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getSpread() {
        return this.spread;
    }

    public void setSpread() {
        this.spread = Math.abs(this.maxValue - this.minValue);
    }

    public String getDescription() {
        return " ";
    }
    
    @Override
    public int compareTo(EntityDetails nEntity) {
        return this.spread - nEntity.spread;
    }

}
