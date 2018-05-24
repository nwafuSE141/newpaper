package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.*;
import edu.nwafu.paper.mapper.*;
import edu.nwafu.paper.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TinChiWay
 * @data 2018/5/3
 */
@Service
public class PaperInfoService {
    protected static final Logger logger = LoggerFactory.getLogger(PaperInfoService.class);

    @Autowired
    private PaperInfoMapper paperInfoMapper;

    @Autowired
    private SingleChoicMapper singleChoicMapper;//10001

    @Autowired
    private MultipleChoiceMapper multipleChoiceMapper;//10002

    @Autowired
    private FillBlankMapper fillBlankMapper;//10003

    @Autowired
    private TrueOrFalseMapper trueOrFalseMapper;//10004

    @Autowired
    private QuesAndAnsMapper quesAndAnsMapper;//10005

    public List getPaperInfo(Integer paperId){
        return paperInfoMapper.getPaperInfo(paperId);
    }

    //获取paper详细信息
    public PaperInfoModel getPapercompleteInfo(Integer paperId){

        List<PaperInfo> infoList = paperInfoMapper.getPaperInfo(paperId);

        PaperInfoModel paperInfoModel = new PaperInfoModel();
        for (PaperInfo info : infoList){
            if (info.getTypeId() == 10001){
                SingleChoic singleChoic = singleChoicMapper.selectByPrimaryKey(info.getQuestionId());
                SingleChoicViewModel model = new SingleChoicViewModel(singleChoic);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addSingChioice(model);
            }
            if (info.getTypeId() == 10002){
                MultipleChoice multipleChoice = multipleChoiceMapper.selectByPrimaryKey(info.getQuestionId());
                MultipleChoiceViewModel model = new MultipleChoiceViewModel(multipleChoice);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addMultipleChoice(model);
            }
            if (info.getTypeId() == 10003){
                FillBlank fillBlank = fillBlankMapper.selectByPrimaryKey(info.getQuestionId());
                FillBlankViewModel model = new FillBlankViewModel(fillBlank);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addFillBlank(model);
            }
            if (info.getTypeId() == 10004){
                TrueOrFalse trueOrFalse = trueOrFalseMapper.selectByPrimaryKey(info.getQuestionId());
                TrueOrFalseViewModel model = new TrueOrFalseViewModel(trueOrFalse);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addTrueOrFalse(model);
            }
            if (info.getTypeId() == 10005){
                QuesAndAns quesAndAns = quesAndAnsMapper.selectByPrimaryKey(info.getQuestionId());
                QuesAndAnsViewModel model = new QuesAndAnsViewModel(quesAndAns);
                model.setSerialNumber(info.getSerialNumber());
                paperInfoModel.addQuesAndAns(model);
            }
        }

        return paperInfoModel;

    }

    public int insertList(List<PaperInfo> paperInfoList) {
        return paperInfoMapper.insertList(paperInfoList);
    }
}
