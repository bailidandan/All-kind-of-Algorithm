package TestQuestion;

public class ex1 {
	public int[] gas;
	public int[] cost;
	public int testAll(int[] gas,int[] cost){
		for (int i = 0; i < gas.length; i++) {
			if(testReturn(i)) 
				return i;
		}
		return -1;
	}

	public boolean testReturn(int start) {
		int i=start,rest=0,power=0;
		boolean judge=false;
		while(true){
			power=rest+gas[i];//正式开始出发
			if((rest=power-cost[i])<0)
				break;
			i=(i+1)%5;//车此时站的位置
			if(i==start)
				{
					judge=true;
					break;
				}
		}
		return judge;
	}
	public static void main(String[] args) {
		ex1 e=new ex1();
		int[] gas={2,3,5,1,8};
		int[] cost={5,3,4,2,5};
		int start;
		e.gas=gas;
		e.cost=cost;
		
		if((start=e.testAll(gas, cost))!=-1){
			System.out.println("可以环绕,起始地点："+start);
		}
		
	}

}
