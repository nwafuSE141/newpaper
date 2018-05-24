package edu.nwafu.paper.controller;

import edu.nwafu.paper.module.*;
import edu.nwafu.paper.module.ResponseBody;
import edu.nwafu.paper.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private SingleChoicService singleChoicService;

    @Autowired
    private MultipleChoicService multipleChoicService;

    @Autowired
    private FillBlankService fillBlankService;

    @Autowired
    private TrueOrFalseService trueOrFalseService;

    @Autowired
    private QuesAndAnsService quesAndAnsService;

    @GetMapping("/{type}")
    public ResponseBody getItems(@PathVariable Integer type, Integer page, Integer limit) {
        List items = new ArrayList();
        if (0 == type) {
            items = singleChoicService.getItems(page, limit);
        } else if (1 == type) {
            items = multipleChoicService.getItems(page, limit);
        } else if (2 == type) {
            items = fillBlankService.getItems(page, limit);
        } else if (3 == type) {
            items = trueOrFalseService.getItems(page, limit);
        } else if (4 == type) {
            items = quesAndAnsService.getItems(page, limit);
        } else {
            return new ResponseBody(400, "no such type", null);
        }
        return new ResponseBody(items);
    }

    @PostMapping("/add")
    public ResponseBody addItem(BaseRequest request) {
        Integer type = request.getType();
        if (0 == type) {
            singleChoicService.insert(request);
        } else if (1 == type) {
            multipleChoicService.insert(request);
        } else if (2 == type) {
            fillBlankService.insert(request);
        } else if (3 == type) {
            trueOrFalseService.insert(request);
        } else if (4 == type) {
            quesAndAnsService.insert(request);
        } else {
            return new ResponseBody(400, "no such type", null);
        }
        return new ResponseBody();
    }

    @PostMapping("/delete")
    public ResponseBody deleteItem(Integer type, Integer id) {
        if (0 == type) {
            singleChoicService.delete(id);
        } else if (1 == type) {
            multipleChoicService.delete(id);
        } else if (2 == type) {
            fillBlankService.delete(id);
        } else if (3 == type) {
            trueOrFalseService.delete(id);
        } else if (4 == type) {
            quesAndAnsService.delete(id);
        } else {
            return new ResponseBody(400, "no such type", null);
        }
        return new ResponseBody();
    }

    @PostMapping("/batchDelete")
    public ResponseBody batchDelete(Integer type, String ids) {
        ids = ids.substring(0, ids.length() - 1);
        if (0 == type) {
            singleChoicService.batchDelete(ids);
        } else if (1 == type) {
            multipleChoicService.batchDelete(ids);
        } else if (2 == type) {
            fillBlankService.batchDelete(ids);
        } else if (3 == type) {
            trueOrFalseService.batchDelete(ids);
        } else if (4 == type) {
            quesAndAnsService.batchDelete(ids);
        } else {
            return new ResponseBody(400, "no such type", null);
        }
        return new ResponseBody();
    }

    @PostMapping("/update")
    public ResponseBody update(UpdateRequest request) {
        Integer type = request.getType();
        if (0 == type) {
            singleChoicService.update(request);
        } else if (1 == type) {
            multipleChoicService.update(request);
        } else if (2 == type) {
            fillBlankService.update(request);
        } else if (3 == type) {
            trueOrFalseService.update(request);
        } else if (4 == type) {
            quesAndAnsService.update(request);
        } else {
            return new ResponseBody(400, "no such type", null);
        }
        return new ResponseBody();
    }
}
