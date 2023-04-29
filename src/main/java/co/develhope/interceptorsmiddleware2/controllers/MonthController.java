package co.develhope.interceptorsmiddleware2.controllers;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping("")
    public Month getSingleMonth(HttpServletRequest request){
        Month month =(Month)request.getAttribute("MonthInterceptor-month");
        return month;
    }
}