package com.tsbrand.FirstSpring;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello " + name + "!";
    }

}
