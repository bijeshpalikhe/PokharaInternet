package com.pinet.app.web.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Controller
@RequestMapping(value = "logger")
public class LoggerController {

    @RequestMapping(method = RequestMethod.GET)
    public String showLogMessage(Model model) {
       //src/main/resources/logs/application.log

        File file = new File("/home/ashmeet/Intern Folder/PokharaInternet/src/main/resources/logs/application.log");
        System.out.println("File is not emptly : "+file.getName());
        try {
            FileInputStream fstream = new FileInputStream(String.valueOf(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String tempString;
            String finalString = "";
            while ((tempString = br.readLine()) != null) {
                finalString = finalString + tempString;
            }
            fstream.close();
            model.addAttribute("logs", finalString);
            return "log";
        } catch (Exception e) {
            return "redirect:/exception/error?q=Cannot Read Log File :" + e.getMessage();
        }
    }
}
