package Graph;

import HelpGraph.List;

public class GraphNode {
	public int data;
	public GraphList child;
	public GraphNode next;//����
	public GraphNode to;//����
	
	public GraphNode(int data){
		this.data=data;
	}
}
