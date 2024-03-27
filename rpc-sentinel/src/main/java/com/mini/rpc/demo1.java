//package com.mini.rpc;
//
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
//import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class demo1 {
//    private void initFlowRules(String name) {
//        List<FlowRule> flowRules = new ArrayList<>();
//        FlowRule ruleF = new FlowRule();
//        ruleF.setResource(name);
//        ruleF.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        ruleF.setCount(20);
//        flowRules.add(ruleF);
//        FlowRuleManager.loadRules(flowRules);
//
//        List<DegradeRule> degradeRules = new ArrayList<>();
//        DegradeRule ruleD = new DegradeRule(name)
//                .setGrade(CircuitBreakerStrategy.SLOW_REQUEST_RATIO.getType())
//                // Max allowed response time
//                .setCount(50)
//                // Retry timeout (in second)
//                .setTimeWindow(10)
//                // Circuit breaker opens when slow request ratio > 60%
//                .setSlowRatioThreshold(0.6)
//                .setMinRequestAmount(100)
//                .setStatIntervalMs(20000);
//        degradeRules.add(ruleD);
//        DegradeRuleManager.loadRules(degradeRules);
//    }
//}
