package com.project.random_eating.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MercerJR
 * @Data 2020/2/14 14:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaResult {

    private Integer id;

    private String area;

    private String canteen;

    private String foods;

}
