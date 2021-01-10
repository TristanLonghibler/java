import java.util.*;


public class SpaceMain {

    public static void main(String[] args) {

        int choice = 0;
        int option = 0;
        int shipSelect = 0;
        int shipMenu = 0;
        int newShipChoice = 0;
        int direction = 0;


        Scanner scan = new Scanner(System.in);

        System.out.println("Hello user! We are going to be moving space objects through a 10X10 grid!");
        System.out.println("How many SpaceObjects would you like to work with? (1-9)\n");

        //error checker finds first char value and makes sure input is good
        char charOption;
        boolean flagGo = true;
        while (flagGo) {
            charOption = scan.next().charAt(0);
            if (Character.isDigit(charOption)) {
                choice = Character.getNumericValue(charOption);
                if (choice >= 1 && choice <= 9) {
                    flagGo = false;
                } else {
                    System.out.println("Please enter a number between 1 - 9 inclusive");
                }
            } else {
                System.out.println("Please enter a digit for the choice");
            }
        }

        //Making our array list of objects
        ArrayList<SpaceObject> spaceArr = new ArrayList<SpaceObject>();


        //For each choice, print out what type of ship they want and go through the case statement to define the ships and adds them to
        for (int i = 0; i < choice; i++) {

            System.out.println("Please choose which type of ship(s) you would like to start out with: ");
            System.out.println("(1) CargoShip");
            System.out.println("(2) PirateShip");
            System.out.println("(3) SpaceStation");

            //error checker
            boolean flag = true;
            while (flag) {
                charOption = scan.next().charAt(0);
                if (Character.isDigit(charOption)) {
                    option = Character.getNumericValue(charOption);
                    if (option >= 1 && option <= 3) {
                        flag = false;
                    } else {

                        System.out.println("Please enter a number between 1 - 3 inclusive");
                    }
                } else {
                    System.out.println("Please enter a digit for the choice");
                }
            }

            //Case statement of what ship will be made, along with its attributes
            switch (option) {

                case 1:
                    CargoShip cargoShip = new CargoShip();
                    System.out.println("Please pick a name for your cargoShip: ");
                    scan.nextLine();
                    cargoShip.setNameOfShip(scan.nextLine());
                    cargoShip.setArrPosition(i);
                    spaceArr.add(cargoShip); //This object has been added to spaceArr list
                    break;
                case 2:
                    PirateShip pirateShip = new PirateShip();
                    System.out.println("Please pick a name for your pirateShip: ");
                    scan.nextLine();
                    pirateShip.setNameOfShip(scan.nextLine());
                    System.out.println("\n");
                    pirateShip.setArrPosition(i);
                    spaceArr.add(pirateShip); //This object has been added to spaceArr list
                    break;
                case 3:
                    SpaceStation stationShip = new SpaceStation();
                    System.out.println("Please pick a name for your SpaceStation: ");
                    scan.nextLine();
                    stationShip.setNameOfShip(scan.nextLine());
                    stationShip.setArrPosition(i);
                    spaceArr.add(stationShip); //This object has been added to spaceArr list
                    break;
                default:
                    System.out.println("You have chosen an integer that is not 1, 2, or 3. We shall make a pirateShip: ");
                    pirateShip = new PirateShip();
                    System.out.println("Please pick a name for your cargoShip: ");
                    scan.nextLine();
                    pirateShip.setNameOfShip(scan.nextLine());
                    pirateShip.setArrPosition(i);
                    spaceArr.add(pirateShip);//This object has been added to spaceArr list (which wont happen with my error check (1-3))
                    break;
            }

        }


        //For each ship made with random x, y coordinates. This will loop through the objects and make sure that they
        //do not have matching x, y coordinates. It will replace a random number 1 to 10 if they do have the same number
        for (SpaceObject i : spaceArr) {
            for (int j = 0; j < choice; j++) {
                if (i.getXCoordinate() == spaceArr.get(j).getXCoordinate()) {
                    if (i.getYCoordinate() == spaceArr.get(j).getYCoordinate()) {
                        Random rand = new Random();
                        int min = 1;
                        int max = 10;

                        spaceArr.get(j).setXCoordinate(rand.nextInt(max - min + 1) + min);
                        spaceArr.get(j).setYCoordinate(rand.nextInt(max - min + 1) + min);
                    }
                }
            }
        }

        //This will be an infinite loop (while true) and first displays the map and then stores the new changes we shall make to be displayed later on
        do {
            System.out.println(displayWorld(spaceArr));

            for (SpaceObject i : spaceArr) {
                System.out.println(i);
            }

            System.out.println("\nWhich ship do you wish to do something with?");
            System.out.println("(0) Quit the program");

            //Adding one allows our menu to be chosen the way it prints out later
            for (int i = 0; i < spaceArr.size(); i++) {
                System.out.println(i + 1 + ". " + spaceArr.get(i).getType() + spaceArr.get(i).getArrPosition());
            }
            System.out.println("Please enter 0 to exit the game, or type any other integer to continue: ");

            // error check for shipSelect
            boolean flag = true;
            while (flag) {
                charOption = scan.next().charAt(0);
                if (Character.isDigit(charOption)) {
                    shipSelect = Character.getNumericValue(charOption);
                    if (shipSelect >= 0 && shipSelect <= 9) {
                        flag = false;
                    } else {
                        System.out.println("Please enter either 0 or 1: ");
                    }
                } else {
                    System.out.println("Please enter a digit for the new choice:");
                }
            }

            //case 0 ends the game or you can type in 1 to continue to the default case, which prompts you to a new menu for changing the ship or moving the ship
            switch (shipSelect) {
                case 0:    // User option to quit the program.
                    System.out.println("Ending program.");
                    System.exit(0);
                default:
                    System.out.println("What would you like to do with this ship?: ");
                    System.out.println("(1) Change ship type");
                    System.out.println("(2) Move ship");

                    boolean flagMenu = true;
                    while (flagMenu) {
                        charOption = scan.next().charAt(0);
                        if (Character.isDigit(charOption)) {
                            shipMenu = Character.getNumericValue(charOption);
                            if (shipMenu >= 1 && shipMenu <= 2) {
                                flagMenu = false;
                            } else {
                                System.out.println("Please enter a number between 1 - 2 inclusive");
                            }
                        } else {
                            System.out.println("Please enter a digit for the choice");
                        }
                    }
                    //This is the main menu for the ships. 1 being change the ship type and gives a message if you recreate the same ship
                    //And 2 will bring you to the movement menu of the ships
                    switch (shipMenu) {
                        case 1:
                            System.out.println("What Space Object would you like to create?");
                            System.out.println("(1) CargoShip");
                            System.out.println("(2) Pirate Ship");
                            System.out.println("(3) Space Station");

                            //error check for newShipChoice
                            boolean flagChoice = true;
                            while (flagChoice) {
                                charOption = scan.next().charAt(0);
                                if (Character.isDigit(charOption)) {
                                    newShipChoice = Character.getNumericValue(charOption);
                                    if (newShipChoice >= 0 && newShipChoice <= 3) {
                                        flagChoice = false;
                                    } else {
                                        System.out.println("Please enter a number between 1 - 3 inclusive");
                                    }
                                } else {
                                    System.out.println("Please enter a digit for the choice");
                                }
                            }

                            //Case statement for what ship you will be changing to
                            switch (newShipChoice) {
                                case 1:
                                    if (spaceArr.get(shipSelect - 1).getType() == "C") {
                                        System.out.println("This is already a Cargo Ship!\n");
                                    } else {
                                        CargoShip cargoShip = new CargoShip();
                                        cargoShip.setNameOfShip(spaceArr.get(shipSelect - 1).getNameOfShip());
                                        cargoShip.setDate(spaceArr.get(shipSelect - 1).getDate());
                                        cargoShip.setXCoordinate(spaceArr.get(shipSelect - 1).getXCoordinate());
                                        cargoShip.setYCoordinate(spaceArr.get(shipSelect - 1).getYCoordinate());
                                        cargoShip.setArrPosition(spaceArr.get(shipSelect - 1).getArrPosition());
                                        spaceArr.set((shipSelect - 1), cargoShip);

                                    }
                                    break;
                                case 2:
                                    if (spaceArr.get(shipSelect - 1).getType() == "P") {
                                        System.out.println("This is already a Pirate Ship!\n");
                                    } else {
                                        PirateShip pirateShip = new PirateShip();
                                        pirateShip.setNameOfShip(spaceArr.get(shipSelect - 1).getNameOfShip());
                                        pirateShip.setDate(spaceArr.get(shipSelect - 1).getDate());
                                        pirateShip.setXCoordinate(spaceArr.get(shipSelect - 1).getXCoordinate());
                                        pirateShip.setYCoordinate(spaceArr.get(shipSelect - 1).getYCoordinate());
                                        pirateShip.setArrPosition(spaceArr.get(shipSelect - 1).getArrPosition());
                                        spaceArr.set((shipSelect - 1), pirateShip);

                                    }
                                    break;
                                case 3:
                                    if (spaceArr.get(shipSelect - 1).getType() == "@") {
                                        System.out.println("This is already a Space Station!\n");
                                    } else {
                                        SpaceStation spaceStation = new SpaceStation();
                                        spaceStation.setNameOfShip(spaceArr.get(shipSelect - 1).getNameOfShip());
                                        spaceStation.setDate(spaceArr.get(shipSelect - 1).getDate());
                                        spaceStation.setXCoordinate(spaceArr.get(shipSelect - 1).getXCoordinate());
                                        spaceStation.setYCoordinate(spaceArr.get(shipSelect - 1).getYCoordinate());
                                        spaceStation.setArrPosition(spaceArr.get(shipSelect - 1).getArrPosition());
                                        spaceArr.set((shipSelect - 1), spaceStation);

                                    }
                                    break;
                                default:
                                    System.out.println("This is not a valid option. Please re-run the program: ");
                                    System.exit(1);
                                    break;
                            }
                            break;


                        //This is part two of the menu which allows you to move your ships
                        case 2:
                            System.out.println("Which direction do you wish to move?");
                            System.out.println("(1) North");
                            System.out.println("(2) South");
                            System.out.println("(3) West");
                            System.out.println("(4) East");

                            //error check for direction
                            boolean flagDecision = true;
                            while (flagDecision) {
                                charOption = scan.next().charAt(0);
                                if (Character.isDigit(charOption)) {
                                    direction = Character.getNumericValue(charOption);
                                    if (direction >= 1 && direction <= 4) {
                                        flagDecision = false;
                                    } else {
                                        System.out.println("Please enter a number between 1 - 4 inclusive");
                                    }
                                } else {
                                    System.out.println("Please enter a digit for the choice");
                                }
                            }

                            int newx = 0;
                            int newy = 0;

                            //case statement that goes through each case ( North,South,West,East) and impliments
                            // the method onto either the cargoShip if it is "C" or to the pirateShip if it is "P"
                            switch (direction) {
                                case 1:
                                    int x = 0;
                                    int y = -1;

                                    if (spaceArr.get(shipSelect - 1).getType() == "C") {
                                        SpaceObject tempCargo;
                                        tempCargo = spaceArr.get(shipSelect - 1);
                                        newx = tempCargo.getXCoordinate() + x;
                                        newy = tempCargo.getYCoordinate() + y;
                                        ((CargoShip) tempCargo).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);

                                    } else if (spaceArr.get(shipSelect - 1).getType() == "P") {
                                        SpaceObject tempPirate;
                                        tempPirate = spaceArr.get(shipSelect - 1);
                                        newx = tempPirate.getXCoordinate() + x;
                                        newy = tempPirate.getYCoordinate() + y;
                                        spaceArr = checkSpot(spaceArr, newx, newy);
                                        ((CargoShip) tempPirate).moveShip(x, y);
                                    }
                                    break;
                                case 2:
                                    x = 0;
                                    y = 1;

                                    if (spaceArr.get(shipSelect - 1).getType() == "C") {
                                        SpaceObject tempCargo;
                                        tempCargo = spaceArr.get(shipSelect - 1);
                                        newx = tempCargo.getXCoordinate() + x;
                                        newy = tempCargo.getYCoordinate() + y;
                                        ((CargoShip) tempCargo).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);
                                    } else if (spaceArr.get(shipSelect - 1).getType() == "P") {
                                        SpaceObject tempPirate;
                                        tempPirate = spaceArr.get(shipSelect - 1);
                                        newx = tempPirate.getXCoordinate() + x;
                                        newy = tempPirate.getYCoordinate() + y;
                                        ((PirateShip) tempPirate).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);

                                    }
                                    break;
                                case 3:
                                    x = -1;
                                    y = 0;

                                    if (spaceArr.get(shipSelect - 1).getType() == "C") {
                                        SpaceObject tempCargo;
                                        tempCargo = spaceArr.get(shipSelect - 1);
                                        newx = tempCargo.getXCoordinate() + x;
                                        newy = tempCargo.getYCoordinate() + y;
                                        ((CargoShip) tempCargo).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);
                                    } else if (spaceArr.get(shipSelect - 1).getType() == "P") {
                                        SpaceObject tempPirate;
                                        tempPirate = spaceArr.get(shipSelect - 1);
                                        newx = tempPirate.getXCoordinate() + x;
                                        newy = tempPirate.getYCoordinate() + y;
                                        ((PirateShip) tempPirate).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);
                                    }
                                    break;
                                case 4:
                                    x = 1;
                                    y = 0;

                                    if (spaceArr.get(shipSelect - 1).getType() == "C") {
                                        SpaceObject tempCargo;
                                        tempCargo = spaceArr.get(shipSelect - 1);
                                        newx = tempCargo.getXCoordinate() + x;
                                        newy = tempCargo.getYCoordinate() + y;
                                        ((CargoShip) tempCargo).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);
                                    } else if (spaceArr.get(shipSelect - 1).getType() == "P") {
                                        SpaceObject tempPirate;
                                        tempPirate = spaceArr.get(shipSelect - 1);
                                        newx = tempPirate.getXCoordinate();
                                        newy = tempPirate.getYCoordinate();
                                        ((PirateShip) tempPirate).moveShip(x, y);
                                        spaceArr = checkSpot(spaceArr, newx, newy);
                                    }
                                    break;
                                default:
                                    System.out.print("Please select a valid option");
                                    break;
                            }

                    }

            }
        } while (true);
    }

    //This will display our 10X10 grid, as well as append a | at the start of each row and **| for each column, making it look like space/project example
    public static String displayWorld(ArrayList<SpaceObject> tempArr) {
        int row = 10;
        int col = 10;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            sb = sb.append("|");
            for (int j = 0; j < col; j++) {
                String tempString = "**|";
                for (SpaceObject s : tempArr) {
                    if (s.getXCoordinate() == (j + 1) && s.getYCoordinate() == (i + 1)) {
                        tempString = s.getType() + s.getArrPosition() + "|";
                    }
                }
                sb.append(tempString);
            }
            sb = sb.append("\n");
        }
        return sb.toString();
    }


    //Function to check and delete ships in arrayList if they have the same X,y Coords
    public static ArrayList<SpaceObject> checkSpot(ArrayList<SpaceObject> spaceArr, int x, int y) {
        int matchCounter = 0;


        for (int i = 0; i < spaceArr.size(); i++) {
            if (spaceArr.get(i).getXCoordinate() == x && spaceArr.get(i).getYCoordinate() == y) {
                matchCounter += 1;
            }
        }

        if (matchCounter == 2) {
            for (int j = 0; j < spaceArr.size(); j++) {
                if (spaceArr.get(j).getXCoordinate() == x && spaceArr.get(j).getYCoordinate() == y) {
                    System.out.println("Ship Collision! Destroying Ships.");
                    spaceArr.remove(j);
                    break;
                }
            }

            for (int k = 0; k < spaceArr.size(); k++) {
                if (spaceArr.get(k).getXCoordinate() == x && spaceArr.get(k).getYCoordinate() == y) {
                    spaceArr.remove(k);
                    break;
                }
            }
        }

        return spaceArr;
    }


}