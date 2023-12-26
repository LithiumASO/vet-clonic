package main.java.com.magicvet.servise;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String FIRSTNAME_PATTERN = "[a-zA-Z]{2,}";
    private static String LASTNAME_PATTERN = "[a-zA-Z]{2,}";

    public Client registerNewClient(){

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        System.out.print("Firstname: ");
        String firstname = Main.SCANNER.nextLine();
        System.out.print("Lastname: ");
        String lastname = Main.SCANNER.nextLine();
        boolean userValid = true;

        if (!isEmailValid(email)) {
            userValid = false;
            System.out.println("Provided email is invalid.");
        }
        if (!isFirstNameValid(firstname)){
            userValid = false;
            System.out.println("Provided firsname is invalid.");}
        if (!isLastNameValid(lastname)){
            userValid = false;
            System.out.println("Provided lastname is invalid.");}
        if (userValid) {
            Client client = buildClient(email, firstname, lastname);
            System.out.println("New cleint: " + client.getFirstName() + " "
                    + client.getLastName()+ " "
                    + " (" + client.getEmail() + ")");
            return client;
        }
        return null;
    }
    private static Client buildClient(String email , String firstname, String lastname) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstname);
        client.setLastName(lastname);
        return client;

    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isFirstNameValid(String firstname) {
        Pattern pattern = Pattern.compile(FIRSTNAME_PATTERN);
        Matcher matcher = pattern.matcher(firstname);
        return matcher.matches();
    }
    private static boolean isLastNameValid(String lastname) {
        Pattern pattern = Pattern.compile(LASTNAME_PATTERN);
        Matcher matcher = pattern.matcher(lastname);
        return matcher.matches();
    }
}
