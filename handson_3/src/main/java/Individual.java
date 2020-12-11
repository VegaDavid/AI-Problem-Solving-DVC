
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Individual
{
    public static final int SIZE = 6;
    private int[] genes = new int[SIZE];
    private int Binary[] = {1,2,-3,1,4,1}; // a + 2b - 3c + d + 4e + f = 30
    private int fitnessValue;

    public Individual() {}

    public int getFitnessValue() 
    {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) 
    {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) 
    {
        return genes[index];
    }

    public void setGene(int index, int gene) 
    {
        this.genes[index] = gene;
    }

    public void randGenes() 
    {
    	
        Random rand = new Random();
        for(int i=0; i<SIZE; ++i) 
        {
            this.setGene(i, ThreadLocalRandom.current().nextInt(0, 9));
        }
    }

    public void mutate() 
    {
        Random rand = new Random();
        int index = ThreadLocalRandom.current().nextInt(0, SIZE);
        this.setGene(index, Math.abs(1-this.getGene(index)));    // flip
    }

    public int evaluate() 
    {
        int fitness = 0;
        for(int i=0; i<SIZE; ++i) 
        { 
            fitness += this.getGene(i) * Binary[i];
        }
        this.setFitnessValue(fitness);

        return fitness;
    }
}