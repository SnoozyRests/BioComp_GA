package GApackage;

public class Population {
    
    //population variables, imports from main, look but dont touch
    RuleSet[] population;
    private int ruleSetSize = Main.rulesetSize;
    
     public Population(int populationSize, boolean initialise){
        population = new RuleSet[populationSize];
        if(initialise){
            for (int i=0;i<population.length; i++){
                RuleSet newRuleSet = new RuleSet(ruleSetSize, true);
                saveRuleSet(i,newRuleSet);
            }
        }
    }
     
     public RuleSet getRuleSet(int index){
         return population[index];
     }
     
     public void saveRuleSet(int index, RuleSet ruleSet){
        population[index] = ruleSet;
    }
     
     public RuleSet getFittest(){
        RuleSet fittest = population[0];
        for(int i=0; i<population.length; i++){
            if(fittest.getFitness() <= getRuleSet(i).getFitness()){
                fittest = getRuleSet(i);
            }
        }
        return fittest;
    }
     
    public int size(){
        return population.length;
    }
    
}
