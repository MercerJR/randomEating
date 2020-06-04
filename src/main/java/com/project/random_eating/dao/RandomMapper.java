package com.project.random_eating.dao;

import com.project.random_eating.model.AreaResult;
import com.project.random_eating.model.TypeResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author MercerJR
 * @Data 2020/2/11 16:30
 */
@Repository
public interface RandomMapper {

    Integer getAreaIdByName(@Param("name") String name);

    Integer getCanteenIdByName(@Param("name") String name);

    Integer getTypeIdByName(@Param("name") String name);

    /**
     * @return 查询区域数量
     */
    Integer getAreaNum();

    /**
     * @return 查询食堂数量
     */
    Integer getCanteenNum();

    /**
     * @param parent
     * @return 查询在指定区域内的食堂列表
     */
    List<Integer> getCanteenAfterArea(@Param("parent") Integer parent);

    /**
     * @return 查询吃的（叶子节点）的数量
     */
    Integer getFoodsNum();

    /**
     * @param parent
     * @return 查询食堂内的吃的id的列表
     */
    List<Integer> getFoodsAfterCanteen(@Param("parent") Integer parent);

    /**
     * @param code
     * @return 查询指定类型的吃的id的列表
     */
    List<Integer> getFoodsAfterType(@Param("code") Integer code);

    /**
     * @return 查询种类数量
     */
    Integer getTypeNum();

    /**
     * @param id
     * @return 通过Random出来的id查询区域名称
     */
    String getRandomAreaName(@Param("id") Integer id);

    /**
     * @param id
     * @return 通过Random出来的id查询食堂名称
     */
    String getRandomCanteenName(@Param("id") Integer id);

    /**
     * @param id
     * @return 通过Random出来的id查询吃的名称
     */
    String getRandomFoodsName(@Param("id") Integer id);

    /**
     * @param id
     * @return 通过Random出来的id查询吃的类型
     */
    String getRandomTypeName(@Param("id") Integer id);

    /**
     * @return 查询结果数据总量
     */
    Integer getAreaResultNum();

    /**
     * @param area
     * @return 把区域结果放入显示结果的表中
     */
    boolean putArea(@Param("area") String area);

    /**
     * @param canteen
     * @return 把食堂结果放入显示结果的表中
     */
    boolean putCanteen(@Param("canteen") String canteen);

    /**
     * @param canteen
     * @param id
     * @return 把区域之后的食堂结果放入显示结果的表中
     */
    boolean putCanteenAfterArea(@Param("canteen") String canteen, @Param("id") Integer id);

    /**
     * @param foods
     * @param id
     * @return 把吃的结果放入显示结果的表中
     */
    boolean putFoodsAfterCanteen(@Param("foods") String foods, @Param("id") Integer id);

    /**
     * @param id
     * @return 获取指定id的第一种方法的结果
     */
    AreaResult getAreaResult(@Param("id") Integer id);

    /**
     * @return 获取第二种方法结果的数量
     */
    Integer getTypeResultNum();

    /**
     * @param type
     * @return 把类型结果放入显示结果的表中
     */
    boolean putType(@Param("type") String type);

    /**
     * @param foods
     * @param id
     * @return 把吃的结果放入显示结果的表中
     */
    boolean putFoodsAfterType(@Param("foods") String foods, @Param("id") Integer id);

    /**
     * @param id
     * @return 获取指定id的第二种方法的结果
     */
    TypeResult getTypeResult(@Param("id") Integer id);

}
