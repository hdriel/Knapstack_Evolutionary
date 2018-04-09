# A Knapsack Evolutionary project

## **Evolution programming** in a Java Project

Some computational problems, such as sorting numbers and searching in an ordered list, are quite easy to solve. In this course we have introduced efficient algorithms to
solve such problems—and implemented them in Java. However, many—if not most—problems in real life are hard and either can be proved to admit no easy solution (i.e., no polynomial-time algorithm), or shown to belong to classes of problems wherein most likely easy solutions do not exist. The knapsack problem is an example of a
hard problem in computer science. 

Suppose a thief has a knapsack with a certain capacity, i.e., the sack can hold at most a given weight. She looks around the house she has broken into and sees different items of different weights and values. She would like the items she chooses for her knapsack to have the greatest value possible yet still fit in her knapsack. More precisely: Given a set of items, each with a weight and a value, determine which items to include in a collection so that the total weight does not exceed a given limit and the total value is as large as possible. This is known as the 0-1 knapsack problem since the number of copies of each kind of item is restricted to zero or one.

A simple algorithm immediately comes to mind. Thinking about the problem we realize that, basically, we have a set of items, and wish to find a subset of maximal value whose weight is less than or equal to the sack’s capacity. So let’s simply try each subset of items, and select the best one.

This simple algorithm is called exhaustive search, since it tries out all possible subsets. It is guaranteed to provide a correct answer. However, its runtime is very
high: if the number of items (size of set) is n, then the number of subsets is 2n (since each item can either belong or not to a subset). Thus, the runtime of this algorithm is exponential. And exponential is bad. . . 

No polynomial-time algorithm is known for the knapsack problem. Does this mean we cannot solve it in a reasonable (i.e., less than exponential) amount of time?
Yes and No. If we are willing to give up the demand that our algorithm provide the best possible answer, and are willing instead to settle simply for a good solution
(though not necessarily best), then the field of artificial intelligence (AI) provides us with many approximate, often stochastic (i.e., probabilistic) algorithms that can address problems such as knapsack.

In this project we will use a so-called **evolutionary algorithm**.


For example if we try from this array to collect sum value of 83: 
```Java
public class SubsetSumMain {
	public static void main(String[] args) {
		
		int[] values = {7,3,5,10,13,17,7,20,90,12,80};  
		int sum = 48;
		int popSize = 100; // 100
		int maxGenerations = 1000; // 1000
		double mutationProb = 0.2;
		double crossoverProb = 0.8;
		
		Evolution evolution = new SubsetSumEvolution( values, sum, popSize,	maxGenerations,	mutationProb, crossoverProb);
		evolution.evolve(); 
		
		System.out.println(evolution.getBest());
	}
}
```
we can get the closest solution which look like that:

```
start evolve, print each 25^th generations.
Gen    25 : no.11)  eval: 48-46= 2 | 7(X) ,3(X) ,5(X) ,10(V) ,13(X) ,17(V) ,7(V) ,20(X) ,90(X) ,12(V) ,80(X) (00010110010).
Gen    50 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen    75 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   100 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   125 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   150 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   175 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   200 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   225 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   250 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   275 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   300 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   325 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   350 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   375 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   400 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   425 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   450 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   475 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   500 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   525 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   550 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   575 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   600 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   625 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   650 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   675 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   700 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   725 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   750 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   775 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   800 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   825 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).
Gen   850 : no.11)  eval: 48-47= 1 | 7(X) ,3(X) ,5(X) ,10(V) ,13(V) ,17(V) ,7(V) ,20(X) ,90(X) ,12(X) ,80(X) (00011110000).

**********************************************************
Find the IDEAL Result (in generation 870):
no.11)  eval: 48-48= 0 | 7(X) ,3(V) ,5(V) ,10(V) ,13(V) ,17(V) ,7(X) ,20(X) ,90(X) ,12(X) ,80(X) (01111100000).
```

if we run again the project we can get another solution , even faster the the previes one: 

```
start evolve, print each 25^th generations.
Gen    25 : no.60)  eval: 48-47= 1 | 7(X) ,3(X) ,5(V) ,10(V) ,13(X) ,17(X) ,7(X) ,20(V) ,90(X) ,12(V) ,80(X) (00110001010).
Gen    50 : no.13)  eval: 48-47= 1 | 7(X) ,3(X) ,5(V) ,10(V) ,13(X) ,17(X) ,7(X) ,20(V) ,90(X) ,12(V) ,80(X) (00110001010).

**********************************************************
Find the IDEAL Result (in generation 57):
no.13)  eval: 48-48= 0 | 7(X) ,3(X) ,5(V) ,10(V) ,13(V) ,17(X) ,7(X) ,20(V) ,90(X) ,12(X) ,80(X) (00111001000).
```


