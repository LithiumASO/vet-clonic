package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String FIRSTNAME_PATTERN = "[a-zA-Z]{2,}";
    static String LASTNAME_PATTERN = "[a-zA-Z]{2,}";


    public static void main(String[] args) {
        run();
    }
    static void run() {
        if (auth()){
            registerNewClient();
        }

    }
    static boolean auth() {
        boolean accepted = false;
        for (int i=0;i <3; i++){
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)){
                accepted = true;
                break;
            }else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }
    static void registerNewClient(){
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        System.out.print("Firstname: ");
        String firstname = SCANNER.nextLine();
        System.out.print("Lastname: ");
        String lastname = SCANNER.nextLine();
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
            System.out.println("New cleint: " + client.firstName + " " + client.lastName + " " + " (" + client.email + ")");
        }
    }

    static Client buildClient(String email , String firstname, String lastname) {
        Client client = new Client();
        client.email = email;
        client.firstName = firstname;
        client.lastName = lastname;
        return client;

    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    static boolean isFirstNameValid(String firstname) {
        Pattern pattern = Pattern.compile(FIRSTNAME_PATTERN);
        Matcher matcher = pattern.matcher(firstname);
        return matcher.matches();
    }
    static boolean isLastNameValid(String lastname) {
        Pattern pattern = Pattern.compile(LASTNAME_PATTERN);
        Matcher matcher = pattern.matcher(lastname);
        return matcher.matches();
    }
}