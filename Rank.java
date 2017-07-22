package main_package;

import edu.canisius.graph.ALDGraph;
import edu.canisius.graph.Edge;
import edu.canisius.graph.Vertex;

public class Rank {
	
	ALDGraph myGraph = new ALDGraph();	// for testing
	
	//Iterable<Vertex<V>> vit = new Iterable<Vertex<V>>();;
	//Iterable<Vertex<V>> vertices();
	
	Iterable vit = myGraph.vertices();
	
	public void Ranker(){	
		
		//foreach vertex v in your graph
		for (Vertex v: myGraph){
			//Set v's weight to 1
			v.weight = 1;
		}
		double delta;
		do {
			delta = 0.0;
			// foreach Vertex v in your graph
			for (Vertex v: myGraph){
				//Compute the new page rank for v
				double sumRanks = 0.0;
				// foreach Edge e that has v as its target
				for (Edge e: v){
					// Declare a variable named src and set it equal to e's source
					e = src;
					// sumRanks += (src's weight) / (number of Edges that have src as its source)
					sumRanks += src.weight;
				}	// end for
				sumRanks = (1 - 0.85) + (0.85 * sumRanks);
			}	// end for
			// ??? Perform some action to record sumRank as next weight of v WITHOUT changing  v's weight
			for (Vertex v: myGraph){
				// ??? Declare a variable, named newWeight, and set it equal to weight calculated for v in previous loop
				newWeight = v.weight;
				// delta +=  Math.abs(v's weight - newWeight)
				delta += Math.abs(v.weight - newWeight);
				// Set v's weight to newWeight
				v.weight = newWeight;
			}	// end for
		} while (delta > 0.001);
	}
}
