package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='langResponse' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='lang'>" +
                    "<option value='english'>English</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='russian'>Russian</option>" +
                    "<option value='japanese'>Japanese</option>" +
                    "<option value='shoshone'>Shoshone</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form></body></html>";
    }
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="langResponse")
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
}
