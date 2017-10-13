import java.io.*;
import java.net.BindException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class Client {

    private static boolean done = true;
    private static int zaehler = 0;
    public static void main(String[] args) throws IOException, InterruptedException {
        String address = "127.0.0.1";
        int port = 12345;

        while (true) {

            try {
                //create socket (with port and address)

                Socket s = new Socket(address, port);
                done = false;
                send(s);
                receive(s);
            }catch (IOException e){
                e.printStackTrace();

            }
            Thread.sleep(250);
        }
    }

    public static void send(Socket s){
        try {
            BufferedWriter cwriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            cwriter.write("No action taken");
            s.shutdownOutput();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void receive(Socket s){
        Date time = new Date(System.currentTimeMillis());
        try {
            //wait for message
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String output = "";
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
                zaehler++;
                System.out.println(zaehler);
            }
            System.out.println("successfully connected at: " + time.toString());
            if(reader.readLine() == null) {
                reader.close();
                done = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
