package GApackage;
import java.io.FileNotFoundException;

public class Main {
    //CLEAN AND BUILD AFTER MAKING CONSIDERABLE CHANGES TO VARIABLES
    
    public final static int data = 2; //1, 2, or 3(NOT IMPLEMENTED)
    
    //GENETIC ALGORITHM VARIABLES
    public final static int popSize = 50;
    public final static double uniformRate = 0.5;
    public final static double mutationRate = 0.15;
    public final static int tournySize = 5;
    public final static boolean elitism = true;
    
    //DO NOT TOUCH, WILL BREAK EVERYTHING
    public static int rulesetSize;
    public static int ruleSize;
    public static int conditionSize;
    
    public static void main(String[] args) throws FileNotFoundException {
        setImportantVariables();
        FitnessCalc fitness = new FitnessCalc();
        fitness.collectData();
        fitness.printDataSet();
        Population pop = new Population(popSize, true);

        int generationCount = 0;

        //Process of evolution
        while (generationCount < 100) {
            generationCount++;
            System.out.println("Generation: " + generationCount + "  Fittest: " + pop.getFittest().getFitness());
            pop = Algorithm.evolvePopulation(pop);

        }
        
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Fitness: " + pop.getFittest().getFitness());

    }
    
    public static void setImportantVariables(){
        if(data == 1){
            rulesetSize = 32;
            ruleSize = 6;
            conditionSize = 5;
        } else if(data == 2){
            rulesetSize = 64;
            ruleSize = 7;
            conditionSize = 6;
        }
    }
    
    //INITIALISE GENETIC ALGORITHM VARIABLES

}

