package com.jike.car.api.testclass;

import com.jike.car.api.service.InventoryService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: car
 * @description:
 * @author: sv4bmy
 * @create: 2020-05-17 16:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest()
public class InventoryServiceTest {
    @Resource
    InventoryService inventoryService;
    @Test
    public void buyCarTest(){
       // Assertions.assertEquals("购车成功！",inventoryService.buyCar(12));
    }

}
