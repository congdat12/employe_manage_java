package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Validator {
    public static String getString(BufferedReader br, String prompt) {
        String st = "";
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                st = br.readLine().trim();
                isValid = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return st;
    }

    public static int getInt(BufferedReader br, String prompt) {
        int value = 0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
        return value;
    }

    public static float getFloat(BufferedReader br, String prompt) {
        float value = 0.0f;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = Float.parseFloat(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
        return value;
    }

    public static double getDouble(BufferedReader br, String prompt) {
        double value = 0.0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(br.readLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid number, try again");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!isValid);
        return value;
    }

    public static boolean emailIsValid(String email) {
        String emailPattern =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return Pattern.matches(emailPattern, email);
        // đoạn trên là dùng regex(Regular Exception) để check định dạng của mail người dùng nhập vào
        // trả về true false
    }

    public static String getEmail(BufferedReader br, String prompt) {
        String email = "";
        do
        {
            email = getString(br, prompt);
            if (!emailIsValid(email))
                System.out.println("Email is not valid, try again");
        } while (!emailIsValid(email));
        return email;
    }
}
