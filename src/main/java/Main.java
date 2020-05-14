import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            String userPassword = "Andisw1";
            if (PasswordChecker.passwordIsValid(userPassword)) {
                System.out.println("Password : " + userPassword + " : is Valid");
            } else {
                System.out.println("Password : " + userPassword + " : is InValid");
            }
            System.out.println("---------------------");
            if (PasswordChecker.passwordIsOkay(userPassword)) {
                System.out.println("Password : " + userPassword + " : is OK");
            } else {
                System.out.println("Password : " + userPassword + " : is not OK ");
            }
        }

    }


