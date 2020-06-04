package com.project.random_eating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author MercerJR
 * @Data 2020/2/12 20:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAll {

    private List<Area> areaList;

    private List<Canteen> canteenList;

    private List<Foods> foodsList;

    private List<Type> typeList;

    private Integer areaNum;

    private Integer canteenNum;

    private Integer foodsNum;

    private Integer typeNum;

}
