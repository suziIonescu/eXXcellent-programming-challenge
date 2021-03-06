
package exxcellentprogrammingchallenge;

public class TeamScore extends EntityDetails{
    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String getDescription() {
        return "Team with the smallest distance{teamName=" + teamName + ", spread=" + this.getSpread() + "}";
    }

    @Override
    public String toString() {
        return getDescription();
    }

}
