package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.QuesAndAns;
import edu.nwafu.paper.mapper.QuesAndAnsMapper;
import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;
import edu.nwafu.paper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesAndAnsService implements ItemService {

    @Autowired
    private QuesAndAnsMapper quesAndAnsMapper;

    @Autowired
    private KnowledgePointService knowledgePointService;

    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<QuesAndAns> items = quesAndAnsMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        QuesAndAns quesAndAns = new QuesAndAns();
        quesAndAns.setDifficult(request.getDifficult());
        quesAndAns.setCourseId(request.getCourseId());
        quesAndAns.setPointId(request.getPointId());
        quesAndAns.setQuestion(request.getQuestion());
        quesAndAns.setAnswer(request.getAnswer());
        quesAndAns.setFaq(request.getFaq());
        quesAndAnsMapper.insert(quesAndAns);
    }

    @Override
    public void delete(Integer id) {
        quesAndAnsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            quesAndAnsMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        QuesAndAns quesAndAns = quesAndAnsMapper.selectByPrimaryKey(request.getId());
        quesAndAns.setDifficult(request.getDifficult());
        quesAndAns.setCourseId(request.getCourseId());
        quesAndAns.setPointId(request.getPointId());
        quesAndAns.setQuestion(request.getQuestion());
        quesAndAns.setAnswer(request.getAnswer());
        quesAndAns.setFaq(request.getFaq());
        quesAndAnsMapper.updateByPrimaryKeySelective(quesAndAns);
    }

    public List getQuesAndAnsQuestions(){
        List<QuesAndAns> list = quesAndAnsMapper.selectAll();
        for (QuesAndAns quesAndAns : list){
            quesAndAns.setKnowledge(knowledgePointService.getKonwledgeById(quesAndAns.getPointId()).getName());
        }
        return list;
    }

    public QuesAndAns getQuesAndAnsById(int id) {
        return quesAndAnsMapper.selectByPrimaryKey(id);
    }

    public int increaseUseCount(int id) {
        return quesAndAnsMapper.increaseUseCount(id);
    }
}
