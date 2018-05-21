package echoserver;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
    public static void main(String[] args)
    {
        System.out.println("THE SERVER\n");
        
        //Set up server
        try (ServerSocket sSocket = new ServerSocket(6000))
        {
            System.out.print("Server connecting... ");
            Socket cSocket = sSocket.accept();
            System.out.println("Success\n");
            
            //Read message
            try (BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true))
            {
                String inputLine;
                while ((inputLine = br.readLine()) != null)
                {
                    System.out.println("Message from client: " + inputLine);
                    out.println(inputLine);
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
