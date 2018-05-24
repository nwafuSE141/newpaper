package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.MultipleChoice;
import edu.nwafu.paper.mapper.MultipleChoiceMapper;
import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;
import edu.nwafu.paper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultipleChoicService implements ItemService {

    @Autowired
    private MultipleChoiceMapper multipleChoiceMapper;

    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MultipleChoice> items = multipleChoiceMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        MultipleChoice multipleChoic = new MultipleChoice();
        multipleChoic.setDifficult(request.getDifficult());
        multipleChoic.setCourseId(request.getCourseId());
        multipleChoic.setPointId(request.getPointId());
        multipleChoic.setQuestion(request.getQuestion());
        multipleChoic.setAnswer(request.getAnswer());
        multipleChoic.setFaq(request.getFaq());
        multipleChoiceMapper.insert(multipleChoic);
    }

    @Override
    public void delete(Integer id) {
        multipleChoiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            multipleChoiceMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        MultipleChoice multiChoic = multipleChoiceMapper.selectByPrimaryKey(request.getId());
        multiChoic.setDifficult(request.getDifficult());
        multiChoic.setCourseId(request.getCourseId());
        multiChoic.setPointId(request.getPointId());
        multiChoic.setQuestion(request.getQuestion());
        multiChoic.setAnswer(request.getAnswer());
        multiChoic.setFaq(request.getFaq());
        multipleChoiceMapper.updateByPrimaryKeySelective(multiChoic);
    }
}
