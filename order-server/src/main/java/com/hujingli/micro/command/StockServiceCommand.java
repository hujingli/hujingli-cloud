package com.hujingli.micro.command;

import com.hujingli.micro.common.bean.Stock;
import com.hujingli.micro.common.rest.response.BaseResponse;
import com.hujingli.micro.service.StockServiceFeign;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 使用代码的形式来进行服务降级
 */

public class StockServiceCommand extends HystrixCommand<BaseResponse> {

    private StockServiceFeign stockServiceFeign ;

    public StockServiceCommand( StockServiceFeign stockServiceFeign) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"), 1000);
        this.stockServiceFeign = stockServiceFeign;
    }

    @Override
    protected BaseResponse run() throws Exception {
        return stockServiceFeign.minus();
    }

    @Override
    protected BaseResponse getFallback() {

        return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务降级");
    }
}