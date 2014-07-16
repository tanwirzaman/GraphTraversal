package org.zedco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	public Node rootnode;
	public ArrayList<Node> nodes=new ArrayList<Node>();
	public int[][] adjMatrix;
	public HashMap<Node,Boolean> visited=new HashMap<Node,Boolean>();
	int size;
	
	
	public void addNode(Node n)
	{
		nodes.add(n);
	}
	
	public void addEdge(Node start,Node end)
	{
		if(adjMatrix==null)
		{
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		//adjMatrix[endIndex][startIndex]=1;
	}
	
	public void InitMap()
	{
		for(Node n:nodes)
		{
			visited.put(n, false);
		}
	}
	
	private Node getNeighBorNode(Node n)
	{		
		int index=nodes.indexOf(n);
		int j=0;
		while(j<size)
		{
			if(adjMatrix[index][j]==1 && visited.get(nodes.get(j))==false)
			{
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	
	private void clearNodes()
	{
		int i=0;
		while(i<size)
		{
			Node n=(Node)nodes.get(i);
			visited.put(n, false);
			i++;
		}
	}
	private void printNode(Node n)
	{
		System.out.print(n.label+" ");
	}
	
	public void DFS()
	{
		Stack<Node> st=new Stack<Node>();
		st.push(this.rootnode);
		visited.put(rootnode, true);
		printNode(rootnode);
		while(!st.isEmpty())
		{
			Node n=(Node)st.peek();
			Node neighbor=getNeighBorNode(n);
			if(neighbor!=null)
			{
				visited.put(neighbor, true);
				printNode(neighbor);
				st.push(neighbor);
			}
			else
			{
				st.pop();
			}
		}
		clearNodes();
	}
	
	public void BFS()
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(this.rootnode);
		visited.put(rootnode, true);
		printNode(rootnode);
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node neighbor=null;
			while((neighbor=getNeighBorNode(n))!=null)
			{
				visited.put(neighbor, true);
				printNode(neighbor);
				q.add(neighbor);
			}
		}
		clearNodes();
		
	}

}
