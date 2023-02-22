package com.jsw.rulesengine.service;

import com.jsw.rulesengine.bean.Order;

public interface RulesEngineDBService {
    Order orderRefresh(Order order);
}
