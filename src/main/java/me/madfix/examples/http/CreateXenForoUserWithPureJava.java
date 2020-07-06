package me.madfix.examples.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

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
            try (InputStream inputStream = httpURLConnection.getInputStream()) { // <--- Returns a response as a stream
                // Closes the stream automatically
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                List<String> responseLines = bufferedReader.lines().collect(Collectors.toList());
                responseLines.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
