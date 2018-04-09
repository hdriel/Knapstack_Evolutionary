public abstract class Individual implements Comparable<Individual> , Cloneable, Variable{
	
	protected String fitness; 
	public final int IDEAL_FITNESS = 0;
	protected int id;
	protected static int ID = 0;
	
	// Ctor
	public Individual() {
		fitness = null;
		id = ID;
		ID++; 
	}
	public Individual(int id) {
		fitness = null;
		this.id = id;
	}
	// Copy Ctor
	public Individual(Individual ind) { 
		fitness = new String(ind.fitness);
		id = ind.id;
	}
	 
	public static void updateStaticID(int i) {
		ID = i;
	}
	public static int getStaticID() {
		return ID;
	}
	
	// get the value of the fitness
	public abstract double getFitness(); 
	 
	// evaluate the individual (implements at the SubsetSumIndividual class which extends this abstract class)
	protected abstract double evaluate();
	
	// return if we got in this individual the ideal fitness that equal to zero
	public boolean isIdeal() {
		return evaluate() == IDEAL_FITNESS;
	}
	
	// ###### implements methods of interfaces ####################################################################
	
	// the compare method , compare between 2 individual by the lower value of the fitness.
	@Override
	public int compareTo(Individual item) {
		if(this.evaluate() < item.evaluate()){
			return -1;
		}
		else if(this.evaluate() > item.evaluate()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	// the clone method (implements at the SubsetSumIndividual class which extends this abstract class)
	@Override
	public abstract Individual clone();
}
