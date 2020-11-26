package com.codecool.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController {

    @RequestMapping(value="/calculate", method = RequestMethod.GET)
    public String calculatorForm(){
        return "calculatorForm";
    }

    @RequestMapping(value="/calculate", method = RequestMethod.POST)
    @ResponseBody
    public String calculator(HttpServletRequest request, Model model){

        String fNumber = request.getParameter("fNum");
        String sNumber = request.getParameter("sNum");
        String operator = request.getParameter("operatorList");

        switch (operator){
            case "+":
                return String.valueOf(Integer.parseInt(fNumber) + Integer.parseInt(sNumber));
            case "-":
                return String.valueOf(Integer.parseInt(fNumber) - Integer.parseInt(sNumber));
            case"*":
                return String.valueOf(Integer.parseInt(fNumber) * Integer.parseInt(sNumber));
            case"/":
                return String.valueOf(Integer.parseInt(fNumber) / Integer.parseInt(sNumber));

        }
        return fNumber + operator + sNumber;
    }

}
