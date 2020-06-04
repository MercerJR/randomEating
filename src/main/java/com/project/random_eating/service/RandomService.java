package com.project.random_eating.service;

import com.project.random_eating.dao.RandomMapper;
import com.project.random_eating.model.*;
import com.project.random_eating.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author MercerJR
 * @Data 2020/2/11 16:32
 */
@Service
public class RandomService {

    @Autowired
    private RandomMapper mapper;

    /**
     * @return 区域
     */
    public AreaResult getRandomArea() {
        Integer randomNum = new RandomNumber().myRandom(mapper.getAreaNum());
        String area = mapper.getRandomAreaName(randomNum);
        if (mapper.putArea(area)){
            return mapper.getAreaResult(mapper.getAreaResultNum());
        }else {
            return null;
        }
    }

    /**
     * @return 选了区域后选的食堂或直接选食堂
     */
    public AreaResult getRandomCanteenAfterArea(Integer areaId) {
        if (areaId != null){
            List<Integer> canteenList = mapper.getCanteenAfterArea(areaId);
            Integer randomNum = new RandomNumber().myRandom(canteenList.size());
            Integer canteenId = canteenList.get(randomNum - 1);
            String canteen = mapper.getRandomCanteenName(canteenId);
            if (mapper.putCanteenAfterArea(canteen,mapper.getAreaResultNum())){
                return mapper.getAreaResult(mapper.getAreaResultNum());
            }else {
                return null;
            }
        }else {
            Integer randomNum = new RandomNumber().myRandom(mapper.getCanteenNum());
            String canteen = mapper.getRandomCanteenName(randomNum);
            if (mapper.putCanteen(canteen)){
                return mapper.getAreaResult(mapper.getAreaResultNum());
            }else {
                return null;
            }
        }
    }

    /**
     * @return 选了食堂后选的吃的
     */
    public AreaResult getRandomFoodsAfterCanteen(Integer canteenId) {
        List<Integer> foodsList = mapper.getFoodsAfterCanteen(canteenId);
        Integer randomNum = new RandomNumber().myRandom(foodsList.size());
        Integer foodsId = foodsList.get(randomNum - 1);
        String foods = mapper.getRandomFoodsName(foodsId);
        if (mapper.putFoodsAfterCanteen(foods,mapper.getAreaResultNum())){
            return mapper.getAreaResult(mapper.getAreaResultNum());
        }else {
            return null;
        }
    }

    /**
     * @return 吃的类型
     */
    public TypeResult getRandomType() {
        Integer randomNum = new RandomNumber().myRandom(mapper.getTypeNum());
        String type = mapper.getRandomTypeName(randomNum);
        if (mapper.putType(type)){
            return mapper.getTypeResult(mapper.getTypeResultNum());
        }else {
            return null;
        }
    }

    /**
     * @param typeId
     * @return 选了类型后选的吃的
     */
    public TypeResult getRandomFoodsAfterType(Integer typeId) {
        List<Integer> foodsList = mapper.getFoodsAfterType(typeId);
        Integer randomNum = new RandomNumber().myRandom(foodsList.size());
        Integer foodsId = foodsList.get(randomNum - 1);
        String foods = mapper.getRandomFoodsName(foodsId);
        if (mapper.putFoodsAfterType(foods,mapper.getTypeResultNum())){
            return mapper.getTypeResult(mapper.getTypeResultNum());
        }else {
            return null;
        }
    }

    public Integer getId(String name,String sign){
        if (sign.equals("area")){
            return mapper.getAreaIdByName(name);
        }else if (sign.equals("canteen")){
            return mapper.getCanteenIdByName(name);
        }else {
            return mapper.getTypeIdByName(name);
        }
    }

}
