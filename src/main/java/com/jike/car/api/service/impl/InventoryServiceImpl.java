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
 * @author: spcdle
 * @create: 2020-05-10 14:56
 **/
@Service
public class InventoryServiceImpl implements InventoryService {
    @Resource
    InventoryDao inventoryDao;

    @Override
    public String buyCar(int carId, String person) {
        String result;
        List<Inventory> list = inventoryDao.findByCarId(carId);
        if (list.size() > 0) {
            if (list.get(0).getCount() > 0) {

                if (list.get(0).getLocked() == 0) {
                    Inventory inventory = new Inventory()
                            .setId(list.get(0).getId())
                            .setCarId(list.get(0).getCarId())
                            .setLocked(1)
                            .setCount(list.get(0).getCount())
                            .setLockPerson(person);
                    inventoryDao.updateById(inventory);
                    inventory = inventoryDao.findByCarId(carId).get(0);
                    if (inventory.getLocked() == 1 && inventory.getLockPerson().equals(person)) {
                        inventory.setCount(inventory.getCount() - 1)
                                .setLockPerson("")
                                .setLocked(0);
                        if (inventoryDao.updateById(inventory) > 0) {
                            result = "购车成功！";
                        } else {
                            result = "系统忙请稍后重试！";
                        }
                    } else {
                        result = "系统忙请稍后重试！";
                    }


                } else {
                    result = "系统忙请稍后重试！";
                }


            } else {
                result = "此车已售完！";
            }
        } else {
            result = "查不到此车！";
        }
        return result;
    }


}
