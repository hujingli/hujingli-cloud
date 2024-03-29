package com.hujingli.micro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author exphuhong
 * @link{exphuhong@163.com} 订单controller
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController<T> {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private DiscoveryClient client;


    /**
     * 测试
     */
    @GetMapping(value = "/hello")
    public void index() {

        List<ServiceInstance> instance = client.getInstances("order-service");

        instance.forEach(item-> logger.info("应用主机:{}, 端口:{}", item.getHost(), item.getPort()));


    }


    /**
     * 保存订单
     */
    @ApiOperation(value = "保存订单",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message="保存订单成功")
    })
    @PostMapping("/")
    public /*OneResponse<T>*/ String saveOrder(){

        return null;
    }

}

