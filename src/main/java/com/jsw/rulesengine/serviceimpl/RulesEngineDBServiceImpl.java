package com.jsw.rulesengine.serviceimpl;

import com.jsw.rulesengine.bean.Order;
import com.jsw.rulesengine.model.Rule;
import com.jsw.rulesengine.repository.RuleRepository;
import com.jsw.rulesengine.service.RulesEngineDBService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RulesEngineDBServiceImpl implements RulesEngineDBService {

    public static KieContainer kieContainer;
    @Autowired
    private RuleRepository ruleRepository;

    public  Order orderRefresh(Order order){
        KieContainer kieContainer=loadContainerFromString(loadRules(order.getRuleKey()));
        this.kieContainer=kieContainer;
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;


    }

    private List<Rule>  loadRules(String ruleKey){
        List<Rule> rules=ruleRepository.findByRuleKey(ruleKey);
//        System.out.println(rules.toString());
        return rules;
    }

    private  KieContainer loadContainerFromString(List<Rule> rules) {
        long startTime = System.currentTimeMillis();
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();

        for (Rule rule:rules) {
            String  drl=rule.getContent();
            kfs.write("src/main/resources/" + drl.hashCode() + ".drl", drl);
        }

        KieBuilder kb = ks.newKieBuilder(kfs);

        kb.buildAll();
        if (kb.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time to build rules : " + (endTime - startTime)  + " ms" );
        startTime = System.currentTimeMillis();
        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        endTime = System.currentTimeMillis();
        System.out.println("Time to load container: " + (endTime - startTime)  + " ms" );
        return kContainer;
    }


}
