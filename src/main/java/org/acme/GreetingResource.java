package org.acme;

import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@RestQuery String key) {
        if (key == null)
            return "error";
        return searchTermInIndex(key);
    }


    public static String indexFileLocation = "." ;
    public static String indexFileName = "Index.txt";
    //a flag to exit the program
    public static boolean exit = false;


    //just a function to search the keyword in the index file, nothing special, don't need to modify
    public static String searchTermInIndex(String searchKeyword) {
        File file = new File(indexFileLocation + File.separator + indexFileName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {

                String[] spiltWords = st.split("\\|.\\|");
                if (spiltWords[0].equals(searchKeyword)) {
                    System.out.println("Match Find on Index File!");
                    System.out.println("Sending following result to the client side:");
                    System.out.println(st);
                    return st;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
