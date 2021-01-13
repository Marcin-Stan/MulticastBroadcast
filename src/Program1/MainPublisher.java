package Program1;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPublisher {
    public static void main(String[] args) throws IOException {

        int port = Validator.getPort();
        String message = Validator.getMessage();
        String address = Validator.getAdress();

        MulticastPublisher multicastPublisher = new MulticastPublisher();
        multicastPublisher.multicast(message,port,address);

    }
}
