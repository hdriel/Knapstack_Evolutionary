

public interface Variable {

	// the mutate method opposite one bit random from the individual string 
	public Individual mutate();
	
	
	// choose two parent and random bit , 
	// and recombine from the first parent until the bit index position , 
	// and the rest from the second parent from this index random bit.  
	public Individual crossover(Individual other);
}
