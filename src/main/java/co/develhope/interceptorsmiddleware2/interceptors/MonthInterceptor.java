package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor{
    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1,"January","Gennaio","Januar"),
            new Month(2,"February","Febbraio","Februar"),
            new Month(3,"March","Marzo","Marsch"),
            new Month(4,"April","Aprile","April"),
            new Month(5,"May","Maggio","Dürfen"),
            new Month(6,"June","Giugno","Juni")
    ));
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber =request.getHeader("monthNumber");
        if (monthNumber == null){
            response.setStatus(400);
            throw new Exception("Bad Request");
        }
        long numberOfMonth =Long.parseLong(monthNumber);
        Optional<Month> month =months.stream().filter(singleMonth->{
            return singleMonth.getMonthNumber() == numberOfMonth;
        }).findFirst();
        if (month.isPresent()){
            request.setAttribute("MonthInterceptor-month",month.get());
            response.setStatus(200);
        }else{
            new Month(0,"nope","nope","nope");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}