import java.util.Random;

public class SubsetSumIndividual extends Individual {
	
	private int[] values;
	private boolean[] taken;
	private int sum;
	 
	// Ctor
	public SubsetSumIndividual(int[] values, int sum) {
		super(); 
		this.values = values;
		this.sum = sum; 
		
		this.taken = new boolean[values.length];
		for (int i = 0; i < taken.length; i++) {
			this.taken[i] = false;
		}
		
		this.getFitness(); 

		for (int i = 0; i < fitness.length(); i++) {
			this.taken[i] = fitness.charAt(i) == '1' ? true : false;		
		}
		 
	}
	// Copy Ctor
	public SubsetSumIndividual(SubsetSumIndividual ssi) {
		super(ssi.id);
		this.fitness = ssi.fitness;
		
		values = ssi.values;
		sum = ssi.sum; 
		
		taken = new boolean[ssi.values.length];
		for (int i = 0; i < taken.length; i++) taken[i] = ssi.taken[i];
	}
	
	// ##### Variable interface methods ################################################
	@Override
	public Individual mutate() {
		Random rn = new Random();
		int maximum = this.fitness.length()-1;
		int minimum = 0;
		int range = maximum - minimum + 1;
		int randomIndex =  rn.nextInt(range) + minimum;
		
		char bit = fitness.charAt(randomIndex);
		String before = fitness.substring(0, randomIndex);
		String After =  fitness.substring(randomIndex+1, fitness.length());
		String mutateFitness = bit == '1'? before + "0" + After : before + "1" + After;
		
		Individual individualMutate = this.clone();
		individualMutate.fitness = mutateFitness;
		individualMutate.evaluate();
		return individualMutate;
	}
	@Override
	public Individual crossover(Individual other) {
		Random rn = new Random();
		int maximum = this.fitness.length()-1;
		int minimum = 0;
		int range = maximum - minimum + 1;
		int randomIndex =  rn.nextInt(range) + minimum;
		String first = this.fitness.substring(0, randomIndex);
		String second =  other.fitness.substring(randomIndex, other.fitness.length());
		String crossFitness = first + second;
		
		Individual individualCross = this.clone();
		individualCross.fitness = crossFitness;
		individualCross.evaluate();
		return individualCross;
	}

	// ##### Individual abstract method ################################################
	@Override
	protected double evaluate() {
		int val = 0;
		double res = sum;
		if(fitness != null) {
			for (int i = 0; i < fitness.length(); i++) {
				taken[i] = fitness.charAt(i) == '1' ? true : false;
				val += taken[i] ? values[i] : 0; 
			}	
		}
		res = sum - val;
		if (res < 0)  res = sum;		
		return res;
	}
	
	@Override
	public double getFitness() {
		if(fitness == null) {
			fitness = createBinaryString(values.length);
		}
		return evaluate();
	}
	// create the binary string of the fitness that represent the take array 
	private String createBinaryString(int n) {
		if (n == 0) {
			n = 7;
		}
		String res = "";
		while(n>0) {
			Random rn = new Random();
			res += rn.nextInt(2) == 0 ? "0" : "1";
			n--;
		}
		return res;
	}

	
	// ##### Cloneable interface method ################################################
	@Override
	public SubsetSumIndividual clone() {
		return new SubsetSumIndividual(this);
	}	
	
	// ##### Object class method ################################################
	public String toString() {
		//String strFitnessValue = "" + this.evaluate();
		String strValues = "";
		int sumTaken = 0;
		for (int i = 0; i < values.length; i++) {
			strValues += (i != values.length-1) ? "" + values[i] + "("+ getBooleanChar(taken[i]) +") ," : "" + values[i] + "("+ getBooleanChar(taken[i]) +")";
			sumTaken += taken[i] == true ? values[i] : 0;
		}
		
		int FitnessValue = (sum - sumTaken);
		
		String strFitness = "" + this.fitness;
		  
		String result = "no." + id + ")  eval: " + sum + "-" + sumTaken + "" + "= "+ FitnessValue + " | " + strValues + " ("+strFitness+").\n"; 
		return result;
	}
	// print the V to taken , and the X for didn't take item
	private String getBooleanChar(boolean b) {
		return b? "V" : "X";
	}

}
