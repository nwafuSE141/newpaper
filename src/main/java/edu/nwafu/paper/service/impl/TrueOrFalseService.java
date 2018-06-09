package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.TrueOrFalse;
import edu.nwafu.paper.mapper.TrueOrFalseMapper;
import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;
import edu.nwafu.paper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrueOrFalseService implements ItemService {

    @Autowired
    private TrueOrFalseMapper trueOrFalseMapper;

    @Autowired
    private KnowledgePointService knowledgePointService;

    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TrueOrFalse> items = trueOrFalseMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        TrueOrFalse trueOrFalse = new TrueOrFalse();
        trueOrFalse.setDifficult(request.getDifficult());
        trueOrFalse.setCourseId(request.getCourseId());
        trueOrFalse.setPointId(request.getPointId());
        trueOrFalse.setQuestion(request.getQuestion());
        trueOrFalse.setAnswer(request.getAnswer());
        trueOrFalse.setFaq(request.getFaq());
        trueOrFalseMapper.insert(trueOrFalse);
    }

    @Override
    public void delete(Integer id) {
        trueOrFalseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            trueOrFalseMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        TrueOrFalse trueOrFalse = trueOrFalseMapper.selectByPrimaryKey(request.getId());
        trueOrFalse.setDifficult(request.getDifficult());
        trueOrFalse.setCourseId(request.getCourseId());
        trueOrFalse.setPointId(request.getPointId());
        trueOrFalse.setQuestion(request.getQuestion());
        trueOrFalse.setAnswer(request.getAnswer());
        trueOrFalse.setFaq(request.getFaq());
        trueOrFalseMapper.updateByPrimaryKeySelective(trueOrFalse);
    }

    public List getTrueOrFalseQuestion(){
        List<TrueOrFalse> list = trueOrFalseMapper.selectAll();
        for (TrueOrFalse trueOrFalse: list) {
            trueOrFalse.setKnowledge(knowledgePointService.getKonwledgeById(trueOrFalse.getPointId()).getName());
        }
        return list;
    }

    public TrueOrFalse getTrueOrFalseById(int id) {
        return trueOrFalseMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return trueOrFalseMapper.increaseUseCount(id);
    }
}
