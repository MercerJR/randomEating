package com.project.random_eating.service;

import com.project.random_eating.dao.GeneralMapper;
import com.project.random_eating.model.AreaResult;
import com.project.random_eating.model.ListAll;
import com.project.random_eating.model.TypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MercerJR
 * @Data 2020/2/12 21:28
 */
@Service
public class GeneralService {

    @Autowired
    private GeneralMapper mapper;

    public ListAll showList(){
        return new ListAll(mapper.getAreaList(),mapper.getCanteenList(),
                mapper.getFoodsList(),mapper.getTypeList(),
                mapper.getAreaNum(),mapper.getCanteenNum(),
                mapper.getFoodsNum(),mapper.getTypeNum());
    }

    public boolean insertNew(String canteen,String type,String foods){
        Integer parent = mapper.getCanteenIdByName(canteen);
        Integer code = mapper.getTypeIdByName(type);
        if (mapper.insertFoods(foods,code,parent)){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkAreaAndCanteen(String area,String canteen){
        if (area.equals(mapper.getAreaNameById(mapper.getCanteenParent(canteen)))){
            return true;
        }else {
            return false;
        }
    }

    public List<AreaResult> getAreaResult(){
        Integer resultNum = mapper.getAreaResultNum();
        List<AreaResult> resultList = mapper.getAreaResultList();
        if (resultNum >= 5){
            return resultList.subList(resultNum - 5,resultNum);
        }else {
            return resultList.subList(0,resultNum);
        }
    }

    public List<TypeResult> getTypeResult(){
        Integer resultNum = mapper.getTypeResultNum();
        List<TypeResult> resultList = mapper.getTypeResultList();
        if (resultNum >= 5){
            return resultList.subList(resultNum - 5,resultNum);
        }else {
            return resultList.subList(0,resultNum);
        }
    }

}
