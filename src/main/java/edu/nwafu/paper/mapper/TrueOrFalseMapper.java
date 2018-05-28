package edu.nwafu.paper.mapper;

import edu.nwafu.paper.beans.TrueOrFalse;

import java.util.List;

public interface TrueOrFalseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TrueOrFalse record);

    int insertSelective(TrueOrFalse record);

    TrueOrFalse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrueOrFalse record);

    int updateByPrimaryKey(TrueOrFalse record);

    List<TrueOrFalse> selectAll();

    int increaseUseCount(int id);
}