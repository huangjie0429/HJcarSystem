package com.jike.car.api.dao;

import com.jike.car.api.pojo.Inventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * @program: car
 * @description:
 * @author: sv4bmy
 * @create: 2020-05-17 17:09
 **/
@Mapper
public interface InventoryDao {
    @Select("select * from inventory")
    List<Inventory> findAll();

    @Select("select * from inventory where id = #{id}")
    Inventory findById(int id);

    @Select("select * from inventory where carId = #{carId}")
    List<Inventory> findByCarId(int carId);

    @Delete("delete from inventory where id = #{id}")
    void deleteById(int id);

    @Update("update inventory a " +
            "INNER join(" +
            "select id,carId,count,LastUpdate "+
            "from inventory where carId = #{carId} and count<> '0'"+
            ") b on a.carId = b.carId "+
            "set a.count = b.count - 1 ,a.LastUpdate = CURRENT_TIMESTAMP")
    int updateById(int carId);

}
