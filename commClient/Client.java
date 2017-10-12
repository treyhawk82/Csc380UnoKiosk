import java.io.*;
import java.net.BindException;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws IOException {
        String address = "127.0.0.1";
        int port = 12345;
        boolean inputOutput = true;

        while (true) {
            //create socket (with port and address)

            Socket s = new Socket(address, port);


            if (inputOutput) {
                inputOutput = receive(s);
            } else {
                inputOutput = send(s);
            }

            try {
             Thread.sleep(750);
             } catch (InterruptedException e) {
             e.printStackTrace();
             }
        }
    }

    public static boolean send(Socket s){
        try {
            BufferedWriter cwriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            cwriter.write("Action taken");
            cwriter.flush();
            cwriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean receive(Socket s){
        try {
            //wait for message
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String output = "";
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
