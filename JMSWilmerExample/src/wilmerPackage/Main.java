package wilmerPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main (String[] args) throws Exception {
        MessageSender sender = new MessageSender();
        MessageReceiver receiver = new MessageReceiver();
        receiver.startListener();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        sender.sendMessage(line);

        sender.destroy();
        receiver.destroy();
    }
}