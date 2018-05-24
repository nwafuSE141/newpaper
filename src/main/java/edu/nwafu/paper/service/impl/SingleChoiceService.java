package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.SingleChoic;
import edu.nwafu.paper.mapper.SingleChoicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TinChiWay
 * @data 2018/5/4
 */
@Service
public class SingleChoiceService {
    @Autowired
    private SingleChoicMapper singleChoicMapper;

    public List getSingleQuestions(){
        List<SingleChoic> list = singleChoicMapper.selectAll();
        List<Map> listMap = new ArrayList<>();
        for (SingleChoic singleChoic : list){
            Map map = new HashMap();
            map.put("id", singleChoic.getId());
            map.put("question", singleChoic.getQuestion());
            map.put("answer", singleChoic.getAnswer());
            map.put("score",singleChoic.getScore());
            map.put("usageCount",singleChoic.getUsageCount());
            map.put("faq",singleChoic.getFaq());
            map.put("optioncontent",singleChoic.getA()+singleChoic.getB()+ singleChoic.getC()+singleChoic.getD());
            listMap.add(map);
        }
        return listMap;
    }

    public SingleChoic getSingleById(int id) {
        return singleChoicMapper.selectByPrimaryKey(id);
    }
}
