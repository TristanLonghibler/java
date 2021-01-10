import java.util.*;
//abstract classes exist to be extended, they can not be instantiated
public abstract class SpaceObject {

//    //This is saying that each object extending to SpaceObject must inherit this concept
//    public abstract void canMove();

    private String nameOfShip;
    private String type;
    private int dateBuilt;
    private int xCoordinate;
    private int yCoordinate;
    private int arrPos;

    public SpaceObject() {
        //Random assaign x y coordinates for the 10x10 grid
        Random rand = new Random();
        int minValue = 1;
        int maxValue = 10;

        setXCoordinate(rand.nextInt(maxValue - minValue + 1) + minValue); //add one to keep it in x y
        setYCoordinate(rand.nextInt(maxValue - minValue + 1) + minValue);


        int minDate = 1000;
        int maxDate = 2020;

        setDate(rand.nextInt(maxDate - minDate + 1) + minDate);

    }

    public void setNameOfShip(String nameOfShip) {

        this.nameOfShip = nameOfShip;

    }


    public String getNameOfShip() {

        return nameOfShip;

    }


    public void setDate(int dateBuilt) {

        this.dateBuilt = dateBuilt;

    }


    public int getDate() {

        return dateBuilt;

    }


    public void setXCoordinate(int xCoordinate) {

        this.xCoordinate = xCoordinate;

    }


    public int getXCoordinate() {

        return xCoordinate;

    }


    public void setYCoordinate(int yCoordinate) {

        this.yCoordinate = yCoordinate;

    }


    public int getYCoordinate() {

        return yCoordinate;

    }


    public void setType(String type) {

        this.type = type;

    }


    public String getType() {

        return type;

    }


    public void setArrPosition(int arrPos) {

        this.arrPos = arrPos;

    }


    public int getArrPosition() {

        return arrPos;

    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb = sb.append("Type: " + this.getType() + this.getArrPosition() + "\n");
        return sb.toString();
    }

}
