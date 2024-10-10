package com.example.springlab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class HelloWorld {
    @GetMapping("/hello")
    static String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/q")
    public ArrayList<Integer> data(@RequestParam int id) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < id; i+=1) {
            int ab = 1;
            ab+=i;
            a.add(ab);
        }
        return a;
    }

    @GetMapping("/random")
    public Double random(@RequestParam int id) {
        double a = Math.random()*id+1;
        while (a>1){
            a/=10;
        }
        return (double)a;
    }

    @GetMapping("/time")
    public String time() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/fibonacci")
    public String fibonacci(@RequestParam int id) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(0,1);
        a.add(1,1);
        for (int i = 2; i<id; i++) {
            int b =a.get(i-2)+a.get(i-1);
            a.add(i,b);
        }
        return String.valueOf(a.get(id-1));
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam String id) {
        StringBuilder sb = new StringBuilder(id);
        sb.reverse();
        return sb.toString();
    }
}
