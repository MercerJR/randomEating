package com.project.random_eating.dao;

import com.project.random_eating.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author MercerJR
 * @Data 2020/2/12 21:21
 */
@Repository
public interface GeneralMapper {

    /**
     * @return 查询区域数量
     */
    Integer getAreaNum();

    /**
     * @return 查询食堂数量
     */
    Integer getCanteenNum();

    /**
     * @return 查询吃的（叶子节点）的数量
     */
    Integer getFoodsNum();

    /**
     * @return 查询吃的类型数量
     */
    Integer getTypeNum();

    /**
     * @return 区域列表
     */
    List<Area> getAreaList();

    /**
     * @return 食堂列表
     */
    List<Canteen> getCanteenList();

    /**
     * @return 吃的列表
     */
    List<Foods> getFoodsList();

    /**
     * @return 吃的类型列表
     */
    List<Type> getTypeList();

    /**
     * @param name
     * @param code
     * @param parent
     * @return 添加新的吃的
     */
    boolean insertFoods(@Param("name")String name,@Param("code")Integer code,
                        @Param("parent")Integer parent);

    /**
     * @param name
     * @return 通过食堂的名字获取其id
     */
    Integer getCanteenIdByName(@Param("name")String name);

    /**
     * @param name
     * @return 通过类型名字获取其id
     */
    Integer getTypeIdByName(@Param("name")String name);

    /**
     * @param name
     * @return 取得指定食堂的所属区域id
     */
    Integer getCanteenParent(@Param("name")String name);

    /**
     * @param id
     * @return 通过id取得区域名称
     */
    String getAreaNameById(@Param("id")Integer id);

    /**
     * @return 查询结果数据总量
     */
    Integer getAreaResultNum();

    /**
     * @return 查询结果数据总量
     */
    Integer getTypeResultNum();

    List<AreaResult> getAreaResultList();

    List<TypeResult> getTypeResultList();
}
