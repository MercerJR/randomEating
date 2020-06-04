package com.project.random_eating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MercerJR
 * @Data 2020/2/14 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeResult {

    private Integer id;

    private String type;

    private String foods;

}
