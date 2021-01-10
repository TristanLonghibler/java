
import java.util.*;

public class Dogs {

    private String name;
    private double weight;
    private int hunger;
    private int fun;
    private int cleanliness;
    private int loyalty;

    //Constructor for dog that creates dog with a name
    Dogs(String name) {

        setName(name);
        setDogHunger();
        setDogWeight();
        setDogCleanliness();
        setDogFun();
        setLoyalty();

    }



    /*Setter methods for private variables*/
    public void setName(String n) {
        name = n;
    }

    public void setWeight(double w) {
        weight = w;
    }

    /*Keeps hunger at 100 or less*/
    public void setHunger(int h) {

        if( h <= 100 )
            hunger = h;
        else
            hunger = 100;
    }

    //Method to set loyalty based
    private void setLoyalty() {
        int tempFun = getFun();
        int	tempHunger = getHunger();

        if (tempFun > tempHunger) {
            loyalty = tempFun;
        }
        else
            loyalty = tempHunger;
    }

    /*Method to set cleanliness by generting a random number
     * between 30-100 Min +(Math.random() * (max-min)*/
    public void setDogCleanliness() {
        int randomClean;

        randomClean = (int)(30 + Math.random() * 81);
        cleanliness = randomClean;

        if (cleanliness > 100) {
            cleanliness = 100;
        }

    }


    /*Method to set Fun by generating a number between 30-100*/
    public void setDogFun() {
        int randomFun;

        randomFun = (int)(30 + Math.random() * 81); //sets value 0-80 and adds 20 to make 0-100
        fun = randomFun;

        if(fun > 100) {
            fun = 100;
        }
    }

    /*Method to set hunger by generating a number between 30-100*/
    public void setDogHunger() {
        int randomHunger;

        randomHunger = (int)(30 + Math.random() * 81);
        setHunger(randomHunger);
    }

    /*Method to set Weight by generating a number between 15-85*/
    public void setDogWeight() {
        int randomWeight;

        randomWeight = (int)(15 + Math.random() * 86);

        setWeight(randomWeight);
    }

    /*Setter method that keeps fun at 100 or less*/
    public void setFun(int f) {

        if ( f <= 100 )
            fun = f;
        else
            fun = 100;
    }

    /*Setter method that sets cleanliness keeping it at 100
     * or less*/
    public void setCleanliness(int c) {
        if(c <= 100) {
            cleanliness = c;
        }else{
            cleanliness = 100;
        }
    }

    /*Function that is called to check loyalty of dogs if it is less than zero then the program is ended*/
    public void checkLoyalty() {
        if (loyalty <= 0) {
            System.out.println("\n" + getName() + " has lost all loyalty to its owner and has "
                    + "decided to leave you. Be a better caregiver.\n\nGAME OVER");
            System.exit(0);
        }
    }
    // Function that is called to check starving dogs and ends the program if they are too hungry
    public void checkStarvation() {
        if (hunger <= 0) {
            System.out.println("\n" + getName() + " has not been fed and needs food. " + getName()
                    + " decided to leave you. Be a better caregiver.\n\nGAME OVER");
            System.exit(0);
        }
    }
    // Function that is called to check the happiness of dog and if fun is too low it ends the game
    public void checkFun() {
        if (fun <= 0) {
            System.out.println("\n" + getName() + " has not been given enough attention. " + getName()
                    + " decided to leave you. Be a better caregiver.\n\nGAME OVER");
            System.exit(0);
        }
    }



    /*Getter methods to return values to the string method for statistics*/
    public int getFun() {
        return fun;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getHunger() {
        return hunger;
    }

    //toString has other methods and it is good practice to always Override toString
    @Override
    public String toString() {
        setLoyalty();
        checkLoyalty();
        checkStarvation();
        checkFun();

        return  " Name: " + getName() + "\nWeight: " + getWeight() + "\nHunger: " + getHunger()
                + "\nFun: " + fun + "\nCleanliness: " + cleanliness + "\nLoyalty: " + getLoyalty() + "\n";
    }

}
