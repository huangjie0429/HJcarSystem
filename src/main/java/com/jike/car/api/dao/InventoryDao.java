package com.jike.car.api.dao;

import com.jike.car.api.pojo.Inventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;



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

    @Update("update inventory set carId=#{carId},count=#{count}, locked=#{locked},lockPerson=#{lockPerson} where id = #{id}")
    int updateById(Inventory inventory);


}
