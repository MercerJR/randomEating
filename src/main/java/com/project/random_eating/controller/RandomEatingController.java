package com.project.random_eating.controller;

import com.project.random_eating.model.*;
import com.project.random_eating.service.RandomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author MercerJR
 * @Data 2020/2/11 15:59
 */

@RestController
@Slf4j
@RequestMapping("/random")
public class RandomEatingController {

    @Autowired
    private RandomService service;

    @GetMapping(value = "/randomArea",produces = "application/json")
    public Response randomArea(HttpSession session){
        AreaResult randomResult = service.getRandomArea();
        if (randomResult == null){
            return new Response().Failed();
        }else {
            //将area类的id放进session里
            session.setAttribute("areaId",service.getId(randomResult.getArea(),"area"));
            //只把area类的name属性作为data返回
            return new Response().Success(randomResult);
        }
    }

    @GetMapping(value = "/randomCanteenAfterArea",produces = "application/json")
    public Response randomCanteen(HttpSession session){
        //取出session中的areaId
        Integer areaId = (Integer) session.getAttribute("areaId");
        AreaResult randomResult = service.getRandomCanteenAfterArea(areaId);
        if (randomResult == null){
            return new Response().Failed("系统内部错误");
        }else {
            session.setAttribute("canteenId",service.getId(randomResult.getCanteen(),"canteen"));
            return new Response().Success(randomResult);
        }
    }

    @GetMapping(value = "/randomFoodsAfterCanteen",produces = "application/json")
    public Response randomFoodsAfterCanteen(HttpSession session){
        Integer canteenId = (Integer) session.getAttribute("canteenId");
        if (canteenId == null){
            return new Response().Failed("傻猪猪，你得先选区域和食堂，或者至少先选食堂啊");
        }
        AreaResult randomResult = service.getRandomFoodsAfterCanteen(canteenId);
        if (randomResult == null){
            return new Response().Failed("系统内部错误");
        }else {
            return new Response().Success(randomResult);
        }
    }

    @GetMapping(value = "/randomType",produces = "application/json")
    public Response randomType(HttpSession session){
        TypeResult randomResult = service.getRandomType();
        if (randomResult == null){
            return new Response().Failed();
        }else {
            session.setAttribute("typeId",service.getId(randomResult.getType(),"type"));
            return new Response().Success(randomResult);
        }
    }

    @GetMapping(value = "/randomFoodsAfterType",produces = "application/json")
    public Response randomFoodsAfterType(HttpSession session){
        Integer typeId = (Integer) session.getAttribute("typeId");
        TypeResult randomResult = service.getRandomFoodsAfterType(typeId);
        if (randomResult == null){
            return new Response().Failed();
        }else {
            return new Response().Success(randomResult);
        }
    }

}
