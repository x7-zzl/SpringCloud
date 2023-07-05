package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //注入feign的接口
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //利用restTemplate发送http请求，查询用户
        //硬编码不可行，采用服务名称
//        String url="http://localhost:8080/user/"+order.getUserId();
//        String url = "http://userservice/user/" + order.getUserId();

//      2.使用feign远程调用
        User user = userClient.findById(order.getUserId());

        //3.完成封装
        order.setUser(user);
        // 4.返回
        return order;
    }


  /*  @Autowired
    private RestTemplate restTemplate;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.利用restTemplate发送http请求，查询用户
        //硬编码不可行，采用服务名称
//        String url="http://localhost:8080/user/"+order.getUserId();
        String url="http://userservice/user/"+order.getUserId();

        //远程调用,返回的是json对象,但是restTemplate会帮我们封装成User对象
        User user = restTemplate.getForObject(url, User.class);

        //3.完成封装
        order.setUser(user);
        // 4.返回
        return order;
    }*/
}
