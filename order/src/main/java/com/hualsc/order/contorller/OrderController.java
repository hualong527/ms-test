package com.hualsc.order.contorller;

import com.hualsc.order.mapper.OrderDetailMapper;
import com.hualsc.order.mapper.OrderMapper;
import com.hualsc.order.param.OrderCreateParam;
import com.hualsc.order.po.Order;
import com.hualsc.order.po.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @RequestMapping("query")
    public Order query(@RequestParam("id") Long orderId){
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @RequestMapping("create")
    public Long create(@RequestBody OrderCreateParam param){
        Date nowDate = new Date();
        //
        Order order = new Order();
        order.setNo(param.getNo());
        order.setUserId(param.getUserId());
        order.setCreateDate(nowDate);
        order.setModifyDate(nowDate);
        order.setOrderDate(nowDate);
        //
        orderMapper.insert(order);
        for (OrderDetail orderDetail: param.getOrderDetails()) {
            orderDetail.setOrderId(order.getId());
            orderDetail.setUserId(order.getUserId());
            orderDetail.setCreateDate(nowDate);
            orderDetail.setModifyDate(nowDate);
            orderDetail.setAmount(orderDetail.getPrice().multiply(orderDetail.getQty()));
            orderDetailMapper.insert(orderDetail);
        }
        return order.getId();
    }
}
