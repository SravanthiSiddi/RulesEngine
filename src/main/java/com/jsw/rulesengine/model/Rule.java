package com.jsw.rulesengine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private Long id;
    @Column(name = "rule_key")
    private String ruleKey;
    @Column(name = "rule_content")
    private String content;
    @Column(name = "created_date")
    private String createTime;
}
