package edu.nwafu.paper.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nwafu.paper.beans.SingleChoic;
import edu.nwafu.paper.mapper.SingleChoicMapper;
import edu.nwafu.paper.module.BaseRequest;
import edu.nwafu.paper.module.UpdateRequest;
import edu.nwafu.paper.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleChoicService implements ItemService {

    @Autowired
    private SingleChoicMapper singleChoicMapper;

    @Override
    public List<SingleChoic> getItems(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SingleChoic> items = singleChoicMapper.selectAll();
//        PageInfo<SingleChoic> pageInfo = new PageInfo<>(items);
//        items = pageInfo.getList();
        if (null != items) {
            return items;
        }
        return null;
    }

    @Override
    public void insert(BaseRequest request) {
        SingleChoic singleChoic = new SingleChoic();
        singleChoic.setDifficult(request.getDifficult());
        singleChoic.setCourseId(request.getCourseId());
        singleChoic.setPointId(request.getPointId());
        singleChoic.setQuestion(request.getQuestion());
        singleChoic.setAnswer(request.getAnswer());
        singleChoic.setFaq(request.getFaq());
        singleChoicMapper.insert(singleChoic);
    }

    @Override
    public void delete(Integer id) {
        singleChoicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(String str) {
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            singleChoicMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    @Override
    public void update(UpdateRequest request) {
        SingleChoic singleChoic = singleChoicMapper.selectByPrimaryKey(request.getId());
        singleChoic.setDifficult(request.getDifficult());
        singleChoic.setCourseId(request.getCourseId());
        singleChoic.setPointId(request.getPointId());
        singleChoic.setQuestion(request.getQuestion());
        singleChoic.setAnswer(request.getAnswer());
        singleChoic.setFaq(request.getFaq());
        singleChoicMapper.updateByPrimaryKeySelective(singleChoic);
    }
}
