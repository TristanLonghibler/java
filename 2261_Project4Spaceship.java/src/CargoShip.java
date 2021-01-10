import java.util.*;
public class CargoShip extends SpaceObject implements CanMove{


    private int cargoHoldings;

    public CargoShip() {

        Random rand = new Random();
        int min = 50;
        int max = 200;
        this.setCargoHoldings(rand.nextInt(max-min) + 1);
        super.setType("C");

    }


    public void setCargoHoldings(int cargoHoldings) {

        this.cargoHoldings = cargoHoldings;

    }


    public int getCargoHoldings() {

        return cargoHoldings;

    }


    public void moveShip(int xShift, int yShift) {

        int xAxis = super.getXCoordinate();
        int yAxis = super.getYCoordinate();

        xAxis += xShift;
        yAxis += yShift;

            if (xAxis > 10) {
                xAxis -= 1;
            } else if (xAxis < 1) {
                xAxis += 1;
            } else if (yAxis > 10) {
                yAxis -= 1;
            } else if (yAxis < 1) {
                yAxis += 1;
            }

            super.setXCoordinate(xAxis);
            super.setYCoordinate(yAxis);

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb = sb.append(super.toString());
        sb = sb.append("CargoShip Name: " +getNameOfShip() + "\tCargoShip locatioin: (" + super.getXCoordinate() + "," + super.getYCoordinate() + ")" + "\tCargoBooty: " + this.getCargoHoldings());

        return sb.toString();

    }

}
