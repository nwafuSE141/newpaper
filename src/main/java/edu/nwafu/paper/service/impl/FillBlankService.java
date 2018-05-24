package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.FillBlank;
import edu.nwafu.paper.mapper.FillBlankMapper;
import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;
import edu.nwafu.paper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillBlankService implements ItemService {

    @Autowired
    private FillBlankMapper fillBlankMapper;

    @Override
    public List getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<FillBlank> items = fillBlankMapper.selectAll();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        FillBlank fillBlank = new FillBlank();
        fillBlank.setDifficult(request.getDifficult());
        fillBlank.setCourseId(request.getCourseId());
        fillBlank.setPointId(request.getPointId());
        fillBlank.setQuestion(request.getQuestion());
        fillBlank.setAnswer(request.getAnswer());
        fillBlank.setFaq(request.getFaq());
        fillBlankMapper.insert(fillBlank);
    }

    @Override
    public void delete(Integer id) {
        fillBlankMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            fillBlankMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        FillBlank fillBlank = fillBlankMapper.selectByPrimaryKey(request.getId());
        fillBlank.setDifficult(request.getDifficult());
        fillBlank.setCourseId(request.getCourseId());
        fillBlank.setPointId(request.getPointId());
        fillBlank.setQuestion(request.getQuestion());
        fillBlank.setAnswer(request.getAnswer());
        fillBlank.setFaq(request.getFaq());
        fillBlankMapper.updateByPrimaryKeySelective(fillBlank);
    }

    public List getFillBlankQuestion(){
        return fillBlankMapper.selectAll();
    }

    public FillBlank getFillBlankById(int id) {
        return fillBlankMapper.selectByPrimaryKey(id);
    }

}
