package GApackage;

public class Algorithm {
    static int ruleSetSize = Main.rulesetSize;
    
    //GA parameters, imports from main, no touchy
    private static final double uniformRate = Main.uniformRate;
    private static final double mutationRate = Main.mutationRate;
    private static final int tournamentSize = Main.tournySize;
    private static final boolean elitism = Main.elitism;
    
    public static Population evolvePopulation (Population pop){
        Population newPopulation = new Population(pop.size(), false);
        
        //Elitism Handler
        if(elitism){
            newPopulation.saveRuleSet(0, pop.getFittest());
        }
        int elitismOffset;
        if(elitism){
            elitismOffset =1;
        }else{
            elitismOffset =0;
        }
        
        //Crossover handler
        for(int i = elitismOffset; i < pop.size(); i++){
            RuleSet ruleSet1 = tournamentSelection(pop);
            RuleSet ruleSet2 = tournamentSelection(pop);
            RuleSet newRuleSet = crossover(ruleSet1, ruleSet2);
            newPopulation.saveRuleSet(i, newRuleSet);
        }
        
        //Mutation handler
        for(int i = elitismOffset; i <newPopulation.size(); i++){
            newPopulation.population[i] =  mutate(newPopulation.getRuleSet(i));
        }
        return newPopulation;
    }
    
    //Crossover Function
    private static RuleSet crossover(RuleSet ruleSet1, RuleSet ruleSet2){
        RuleSet newSol = new RuleSet(ruleSetSize, false);
        for(int i = 0; i < ruleSet1.size(); i++){
            if(Math.random() <= uniformRate){
                newSol.saveRule(i, ruleSet1.getRule(i));
            }else { 
                newSol.saveRule(i, ruleSet2.getRule(i));
            }
        }
        return newSol;
    }
    
    //Mutation function
    private static RuleSet mutate(RuleSet ruleSet){
        for(int i=0; i<ruleSet.size(); i++){
            if(Math.random() <= mutationRate){
                Rule mutant = new Rule();
                mutant.generateRule();
                ruleSet.saveRule(i, mutant);
            }
        }
        return ruleSet;
    }
    
    //Tournament selection function
    private static RuleSet tournamentSelection(Population pop){
        Population tournament = new Population(tournamentSize, false);
        for(int i=0; i < tournamentSize; i++){
            int randomID = (int) (Math.random() * pop.size());
            tournament.saveRuleSet(i, pop.getRuleSet(randomID));
        }
        RuleSet fittest = tournament.getFittest();
        return fittest;
    }
        
}
    

