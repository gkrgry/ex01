package com.daelim.ex01.mapper;

import com.daelim.ex01.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.Date;

@Mapper
public interface Ex01Mapper {
    public Date nowDate();
}
