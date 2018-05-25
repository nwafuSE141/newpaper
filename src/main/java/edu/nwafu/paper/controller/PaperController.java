package edu.nwafu.paper.controller;

import edu.nwafu.paper.beans.Paper;
import edu.nwafu.paper.beans.PaperInfo;
import edu.nwafu.paper.model.AddPaperListModel;
import edu.nwafu.paper.service.impl.PaperService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TinChiWay
 * @data 2018/5/2
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @PostMapping("/delete")
    public int deletePaperById(int id) {
        return paperService.deleteByPrimaryKey(id);
    }

    @PostMapping("/getpaperwithuserid")
    public Object getpapersWithUserId(int userId) {
        JSONObject jsonObject = new JSONObject();

        List<Paper> paperList = paperService.getPaperWithUserId(userId);

        jsonObject.element("stat", "ok");
        jsonObject.element("data", paperList);
        return jsonObject;
    }

    @PostMapping("/getalltestpaper")
    public Object getAllTestPaper() {
        JSONObject jsonObject = new JSONObject();

        List<Paper> paperList = paperService.getAllPaper();
        jsonObject.element("stat", "ok");
        jsonObject.element("data", paperList);

        return jsonObject;
    }

    @PostMapping("/gettestpaperwithstat")
    public Object getSubmitTestPaper(int stat) {
        JSONObject jsonObject = new JSONObject();

        List<Paper> paperList = paperService.getPaperWithStat(stat);
        jsonObject.element("stat", "ok");
        jsonObject.element("data", paperList);

        return jsonObject;
    }

    @PostMapping("/approve")
    public Object approvePaper(int paperId, int userId) {
        JSONObject jsonObject = new JSONObject();
        if (paperService.approvePaper(paperId, userId) == 1) {
            jsonObject.element("stat", "ok");
            jsonObject.element("msg", "审核通过");
            return jsonObject;
        }
        jsonObject.element("stat", "no");
        return jsonObject;
    }

    @PostMapping("/auditnotpassed")
    public Object auditNotPassed(int paperId, int userId) {
        JSONObject jsonObject = new JSONObject();
        if (paperService.auditNotPassed(paperId, userId) == 1) {
            jsonObject.element("stat", "ok");
            jsonObject.element("msg", "审核不通过");
            return jsonObject;

        }
        jsonObject.element("stat", "no");
        return jsonObject;

    }

}
