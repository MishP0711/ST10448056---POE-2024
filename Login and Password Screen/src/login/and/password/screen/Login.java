/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.and.password.screen;

import java.util.regex.Pattern;
import java.util.Scanner;

/*
 *
 * @author misha
 */
public class Login {

    private static final String USERNAME_REGEX = "^[a-zA-Z]{1,5}$, _ ";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static boolean checkUserName(String userName) {
        return Pattern.matches(USERNAME_REGEX, userName);
    }

    public static boolean checkPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    //Tells user to format the username with an underscore
    public static boolean login(String userName, String password) {
        if (!checkUserName(userName)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
        //Tell the user to have at least 8 characters, a capital letter, a number and a special chrater

        if (!checkPassword(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return false;
        }

        System.out.println("Welcome " + getUserFirstName(userName) + " " + getUserLastName(userName) + " it is great to see you again.");
        return true;
    }

    public static String getUserFirstName(String userName) {
        return userName.split("_")[0];
    }

    public static String getUserLastName(String userName) {
        return userName.split("_")[1];
    }

    // Program that shows an input for the user 
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Shows a message error to the user if a field is not completed 
            System.out.print("Enter your username: ");
            String userName = scanner.next();

            System.out.print("Enter your password: ");
            String password = scanner.next();

            if (login(userName, password)) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

            if (checkUserName(userName)) {
                System.out.println("Username correctly formatted");
            } else {
                System.out.println("Username incorrectly formatted");
            }

            if (checkPassword(password)) {
                System.out.println("Password meets complexity requirements");
            } else {
                System.out.println("Password does not meet complexity requirements");
            }
        }
    }
}
