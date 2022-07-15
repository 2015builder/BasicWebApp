package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Super-Tutorium";
        }
        else if(query.contains("plus")){
            String[] splitArr = query.split(":");

            char[] chars = splitArr[1].toCharArray();

            int result = 0;

            String[] splitArr2 = splitArr[1].split(" ");

            for(String element: splitArr2){
                try {
                    int val = Integer.parseInt(element);
                    result += val;
                } catch (NumberFormatException e) {
                    //System.out.println("Input String cannot be parsed to Integer.");
                }
            }

            return String.valueOf(result);
        }

        else if(query.contains("largest")){
            List<Integer> list = new ArrayList<>();
            String[] splitArr = query.split(":");

            char[] chars = splitArr[1].toCharArray();

            int result = 0;

            String[] splitArr2 = splitArr[1].split(" ");

            for(String element: splitArr2){
                try {
                    int val = Integer.parseInt(element);
                    list.add(val);
                } catch (NumberFormatException e) {
                    //System.out.println("Input String cannot be parsed to Integer.");
                }
            }
            return String.valueOf(list.stream().max(Comparator.comparing(Integer::intValue)).orElse(list.get(0)));
        }
        else { // TODO extend the programm here
            return "";
        }
    }
}
