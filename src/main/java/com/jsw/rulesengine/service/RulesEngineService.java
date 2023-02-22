package com.jsw.rulesengine.service;

import com.jsw.rulesengine.bean.Order;
import org.springframework.stereotype.Service;

public interface RulesEngineService {
    Order orderNow(Order order);
}
