package echoserver;

import java.io.*;
import java.net.*;
import java.util.*;

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
                System.out.println("Success\n");
                Scanner scnr = new Scanner(System.in);
                while (true)
                {
                    System.out.print("Enter a message (\"Q\" to quit): ");
                    String inputLine = scnr.nextLine();
                    if (inputLine.equalsIgnoreCase("q"))
                    {
                        break;
                    }
                    out.println(inputLine);
                    String response = br.readLine();
                    System.out.println("   Server response: " + response);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("\nGoodbye");
        
    }
        
}