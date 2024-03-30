package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingStrategyManager {
    private List<MarketingStrategy> strategies;

    public MarketingStrategyManager() {
        this.strategies = new ArrayList<>();
    }

    public void createStrategy(MarketingStrategy strategy) {
        //your code goes here
        if(strategy !=null){
            strategies.add(strategy);
        }
    }

    public MarketingStrategy getStrategyByName(String name) {
        //your code goes here
        return strategies.stream()
                .filter(strategy -> strategy.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void updateStrategy(MarketingStrategy updatedStrategy) {
        //your code goes here
        String name = updatedStrategy.getName();
        for(MarketingStrategy strategy : strategies){
            if(strategy.getName().equals(name)){
                strategy.setName(updatedStrategy.getName());
                strategy.setBudget(updatedStrategy.getBudget());
                strategy.setDescription(updatedStrategy.getDescription());
                strategy.setPotentialROI(updatedStrategy.getPotentialROI());
                strategy.setTargetAudience(updatedStrategy.getTargetAudience());
                break;
            }
        }
    }

    public void deleteStrategy(String name) {
        //your code goes here
        for(MarketingStrategy strategy : strategies){
            if(strategy.getName().equals(name)){
                strategies.remove(strategy);
                break;
            }
        }
    }

    public List<MarketingStrategy> getStrategiesInBudgetRange(double minBudget, double maxBudget) {
        //your code goes here
        return strategies.stream()
                .filter(strategy -> strategy.getBudget() >= minBudget && strategy.getBudget() <= maxBudget)
                .collect(Collectors.toList());
    }

    public List<MarketingStrategy> getAllStrategies() {
        //your code goes here
        return new ArrayList<>(strategies);
    }
}

