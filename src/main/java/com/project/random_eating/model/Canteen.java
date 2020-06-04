package com.project.random_eating.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author MercerJR
 * @Data 2020/2/11 17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Canteen {

    private Integer id;

    private String name;

    private Integer parent;

    public Canteen(Integer id,String name){
        this.id = id;
        this.name = name;
    }
}
