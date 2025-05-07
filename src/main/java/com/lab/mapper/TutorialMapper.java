package com.lab.mapper;

import com.lab.model.Tutorial;
import com.lab.model.TutorialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TutorialMapper {
    long countByExample(TutorialExample example);

    int deleteByExample(TutorialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tutorial row);

    int insertSelective(Tutorial row);

    List<Tutorial> selectByExample(TutorialExample example);

    Tutorial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Tutorial row, @Param("example") TutorialExample example);

    int updateByExample(@Param("row") Tutorial row, @Param("example") TutorialExample example);

    int updateByPrimaryKeySelective(Tutorial row);

    int updateByPrimaryKey(Tutorial row);
}