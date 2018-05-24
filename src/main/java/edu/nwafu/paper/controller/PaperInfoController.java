package edu.nwafu.paper.controller;

import edu.nwafu.paper.model.PaperInfoModel;
import edu.nwafu.paper.service.impl.PaperInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author TinChiWay
 * @data 2018/5/3
 */
@RestController
@RequestMapping("/paperinfo")
public class PaperInfoController {
    protected static final Logger logger = LoggerFactory.getLogger(PaperController.class);

    @Autowired
    private PaperInfoService paperInfoService;

    @PostMapping("getpapercompleteinfo")
    public Object getPapercompleteInfo(int paperId){
        logger.info("get papercompleteInfo at: " + paperId);
        Map<String, Object> map = new HashMap<>();

       PaperInfoModel model = paperInfoService.getPapercompleteInfo(paperId);
       map.put("stat","ok");
       map.put("data",model);
       return map;
    }


}
