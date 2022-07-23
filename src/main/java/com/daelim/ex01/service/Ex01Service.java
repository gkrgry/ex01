package com.daelim.ex01.service;

import com.daelim.ex01.dto.TestDto;
import com.daelim.ex01.mapper.Ex01Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class Ex01Service {
    private final Ex01Mapper ex01Mapper;

    public Date nowDate(){
        return ex01Mapper.nowDate();
    }
}
