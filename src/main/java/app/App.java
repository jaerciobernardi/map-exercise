package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();;
        while (line != null){
            String[] fields = line.split(",");
            String name = fields[0];
            int count = Integer.parseInt(fields[1]);
            if (votes.containsKey(name)){
                int votesSoFar = votes.get(name);
                votes.put(name, count + votesSoFar);
            }
            else {
                votes.put(name, count);
            }
            line = br.readLine();
        }
        for (String key : votes.keySet()){
            System.out.println(key+ ": " + votes.get(key));
        }



    }
}
