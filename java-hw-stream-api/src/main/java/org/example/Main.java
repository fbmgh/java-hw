package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URL;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Main {
    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/posts";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();

            ObjectMapper om = new ObjectMapper();
            List<Post> posts = om.readValue(sb.toString(), new TypeReference<List<Post>>() {});

            List<Post> filteredPosts = posts.stream()
                    //.filter(post -> post.getUserId() == 1)
                    .filter(post -> post.getId() == 1)
                    .toList();

            filteredPosts.forEach(post -> {
                System.out.println("ID: " + post.getId() + ", Title: " + post.getTitle());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
