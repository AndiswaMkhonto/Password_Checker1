import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    
    static Pattern digitCasePatten = Pattern.compile("[0-9]+");
    static Pattern UpperCasePatten = Pattern.compile(".*[A-Z].*");
    static Pattern specialCharPatten = Pattern.compile("[!@#$%^&()_~.?/,*;+=-]" , Pattern.CASE_INSENSITIVE);
    static Pattern lowerCasePatten = Pattern.compile(".*[a-z].*");


    private static ArrayList<String> listOfErrors= new ArrayList<>();
    public static boolean passwordIsValid(String yourPassword ){


        Matcher mac = digitCasePatten.matcher(yourPassword);
        Matcher letters = UpperCasePatten.matcher(yourPassword);
        Matcher lowc = lowerCasePatten.matcher(yourPassword);
        Matcher special = specialCharPatten.matcher(yourPassword);


        boolean flag = true;
        if(yourPassword.isEmpty()){
            System.out.println("password does not exist ");
            flag = false;
            listOfErrors.add("password does not exist ");
        }

        if (yourPassword.length() < 8) {
            System.out.println("Password length must have at least 8 character !!");
            flag = false;
            listOfErrors.add("Password length must have at least 8 character !!");
        }
        if (!specialCharPatten.matcher(yourPassword ).find()) {
            System.out.println("Password must have at least one special character !!");
            flag = false;
            listOfErrors.add("Password must have at least one special character !!");
        }
        if (!UpperCasePatten.matcher(yourPassword ).find()) {
            System.out.println("Password must have at least one uppercase character !!");
            flag = false;
            listOfErrors.add("Password must have at least one uppercase character !!");
        }
        if (!lowerCasePatten.matcher(yourPassword ).find()) {
            System.out.println("Password must have at least one lowercase character !!");
            flag = false;
            listOfErrors.add("Password must have at least one lowercase character !!");
        }
        if (!digitCasePatten.matcher(yourPassword ).find()) {
            System.out.println("Password must have atleast one digit character !!");
            flag = false;
            listOfErrors.add("Password must have atleast one digit character !!");
        }
        return flag;
    }
    public static boolean passwordIsOkay(String password){



        Matcher mac = digitCasePatten.matcher(password);
        Matcher letters = UpperCasePatten.matcher(password);
        Matcher special = specialCharPatten.matcher(password);
        Matcher lower = lowerCasePatten.matcher(password);
        try {
            for (int i = 0; i < password.length(); i += 1) {
                if (password.length() > 7) {
                    if ((mac.find() && letters.find()) || (mac.find() && special.find()) ||
                            (letters.find() && special.find()) || (lower.find() && letters.find()) ||
                            (lower.find() && special.find()) || (mac.find() && lower.find())){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        catch (Exception w){
            System.out.println(w.getMessage());
        }
        return false;

    }
}
