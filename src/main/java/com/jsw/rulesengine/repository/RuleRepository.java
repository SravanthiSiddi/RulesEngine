package com.jsw.rulesengine.repository;

import com.jsw.rulesengine.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RuleRepository extends JpaRepository<Rule, Long> {
    List<Rule> findByRuleKey(String ruleKey);
}
