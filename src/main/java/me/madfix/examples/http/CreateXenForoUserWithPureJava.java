package me.madfix.examples.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateXenForoUserWithPureJava {

    public static void main(String[] args) {
        try {
            String key = "PamCq9TfWJ2cs8Q3";
            String baseURL = "https://xenforo.madfix.me";
            URL forumUrl = new URL(String.format("%s/api/user", baseURL));
            HttpURLConnection httpURLConnection = (HttpURLConnection) forumUrl.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.addRequestProperty("content-type", "application/x-ww-form-urlencoded");
            httpURLConnection.addRequestProperty("key", key);
            try (OutputStream outputStream = httpURLConnection.getOutputStream()) { // <--- Returns a response as a stream
                // Closes the stream automatically
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
