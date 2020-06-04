package com.project.random_eating.controller;

import com.project.random_eating.model.AreaResult;
import com.project.random_eating.model.ListAll;
import com.project.random_eating.model.Response;
import com.project.random_eating.model.TypeResult;
import com.project.random_eating.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author MercerJR
 * @Data 2020/2/12 20:35
 */
@RestController
@Slf4j
@RequestMapping("/show")
public class ShowListController {

    @Autowired
    private GeneralService service;

    @GetMapping(value = "/list",produces = "application/json")
    public Response AreaToFoods(){
        ListAll allList = service.showList();
        if (allList == null){
            return new Response().Failed();
        }else {
            return new Response().Success(allList);
        }
    }

    @GetMapping(value = "/areaHistory",produces = "application/json")
    public Response areaHistory(){
        List<AreaResult> areaResultList = service.getAreaResult();
        if (areaResultList == null){
            return new Response().Failed();
        }else {
            return new Response().Success(areaResultList);
        }
    }

    @GetMapping(value = "/typeHistory",produces = "application/json")
    public Response typeHistory(){
        List<TypeResult> typeResultList = service.getTypeResult();
        if (typeResultList == null){
            return new Response().Failed();
        }else {
            return new Response().Success(typeResultList);
        }
    }
}
