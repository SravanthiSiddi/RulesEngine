package com.jsw.rulesengine.serviceimpl;

import com.jsw.rulesengine.bean.Order;
import com.jsw.rulesengine.service.RulesEngineService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RulesEngineServiceImpl implements RulesEngineService {
 //   @Autowired
   // private KieSession session;
    @Override
    public Order orderNow(Order order) {
    //    session.insert(order);
      //  session.fireAllRules();
        return order;
    }



}
