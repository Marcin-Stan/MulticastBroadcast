package Program1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    public static boolean validIP(String ip) {
        try {
            if (ip == null || ip.isEmpty()) {
                return false;
            }

            String[] parts = ip.split("\\.");
            if (parts.length != 4) {
                return false;
            }

            for (String s : parts) {
                int i = Integer.parseInt(s);
                if ((i < 0) || (i > 255)) {
                    return false;
                }
            }
            if (ip.endsWith(".")) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static int getPort() {
        int port = 0;
        boolean isCorrect = false;

        while (!isCorrect) {

            try {
                System.out.println("Podaj numer portu(liczba):");
                Scanner sc = new Scanner(System.in);
                port = sc.nextInt();
                isCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Portem moze byc tylko liczba, sprobuj jeszcze raz");
            }
        }
        return port;
    }

    public static String getMessage() {

        System.out.println("Podaj wiadomosc, ktora chcialbys przekazac");
        String message;
        Scanner scanner = new Scanner(System.in);
        message = scanner.nextLine();
        return message;
    }

    public static String getAdress() {

        System.out.println("Podaj adress serwera");
        String address;
        Scanner scanner1 = new Scanner(System.in);
        address = scanner1.nextLine();
        while (!Validator.validIP(address)) {
            System.out.println("Podales zly adress, sprobuj jeszcze raz ");
            Scanner sc = new Scanner(System.in);
            address = sc.nextLine();

        }
        return address;
    }
}
