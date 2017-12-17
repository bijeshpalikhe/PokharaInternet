package com.pinet.app.web.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/exception")
public class ExceptionHandlingController {

    @RequestMapping(method = RequestMethod.GET, value = "error")
    public String showExceptionHandlingPage(){
        return "exception";
    }
}
