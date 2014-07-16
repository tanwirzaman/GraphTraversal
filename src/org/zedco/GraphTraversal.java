package org.zedco;

public class GraphTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node nA=new Node('0');
		Node nB=new Node('1');
		Node nC=new Node('2');
		Node nD=new Node('3');
		

		Graph g=new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.rootnode=nC;
		
		g.addEdge(nA, nB);
	    g.addEdge(nA, nC);
	    g.addEdge(nB, nC);
	    g.addEdge(nC, nA);
	    g.addEdge(nC, nD);
	    g.addEdge(nD, nD);
	    
	    g.InitMap();
	    
	    g.DFS();
		
		

	}

}
