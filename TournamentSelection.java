import java.util.Random;

public class TournamentSelection implements Selection{
	
	private double Pmutate;
	private double Pcross;
	private Random randomer = new Random();
	
	// Ctor
	public TournamentSelection(double mutationProb, double crossoverProb) {
		Pmutate = mutationProb;
		Pcross  = crossoverProb;
	} 
	 
	
	// implement the selection interface method 
	@Override
	public Individual reproduce(Individual[] pop) {
		double randomProbCross = randomer.nextDouble();
		double randomProbMutate = randomer.nextDouble();
		Individual[] parents = get2Parents(pop);
		Individual newIndividual = parents[0].clone(); 
		//System.out.print("reproduced:\nfrom: " + newIndividual);
		if (randomProbCross <= Pcross)  
		{
			newIndividual = parents[0].crossover(parents[1]);
			//System.out.print("did crossover: " + newIndividual);
		}
		if (randomProbMutate <= Pmutate) 
		{
			newIndividual = newIndividual.mutate();
			//System.out.print("did mutate   : " + newIndividual);
		} 
		//System.out.print("to  : " + newIndividual);
		return newIndividual;
	}
	
	
	// -------------------------------------------------------------------------------------------------
	// Describe the choose methods 
	// get Parent method: 
	// for choose parent do: choose 2 random individual and choose the best for them be compare method
	// choose by the last phase 2 parent in sorted order
	// the we can do crossover from these parents by probability of Pcross
	// nether crossover or not , do mutation by probability of Pmutate from the best parent (first one)
	// unless crossover or mutate, return the best parent (first one) like he was to the next generation. 
	
	// return 2 parents for the crossover methods
	private Individual[] get2Parents(Individual[] pop) {
		Individual[] parrents = new Individual[2];
		parrents[0] = getOneFromTwo(pop);
		parrents[1] = getOneFromTwo(pop);
		if(parrents[0].compareTo(parrents[1]) > 0) swapIndeviduals(parrents[0], parrents[1]);
		return parrents;
	}
	
	// get one individual from 2 random individual to create one parent  
	private Individual getOneFromTwo(Individual[] pop) {
		Individual A = getRandIndividual(pop);
		Individual B = getRandIndividual(pop);
		if(A.compareTo(B) <= 0) {
			return A;
		}
		else {
			return B;
		}		
	}
	
	// get random individual from the population  
	private Individual getRandIndividual(Individual[] pop) {
		int rangePop = (pop.length-1) - 0 + 1;
		int randInd = randomer.nextInt(rangePop);
		return pop[randInd];
	}
	
	// swap between to OBJECT (by references)
	private void swapIndeviduals(Individual A, Individual B) {
		Individual T = A;
		A = B;
		B = T;
	}
	
}
