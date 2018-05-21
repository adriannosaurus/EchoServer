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
        
        //Send message
        try (BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true))
        {
            String inputLine;
            while ((inputLine = br.readLine()) != null)
            {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);
            }
        }
        catch (IOException ex)
        {
            System.out.println("Server message failed");
        }
    }
        
}

