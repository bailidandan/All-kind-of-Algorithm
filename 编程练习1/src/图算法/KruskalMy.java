package 图算法;
import java.util.Arrays;

import java.util.*;
public class KruskalMy {
	static class Edge implements Comparable<Edge>//关于的边的限制，同时利用了自带的比较函数，进行排序
	{
        private int i,j,w;
        Edge(int i,int j,int w)
        {
        	this.i=i;
        	this.j=j;
        	this.w=w;
        }
		@Override
		public int compareTo(Edge edge) {
			if(this.w==edge.w) return 0;
			else if(this.w<edge.w) return -1;
			else return 1;
		}
		
	}
	  public static void main(String [] args){ //kruskal算法，强调了点和边的分离
	        int [] V={1,2,3,4,5,6};  
	        Edge [] E=new Edge[10];  
	        E[0]=new Edge(1,2,6);  
	        E[1]=new Edge(1,3,1);  
	        E[2]=new Edge(1,4,5);  
	        E[3]=new Edge(2,3,5);  
	        E[4]=new Edge(2,5,3);  
	        E[5]=new Edge(3,4,5);  
	        E[6]=new Edge(3,5,6);  
	        E[7]=new Edge(3,6,4);  
	        E[8]=new Edge(4,6,2);  
	        E[9]=new Edge(5,6,6);  
	        kruskal(V, E);  
	    }  
	  
	  
	  public static void kruskal(int [] V,Edge [] E)
	  {
		  Arrays.sort(E);
		  int m=V.length;
		  int n=E.length;
		  //每个set表示一棵树,list表示森林
		  ArrayList<HashSet<Integer>> list=new ArrayList<HashSet<Integer>>();
		  ArrayList<Edge> edges=new ArrayList<Edge>();
		  
		  
		  //初始化每个点构成一棵树
		  for(int i=0;i<m;i++)
		  {
			  HashSet<Integer> set= new HashSet<Integer>();
			  set.add(V[i]);
			  
			  list.add(set);
		  }
		  
		  //每个边依次出列
		  
		  
		  for(int i=0;i<n;i++)
		  {
			  Edge edge=E[i];
			  int a=edge.i;
			  int b=edge.j;
			  int counta=-1;
			  int countb=-1;
			  //首先要找到边上两点所在的树
			  for(int j=0;j<list.size();j++){
				  HashSet<Integer> set=list.get(j);//依次的取出所有的点（这里，可能不仅仅是一个点，更有可能是一个点的集合，类似与一颗树之类的东西）
				  
				  if(set.contains(a))
				  {
					  counta=j;
				  }
				  if(set.contains(b))
				  {
					  countb=j;
				  }
			  }
			  
			  
			  
			  
			  //没找到点
			  if(counta==-1||countb==-1)
			  {
				  return;
			  }
			  else
			  {
				  //两点在不同的树
				  if(counta!=countb)//两点在同一个树上就会构成环形，不过这里我没有弄明白
				  {
					  HashSet<Integer> set1=list.get(counta);
					  HashSet<Integer> set2=list.get(countb);
					  
					  set1.addAll(set2);
					  //删除集合的时候要注意。连续删除两个集合
					  
					  //要搞明白，删除的方法
					  if(counta<countb){
					    list.remove(counta);//因为a之前已经被添加上去了，所以不在这里保存了
					    
					    list.remove(countb-1);//在删除了a之后，整个的list的序号已经发生了改变，所以想要删除b，就应该让b-1再处理
					  }
					  else
					  {
						  list.remove(countb);
						  list.remove(counta-1);
					  }
					  
					  
					  list.add(set1);//在满足了以上的两个删除之后，才能往上面继续添加点
					  edges.add(edge);
					  System.out.println("将边"+edge.i+"--->"+edge.j+"加入，其权值为"+edge.w);
				  }
				  else
				  {
					  System.out.println("不能加入"+edge.i+"--->"+edge.j+"两点在同一个树中");
				  }
			  }
		  }
	  }
}
