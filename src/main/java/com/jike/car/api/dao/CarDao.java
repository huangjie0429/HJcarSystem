package com.jike.car.api.dao;

import com.jike.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: sv4bmy
 * @create: 2020-05-17 17:10
 **/
@Mapper
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where LOWER(carName) like #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries) values(#{carName},#{carType},#{price},#{carSeries})")
    void insertCar(Car car);
}
