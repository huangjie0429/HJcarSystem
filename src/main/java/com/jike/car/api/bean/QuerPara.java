package com.jike.car.api.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: car
 * @description:
 * @author: sv4bmy
 * @create: 2020-05-17 16:14
 **/
@Data
@Accessors(chain = true)
public class QuerPara {
    int pageNum;
    int pageSize;
    String carName;
}
