
import java.util.*;

public class Human {

    private String name;
    private double weight;
    private double money;
    private int dogfood;
    private int dogNumber;

    /*Constructor that takes in a string for the name and creates a human object that generates
     * dogs and other attributes*/
    Human (String name) {
        money = 100.00;
        dogfood = 100;
        setName(name);
        setRandomWeight();
        createDogs(dogList);
    }

    private ArrayList<Dogs> dogList = new ArrayList<Dogs>();


    /*Setter methods for private variables*/
    public void setName(String str) {
        name = str;
    }

    public void setWeight(double w) {
        weight = w;
    }

    /*Getter methods for private variables*/
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }


    /*Creates random number and sets to
     * Mammals weight*/
    public void setRandomWeight() {
        int createWeight;

        createWeight = (int)(90.00 + Math.random() * 171);

        setWeight(createWeight);
    }

    /*Generates random number of dogs and saves each
     * object to an object ArrayList the dogs are created
     * with a constructor that takes a string for the name*/
    public void createDogs(ArrayList <Dogs> dogList) {

        Scanner input = new Scanner(System.in);
        String dogName;
        //set dog number random 1 to 2
        dogNumber =  (int)(1 + Math.random() * 2);

        System.out.println(getName() + " has " + (dogNumber) + " dog(s).");

        for(int i = 0; i < dogNumber; i++) {
            System.out.println("Pick a name for your dog: ");
            dogName = input.nextLine();
            dogList.add(new Dogs(dogName));
        }
    }


    /*Function to clean dog*/
    public void batheDog() {

        for(int i = 0; i < dogNumber; i++) {
            int bathe = dogList.get(i).getFun();

            dogList.get(i).setCleanliness(100); //sets back at 100
            dogList.get(i).setFun((int)(bathe -= (bathe * 0.25)));	// animals hate being cleaned
        }
    }


    /*Function to feed dogs and set its values when called sets hunger to 25% more and dogfood to -20 per dog*/
    public void feedDog() {

        for(int i = 0; i < dogNumber; i++) {
            int h = dogList.get(i).getHunger(); //

            dogList.get(i).setHunger((int) (h + (h * 0.50)));
        }
        dogfood -= (dogNumber * 25);
    }



    /*Function to set attributes based on walk dog choice. */
    public void walkDog() {

        for(int i = 0; i < dogNumber; i++) {
            int cleanliness = dogList.get(i).getCleanliness();
            int funLevel = dogList.get(i).getFun();
            int hungerLevel = dogList.get(i).getHunger();

            dogList.get(i).setHunger((int) (hungerLevel - (hungerLevel * 0.30)));
            dogList.get(i).setCleanliness((int) (cleanliness - (cleanliness * 0.30)));
            dogList.get(i).setFun((int) (funLevel + (funLevel * 0.40)));
        }
    }

    public void checkingLoyalty() {

        for(int i = 0; i < dogNumber; i++) {
            dogList.get(i).getLoyalty();
        }

    }

    public void checkingStarvation() {
        for(int i = 0; i < dogNumber; i++) {
            dogList.get(i).getHunger();
        }
    }

    public void checkingFun() {
        for(int i = 0; i < dogNumber; i++) {
            dogList.get(i).getFun();
        }
    }


    /*Function that changes attributes from go to work choice*/
    public void goToWork() {
        money += 20;

        for (int i = 0; i < dogNumber; i++) {

            int h = dogList.get(i).getHunger();
            int b = dogList.get(i).getFun();

            dogList.get(i).setFun((int) (b - (b * 0.10)));
            dogList.get(i).setHunger((int) (h - (h * 0.30)));
        }
    }


    /*Function that changes money and food from buy food choice */
    public void buyFood() {
        dogfood += 30;
        money -= 20;
    }

    /*Function checks if you ran out of food and restocks food and if you run out of money the game ends*/
    public void moneyFoodCheck() {
        if ( dogfood <= 0 ) {
            dogfood += 40; //increase food by 40
            money -= 20;  //decrease 20 dollars from human
        }

        if ( money <= 0) {
            System.out.println( getName() + " has ran out of money, The dog(s) have decided to leave you.\n\nGAME OVER");
            System.exit(0);
        }
    }

    /*Function that is called at the end of the loop every time to signal a day change and to adjust stats accordingly */
    public void passTheTime() {

        for (int i = 0; i < dogNumber; i++) {

            int h = dogList.get(i).getHunger();
            int b = dogList.get(i).getFun();

            dogList.get(i).setFun((int) (b - (b * 0.10)));
            dogList.get(i).setHunger((int) (h - (h * 0.30)));

        }
    }
    //toString has other methods and it is good practice to always Override your toString methods
    /*toString for human that stores all human attributes and their dogs
     * attributes and returns the string of all the information*/
    @Override
    public String toString() {

        String humanAttributes;

        moneyFoodCheck();
//he java string format() method returns a formatted string using the given locale
        //.replace will remove arrayList printout of [ , and ] to make output look better
        humanAttributes =  "\n" + getName() + " - \n" + "\nWeight: " + getWeight() + "\nMoney: " +
                String.format("%.2f", money) + "\nDog food: " + dogfood + "\n\n" + getName() + "'s dog(s): \n\n"
                + dogList.toString().replace("[","").replace(",", "").replace("]", "");

        return humanAttributes  ;
    }


}
