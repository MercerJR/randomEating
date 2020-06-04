package com.project.random_eating.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MercerJR
 * @Data 2020/2/11 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Foods {

    private Integer id;

    private String name;

    private Integer code;

    private Integer parent;

    public Foods(Integer id,String name){
        this.id = id;
        this.name = name;
    }

}
