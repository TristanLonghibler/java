
import java.util.*;

public class Tristans_Simulator {

    public static void main (String [] args) {

        String humanName;
        boolean value = true;
        int humanNumber;
        int	choice;

        Scanner input = new Scanner(System.in);

        System.out.println("This is a simulation of multiple humans that own dogs. You will control what each human\n"
                +"does with their time. Your choices for them reflect the overall happiness of their pets, 100 being \nthe best score. If at any " +
                "point a human's pet runs out of food, fun, or if the human becomes bankrupt, the \ngame will end. You" +
                " can make one decision for each human a day. After you give your commands, \neach human will go to" +
                "bed, which will cause their pets to become a little more hungry and bored. \n\n");

        /*Prompt for number of humans*/
        System.out.println("Enter the number of humans you would like to have in this simulation: ");
        humanNumber = input.nextInt();

        /*Creates and array list of human objects*/
        ArrayList <Human> humanList = new ArrayList<Human>();

        /*for loop adds humans names to array*/
        for (int i = 0; i < humanNumber; i++) {
            System.out.println("Name your human:\n ");

            humanName = input.next();

            humanList.add(new Human(humanName)); //add to array list
        }



        Boolean rerunInner;
        while (value) {
            rerunInner = true;

            System.out.println("\nCurrent humans in the list\n");
            for(int i = 0; i < humanNumber; i++) {
                System.out.println(humanList.get(i).toString());
            }

            System.out.println("\n");

            while(rerunInner){
                for(int i = 0; i < humanNumber; i++) {
                    System.out.println((i + 1) + ") " + humanList.get(i).getName());
                }


                System.out.println("Which human would you like to use?");
                int humanChoice = input.nextInt() - 1;
                System.out.println("I Selected  " + humanList.get(humanChoice).toString());


                System.out.println("\n\nWhat would you like to do for " + humanList.get(humanChoice).getName() + "'s dog?\n\n1)Bathe dog \n2)Feed dog \n3)Walk dog "
                        + "\n4)Go to work \n5)Buy dog food \n6)Do Nothing! \n7)Exit Game");
                choice = input.nextInt();


                switch (choice) {


                    case 1:
                        System.out.println(humanList.get(humanChoice).getName() + " has decided to clean his dog(s) and they are not super happy about it, \n"
                                + "but they are so clean now!");
                        humanList.get(humanChoice).batheDog();
                        break;

                    case 2:
                        System.out.println(humanList.get(humanChoice).getName() + " has decided to feed the dog(s) they are less hungry, your"
                                + " food supply has been reduced.");
                        humanList.get(humanChoice).feedDog();
                        break;

                    case 3:
                        System.out.println(humanList.get(humanChoice).getName() + " has decided to take his dog(s) for a walk. They are happier but"
                                + " they got a little dirty! \nI think they are starting to get hungry again.");
                        humanList.get(humanChoice).walkDog();
                        break;

                    case 4:
                        System.out.println(humanList.get(humanChoice).getName() + " has decided to go to work and make a little extra cash for "
                                + "the dogs!");
                        humanList.get(humanChoice).goToWork();
                        break;

                    case 5:
                        System.out.println(humanList.get(humanChoice).getName() + " has decided to go buy dog food to keep your dogs alive just"
                                + " a bit longer!");
                        humanList.get(humanChoice).buyFood();
                        break;

                    case 6:
                        System.out.println(humanList.get(humanChoice).getName() + " decided to stay in bed all day");
                        break;
                    case 7:
                        System.out.println("Thank you for playing!");

                        //You had system.exit   dont wnna do that here since they exited properly
                        //and you still want to display some data
                        value = false;
                        break;
                    default:
                        System.out.println("Incorrect choice exiting game.");
                        System.exit(0);


                }

                System.out.println("Would you like to keep working with this day? <yes,no>");
                String option = input.next();

                if(option.equals("no")){
                    rerunInner = false;
                }
            }

            //checking loyalty
            for(int i = 0; i < humanNumber; i++) {
                humanList.get(i).checkingLoyalty();
                humanList.get(i).checkingStarvation();
                humanList.get(i).checkingFun();
                humanList.get(i).moneyFoodCheck();
              //  humanList.get(i).settingFun();



                //Passing time if loyalty levels allow it, calls method that changes dogs that day
                humanList.get(i).passTheTime();
            }


            System.out.println("\nThe humans have left to sleep tonight. They will be back tomorrow. The humans dogs have become a little hungry and bored.");

        }
        scan.close();
    }

}
