import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        String userName;
        int password = 0;
        int userNameLength = 10;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int passLength = 0;
        boolean length = true;

        System.out.println("Enter How Long You Want The Password (3-8)");


        passLength = scan.nextInt();

        while(length) {

            if (passLength < 3 || passLength > 8) {
                System.out.println("Enter Integer 3-8:");
                passLength = scan.nextInt();
                length = true;

            }else{length = false;}
        }



        for (int i = 0; i <= 100; i++) {

            StringBuilder sb = new StringBuilder(passLength);
            for (int j = 0; j < passLength; j++) {
                password = rand.nextInt(9);
                sb.append(password);
            }

            userName = getAlphaNumericString(userNameLength);
            System.out.println(userName);
            System.out.println(sb.toString());

            createUserFile1(userName, sb.toString());
            createUserFile2(userName, sb.toString());
            createUserFile3(userName, sb.toString());
        }

    }

    public static void createUserFile1(String userName, String password) throws IOException {
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

    public static byte[] createSalt() {
        byte[] bytes = new byte[1];
        return bytes;
    }

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
