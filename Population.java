
public class Population {
	
	private Individual[] pop = null;
	private Selection selection;
	
	// Ctor
	public Population(int size, Individual prototype , Selection selection) {
		pop = new Individual[size];
		for (int i = 0; i < pop.length; i++) {
			pop[i] = prototype.clone();
			Individual.updateStaticID(Individual.ID+1);
			pop[i].id = Individual.getStaticID();
		}
		this.selection = selection;
		//printPop("POP", pop);
	}
	 
	
	 
	// get the best individual who have the lower fitness, because the array is sorted, the lower fitness founded int the first cell. 
	public Individual getBest() {
		if(pop != null)
			return pop[0];
		else return null;
	}
	 
	
	// create the new generation of population
	public void nextGeneration() {
		Individual[] newPop =  new Individual[pop.length];
		for (int i = 0; i < newPop.length; i++) {
			newPop[i] = selection.reproduce(pop);
		}
		//printPop("Befor Sort", newPop);
		sort(newPop, 0, newPop.length-1); // sort the array population by the quick sort algorithm below
		pop = newPop;
		//printPop("After Sort", pop);
	}
	
	// print the pop for debugging 
	private void printPop(String msg, Individual[] pop) {
		System.out.println(msg);
		for (int i = 0; i < pop.length; i++) {
			System.out.print(pop[i]);
		}
		System.out.println("---------------------------------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// ######### QUICK SORT INDIDVIDUAL ARRAY ############################################################ 
	
	/* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
	private int partition(Individual arr[], int low, int high)
	{
	 	Individual pivot = arr[high]; 
	     int i = (low-1); // index of smaller element
	     for (int j=low; j<high; j++)
	     {
	         // If current element is smaller than or
	         // equal to pivot
	         if (arr[j].compareTo(pivot) <= 0)
	         {
	             i++;
	
	             // swap arr[i] and arr[j]
	             Individual temp = arr[i];
	             arr[i] = arr[j];
	             arr[j] = temp;
	         }
	     }
	
	     // swap arr[i+1] and arr[high] (or pivot)
	     Individual temp = arr[i+1];
	     arr[i+1] = arr[high];
	     arr[high] = temp;
	
	     return i+1;
	}


 /* The main function that implements QuickSort()
   arr[] --> Array to be sorted,
   low  --> Starting index,
   high  --> Ending index */
	private void sort(Individual arr[], int low, int high)
	{
	     if (low < high)
	     {
	         /* pi is partitioning index, arr[pi] is 
	           now at right place */
	         int pi = partition(arr, low, high);
	
	         // Recursively sort elements before
	         // partition and after partition
	         sort(arr, low, pi-1);
	         sort(arr, pi+1, high);
	     }
	 }
		
}
