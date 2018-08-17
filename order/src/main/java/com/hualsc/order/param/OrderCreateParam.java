package com.hualsc.order.param;

import com.hualsc.order.po.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderCreateParam {
    private Long userId;

    private Integer no;

    public List<OrderDetail> orderDetails;

}
