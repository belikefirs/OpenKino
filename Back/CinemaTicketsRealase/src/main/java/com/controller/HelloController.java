package com.controller;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {



    private static String[] LISTFILMS = {"Мстители", "Железный человек", "Миссия невыполнима",
"Марсианин", "Интерстеллар", "Принц Персии"};
private List<HashData> list;

    @GetMapping("/hello")
    public List<HashData> getHello(@RequestBody Object body){
        list = new ArrayList<>(6);
        for (int i = 0; i < 6; i++){
            HashData data = new HashData(i ,LISTFILMS[i]);
            list.add(data);
        }
        return list;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static class HashData{
        private String name;
        private int id;
        public HashData(int id, String name){
            this.id = id;
            this.name = name;
        }
    }





}
