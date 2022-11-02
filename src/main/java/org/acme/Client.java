package org.acme;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");

        String surl = "http://localhost:8090/hello?key=money";

        URL url = new URL(surl);

// Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
//        connection.setRequestProperty("accept", "application/text");

// This line makes the request
        InputStream responseStream = connection.getInputStream();
        System.out.println(new String(responseStream.readAllBytes()));
    }
}
