import java.util.*;
public class PirateShip extends SpaceObject implements CanMove {

    private int bootyHoldings;

    public PirateShip() {
        this.setBootyHoldings(1);
        super.setType("P");

    }


    public void setBootyHoldings(int bootyHoldings) {

        this.bootyHoldings = bootyHoldings;

    }


    public int getBootyHoldings() {

        return bootyHoldings;

    }


    public void moveShip(int xShift, int yShift) {

        int xAxis = super.getXCoordinate();
        int yAxis = super.getYCoordinate();


        if((xAxis == 1 && xShift == -1) || (xAxis == 10 && yShift == 1)) {
            yAxis += yShift;
        }else if((yAxis == 1 && yShift == -1) || (xAxis == 10 && yShift ==1)){
            xAxis += xShift;
        }else {
            xAxis += xShift;
            yAxis += yShift;
        }
        super.setXCoordinate(xAxis);
        super.setYCoordinate(yAxis);

    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb = sb.append(super.toString());
        sb = sb.append("Ship Name: " + getNameOfShip() +"\tShip Coordinates: (" + super.getXCoordinate() + ", " + super.getYCoordinate() + ")" + "\tBootyHoldings: " + this.getBootyHoldings());
        return sb.toString();
    }


}
