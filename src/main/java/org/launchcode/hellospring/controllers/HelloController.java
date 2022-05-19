package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

    // Handler request of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="langResponse")
    @ResponseBody
    public static String createMessage(@RequestParam String name,@RequestParam String lang){
        if(lang.equals("english")){
            return "Hello, " + name + ".";
        } else if(lang.equals("french")){
            return "Bonjour, " + name + ".";
        } else if(lang.equals("spanish")){
            return "Hola, " + name + ".";
        } else if(lang.equals("russian")){
            return "Privet, " + name + ".";
        } else if(lang.equals("japanese")){
            return "Konnichiwa, " + name + ".";
        } else if(lang.equals("shoshone")){
            return "Hakaniyun, " + name + ".";
        } else {
            return "This didn't work";
        }
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
