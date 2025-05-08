package com.lab.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lab.model.Tutorial;

@Mapper
public interface TutorialMapper extends BaseMapper<Tutorial> {

}
