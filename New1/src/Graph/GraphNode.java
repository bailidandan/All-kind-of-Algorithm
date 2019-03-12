package Graph;

import HelpGraph.List;

public class GraphNode {
	public int data;
	public GraphList child;
	public GraphNode next;//ÊúÏò
	public GraphNode to;//ºáÏò
	
	public GraphNode(int data){
		this.data=data;
	}
}
