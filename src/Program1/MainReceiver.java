package Program1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainReceiver {

    public static void main(String[] args) {
        int port = Validator.getPort();
        String address = Validator.getAdress();


        MulticastReceiver multicastReceiver = new MulticastReceiver(port,address);
        multicastReceiver.start();
    }
}
