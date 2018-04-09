
public class Evolution {
	
	private final int PRINT_EACH_I_GEN = 25;
	private Population population;
	private int maxGens; 
	
	// Ctor 
	public Evolution (Population population, int maxGenerations) {
		this.population = population;
		this.maxGens = maxGenerations;
	}
	
	// get the first element in the array pop , that the best individual by the sorted array pop
	public Individual getBest() {
		return population.getBest();
	} 
	
	// the main loop of the programmin evolution 
	public void evolve() {
		Individual best = getBest();
		int i = 1; 
		System.out.println("start evolve, print each " + PRINT_EACH_I_GEN + "^th generations.");
		while(i <= maxGens && !best.isIdeal()) { 
			// output in each iteration the number generation and the best current individual 
			if (i % PRINT_EACH_I_GEN == 0) System.out.format("Gen %5d : %s",  i , best);
			
			population.nextGeneration();
			best = getBest();
			i++;
		}
		if(best.isIdeal()) {
			System.out.println("\n**********************************************************");
			System.out.println("Find the IDEAL Result (in generation " + (--i) + "):");
		}
		else {
			System.out.println("\n##########################################################");
			System.out.println("finished run all the " + maxGens + " generations\nThe closest result is:\n");
		}
	}
}
