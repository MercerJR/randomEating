package com.project.random_eating.controller;

import com.project.random_eating.model.InsertModel;
import com.project.random_eating.model.Response;
import com.project.random_eating.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MercerJR
 * @Data 2020/2/16 22:40
 */
@RestController
@Slf4j
public class InsertController {

    @Autowired
    private GeneralService service;

    @PostMapping(value = "/insertNew",produces = "application/json")
    public Response insertNew(InsertModel model){
        log.info("进入了方法");
        if (service.checkAreaAndCanteen(model.getArea(), model.getCanteen())){
            if (service.insertNew(model.getCanteen(), model.getType(), model.getFoods())){
                return new Response().Success();
            }else {
                return new Response().Failed("系统内部错误");
            }
        }else {
            return new Response().Failed("这个食堂不属于该区域，请重新填写");
        }
    }

}
