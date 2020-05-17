package com.jike.car.api.service.impl;

import com.jike.car.api.service.InventoryService;
import com.jike.car.api.dao.InventoryDao;
import com.jike.car.api.pojo.Inventory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @program: car
 * @description:
 * @author: sv4bmy
 * @create: 2020-05-17 16:53
 **/
@Service
public class InventoryServiceImpl implements InventoryService {
    @Resource
    InventoryDao inventoryDao;

    @Override
    public String buyCar(int carId) {
        String result;

        if (inventoryDao.updateById(carId) > 0) {
            result = "购车成功！";

        } else {

            result = "该车已售完！！！";
        }

        return result;
    }


}
