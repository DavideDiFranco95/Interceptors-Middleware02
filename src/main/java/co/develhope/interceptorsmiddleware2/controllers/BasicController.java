package co.develhope.interceptorsmiddleware2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("")
    public String getHello(){
        return "Welcome guest";
    }
}