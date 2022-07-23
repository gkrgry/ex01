package com.daelim.ex01.controller;


import com.daelim.ex01.service.Ex01Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping("")
public class Ex01 {

    private final Ex01Service ex01service;


    @GetMapping("/ex01")
    @ResponseBody
    public String test(){

        return ex01service.nowDate()+"";
    }
}
