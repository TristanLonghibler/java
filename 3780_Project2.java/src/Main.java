import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;
import java.util.*;


public class Main {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String userName = "";
        String password = "";
        boolean finished = false;
        Scanner scan = new Scanner(System.in);

        while (!finished) {
            System.out.println("Would you like to create an account or authenticate your account?");
            System.out.println("1) Create Account");
            System.out.println("2) Authenticate Account");
            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.println("Enter UserName");
                scan.nextLine();
                userName = scan.nextLine();
                isValidUserName(userName);
                System.out.println("UserName is: " + userName);

                System.out.println("Enter Password:");
                password = scan.nextLine();
                isValidPassword(password);

                if (isValidUserName(userName) && isValidPassword(password)) {
                    createUserfile1(userName, password);
                    createUserFile2(userName, password);
                    createUserFile3(userName, password);
                }
            }

            if (choice == 2) {
                scan.nextLine();
                System.out.println("Enter the username");
                userName = scan.nextLine();
                System.out.println("Enter the password");
                password = scan.nextLine();

                verifyFile1(userName, password);
                verifyFile2(userName, password);
                verifyFile3(userName, password);
            }

            System.out.println("Finished? (y/n)");
            String end = scan.nextLine();
            if (end.equals("y")) {
                finished = true;
            }
        }
    }

    public static byte[] createSalt() {
        byte[] bytes = new byte[1];
        return bytes;
    }

    private static String generateShaHash(String password) throws NoSuchAlgorithmException {
        String algorithm = "SHA-256";
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        byte[] hash = digest.digest(password.getBytes());
        return bytesToStringHex(hash);
    }

    private static String generateSaltHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        String algorithm = "SHA-256";
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return bytesToStringHex(hash);
    }

    public static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    //Function to validate username for handling
    public static boolean isValidUserName(String userName) {
        String regexUser = "^[a-z]{1,10}$";
        //compile regex
        Pattern p = Pattern.compile(regexUser);

        if (userName == null) {
            return false;
        }
        //pattern class contains matcher() method
        //to find matching between given username and regex

        Matcher m = p.matcher(userName);
        if (!m.matches()) {
            System.out.println("Invalid UserName");
        }
        System.out.println("Is This A Valid Account?: " + m.matches());
        return m.matches();
    }

    //Function to validate password for handling
    public static boolean isValidPassword(String password) {
        String regexPassword = "^[0-9]{1,10}$";
        //compile regex
        Pattern p = Pattern.compile(regexPassword);

        if (password == null) {
            return false;
        }
        //pattern class contains matcher() method
        //to find matching between given username and regex

        Matcher m = p.matcher(password);
        if (!m.matches()) {
            System.out.println("Invalid Password");
        }
        System.out.println("Is This A Valid Password?: " + m.matches());
        return m.matches();
    }

    public static void createUserfile1(String userName, String password) throws IOException {
        File file1 = new File("first.txt"); // created file object file
        FileWriter fw = new FileWriter(file1, true); // created filewriter object called fw
        PrintWriter pw = new PrintWriter(fw); //created printwriter object pw
        pw.println(userName);
        pw.println(password);
        pw.close();
    }

    public static void createUserFile2(String userName, String password) throws NoSuchAlgorithmException, IOException {
        File file2 = new File("hash.txt"); // created file object file
        FileWriter fw = new FileWriter(file2, true); // created filewriter object called fw
        PrintWriter pw = new PrintWriter(fw); //created printwriter object pw
        pw.println(userName);
        pw.println(generateShaHash(password));
        pw.close();
    }

    public static void createUserFile3(String userName, String password) throws IOException, NoSuchAlgorithmException {
        byte[] salt = createSalt();
        //This makes our third file
        File saltFile = new File("saltHash.txt"); // created file object file
        FileWriter fw = new FileWriter(saltFile, true); // created filewriter object called fw
        PrintWriter pw = new PrintWriter(fw); //created printwriter object pw
        pw.println(userName);
        pw.println(generateSaltHash(password, salt));
        pw.close();

    }

    public static void verifyFile1(String username, String password) throws IOException {
        File file = new File("first.txt");
        boolean match = isUserPassMatch(username, password, file);
        if (match) {
            System.out.println("Username and password match for first.txt");
        } else {
            System.out.println("Credentials not found in first.txt");
        }
    }

    public static void verifyFile2(String username, String password) throws IOException, NoSuchAlgorithmException {
        File file = new File("hash.txt");
        password = generateShaHash(password);
        boolean match = isUserPassMatch(username, password, file);
        if (match) {
            System.out.println("Username and password match for hash.txt");
        } else {
            System.out.println("Credentials not found in hash.txt");
        }
    }

    public static void verifyFile3(String username, String password) throws IOException, NoSuchAlgorithmException {
        File file = new File("saltHash.txt");
        byte[] salt = createSalt();
        password = generateSaltHash(password, salt);
        boolean match = isUserPassMatch(username, password, file);
        if (match) {
            System.out.println("Username and password match for saltHash.txt");
        } else {
            System.out.println("Credentials not found in saltHash.txt");
        }
    }

    private static boolean isUserPassMatch(String username, String password, File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        boolean userMatch = false;
        boolean passMatch = false;
        int count = 0;
        String st;

        while ((st = br.readLine()) != null) {
            if (count % 2 == 0) {
                if (username.equals(st)) {
                    userMatch = true;
                }
            }

            if (count % 2 == 1) {
                if (password.equals(st)) {
                    passMatch = true;
                }
            }
            count++;
        }

        if (userMatch && passMatch) {
            return true;
        } else {
            return false;
        }
    }

}

