package com.jsw.rulesengine.controller;

import com.jsw.rulesengine.bean.Order;
import com.jsw.rulesengine.service.RulesEngineDBService;
import com.jsw.rulesengine.service.RulesEngineService;
import org.drools.template.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules-engine")
public class RulesEngineController {
    @Autowired
    RulesEngineService rulesEngineService;
    @Autowired
    RulesEngineDBService rulesEngineDBService;

    @PostMapping("/order")
    public Order orderNow(@RequestBody Order order){
        Order orderNow = rulesEngineService.orderNow(order);
        return orderNow;
    }
    @PostMapping("/order_refresh")
    public Order orderRefresh(@RequestBody Order orderInput){
        Order orderNow = rulesEngineDBService.orderRefresh(orderInput);
        return orderNow;
    }

}
