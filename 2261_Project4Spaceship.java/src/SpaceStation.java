import java.util.*;
public class SpaceStation extends SpaceObject { //We do not want SpaceStation moving so we dont impliment CanMove

    private int humanCount;

    public SpaceStation() {

        Random rand = new Random();
        int min = 10;
        int max = 100;
        setHumanCount(rand.nextInt(max-min) + 1);
        super.setType("&");

    }


    public void setHumanCount(int humanCount) {

        this.humanCount = humanCount;
    }


    public int getHumanCount() {

        return humanCount;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append(super.toString());
        sb = sb.append("Station Name: " + getNameOfShip() +"\tSpaceStation's Coordinates: (" + super.getXCoordinate() + ", " + super.getYCoordinate() + ")" + "\tHumans aboard: " + this.getHumanCount());
        return sb.toString();
    }


}
