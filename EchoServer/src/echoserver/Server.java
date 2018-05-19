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
        Socket cSocket = null;
        try (ServerSocket sSocket = new ServerSocket(6000))
        {
            System.out.print("Server connecting... ");
            cSocket = sSocket.accept();
            System.out.println("Success");
        }
        catch (IOException e)
        {
            System.out.println("Failure");
        }
        
        //Read message
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Client.getInputStream()));
                PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true))
        {
            String inputLine;
            while ((inputLine = br.readLine()) != null)
            {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);
            }
        } catch (IOException ex) {
            System.out.println("Server message failed");
        }
    }

}
