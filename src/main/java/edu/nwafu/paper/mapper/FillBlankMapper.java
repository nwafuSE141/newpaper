package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.FillBlank;

import java.util.List;

public interface FillBlankMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(FillBlank record);

    int insertSelective(FillBlank record);

    FillBlank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FillBlank record);

    int updateByPrimaryKey(FillBlank record);

    List<FillBlank> selectAll();
}