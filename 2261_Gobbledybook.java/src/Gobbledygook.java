import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Gobbledygook {
    public static void main(String[] args) {

        // HashMap for storing each words and their frequency
        Scanner fileInput = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String filename = fileInput.next();

        // Using HashMap for basic implementaiion of Map interface of java. Stores data in (key, value) pairs
        //HashMap are lists of keys and values, different keys have different values
        HashMap<String,Integer> words = new HashMap<String,Integer>();

        try{
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            // Reading file line by line and splitting them with spaces and storing each word into the array
            while(scan.hasNextLine()) {

                String text = scan.nextLine();
                System.out.println(text);
                String data[] = text.split(" ");

                // Using loop to put each word into the HashMap
                //.put is a feature of java .put(key, value) that is used to insert a mapping into a map
                //key and value it is being mapped here
                // will know that every key is a string and each value is an integer
                for(int i = 0; i < data.length; i++) {

                    if(words.containsKey(data[i])) {


                        words.put(data[i], words.get(data[i]) + 1); // If word already present then incresing frequency by 1
                    }else{
                        words.put(data[i], 1); // Adding the word and setting frequency to 1
                    }

                }
            }

        }catch(FileNotFoundException e) {

            System.out.println("File Does not Exist. Please re-run the progaram.");
            System.exit(1);

        }

        //.keySet() is used to create a set out of the key elements in our hash map
        // Converting the key value pairs to our specific Array lists
        // names contains the words
        ArrayList<String> names = new ArrayList<>(words.keySet());

        // .values() is used to create a collection out of the values of the map.. returns a collection view of values
        // count contains the frequency
        ArrayList<Integer> count = new ArrayList<>(words.values());

        System.out.println("\nOur Parallel Array: ");

        //.size() is used to get the number of elements in the list
        for(int i = 0; i < names.size(); i++) {

            System.out.print("[" + names.get(i) + "] ");
        }

        System.out.println();
      //  System.out.println("\n\nThe Frequencies List");

        for(int i = 0; i < count.size(); i++) {

            System.out.print("[" + count.get(i) + "] " + "\t");
        }

        System.out.println();

        int sum = 0;
        // Finding the sum and modifying the count containing frequency
        for(int i = 0 ; i < count.size(); i++) {

            sum = sum + count.get(i);
            count.set(i, sum);
        }

        // Random object to generate random numbers
        System.out.println("\nOur Random Frequency: \n");
        Random rand = new Random();

        for(int i = 0; i < sum; i++) {

            int index = rand.nextInt(sum); // Generating the random numbers

            // Traversing the names to find the required index
            for(int j = 0; j < count.size(); j++) {

                // Printing the word from the correct index
                if(count.get(j) >= index) {
                    System.out.print(names.get(j) + " ");
                    break;
                }
            }
        }
    }
}