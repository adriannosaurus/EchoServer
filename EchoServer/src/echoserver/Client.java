package echoserver;

import java.io.*;
//import static java.lang.System.in;
import java.net.*;
import java.util.*;
import static sun.nio.ch.Net.localAddress;

public class Client
{
    public static void main(String[] args)
    {
        System.out.println("THE CLIENT\n");
        try
        {
            System.out.print("Client connecting... ");
            InetAddress localAdd = InetAddress.getLocalHost();
            
            try (Socket cSocket = new Socket(localAdd, 6000);
                    PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream())))
            {
                System.out.println("Success");
            }
            catch (IOException e)
            {
                System.out.println("Client setup failed");
            }
        }
        catch (IOException e)
        {
            System.out.println("Failed");
        }
    }

    static InputStream getInputStream() {
        
//        String InputStream;
//        
//        while ((InputStream = stdIn.readLine()) !=null) {
//            System.out.println("Server: " + in.readLine());
//        }

//This is what I got from the text book, I wasn't really sure if they needed the import or something
        
        throw new UnsupportedOperationException("getInputStream() not supported yet.");
}
        
}

