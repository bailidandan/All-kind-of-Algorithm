package test01;

import java.util.Scanner;


public class ex5 {

	int visitAdd[];
	int visitSub[];
	int index=0;   //存放下标,已排序序列中找到比它大的最小值的下标
	public void scan(int data[],int begin,int direction){
		int temp=0;
		//从小到大排序
		for(int i=0;i<data.length;i++){
			for(int j=i;j<data.length;j++){
				if(data[i]>data[j]){
					temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}

		for(int i=0;i<data.length;i++){
			if(data[i]>begin){   //在已排序序列中找到比它大的最小值的下标
				index=i;
				break;
			}
		}
		//比起始位置小的
		visitSub=new int[index];   //比他小的共同拥有index个
		for(int i=0;i<index;i++){
			visitSub[i]=data[i];
		}
		//比起始位置大的
		visitAdd=new int[data.length-index];   //比他大的共data.length-index个
		for(int i=0;i<visitAdd.length;i++){
			visitAdd[i]=data[i+index];
		}
		//计算平均时间
		int lengthAdd=0;
		int lengthSub=0;
		int length=0;
		for(int i=0;i<visitAdd.length-1;i++){
			lengthAdd+=Math.abs(visitAdd[i]-visitAdd[i+1]);
		}
		for(int i=visitSub.length-1;i>0;i--){
			lengthSub+=Math.abs(visitSub[i]-visitSub[i-1]);
		}
		
		length=lengthAdd+lengthSub+Math.abs(begin-visitAdd[0])+Math.abs(begin-visitSub[visitSub.length-1]);
		
		if(direction==0){   //找小的
			for(int i=visitSub.length-1;i>=0;i--){              
				System.out.print(visitSub[i]+"    ");
			}
			//回转
			for(int i=0;i<visitAdd.length;i++){              
				System.out.print(visitAdd[i]+"    ");
			}
			length+=Math.abs(visitSub[0]-begin);
		}else{        //找大的
			for(int i=0;i<visitAdd.length;i++){              
				System.out.print(visitAdd[i]+"    ");
			}
			//回转
			for(int i=visitSub.length-1;i>=0;i--){              
				System.out.print(visitSub[i]+"    ");
			}
			length+=Math.abs(visitAdd[visitAdd.length-1]-begin);
		}
		
		System.out.println("平均寻道长度为"+length/data.length);
		System.out.println("总寻道长度为"+length);
	}
	public static void main(String[] args) {
		ex5 scan=new ex5();
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入数据个数");
        int num=scanner.nextInt();
        System.out.println("请一次输入数据，空格隔开");
        int data[]=new int[num];
        for(int i=0;i<num;i++){
        	data[i]=scanner.nextInt();
        }
        System.out.println("请输入读写头起始位置");
        int  begin=scanner.nextInt();
        System.out.println("请输入磁头移动方向  0:磁道降低方向   1：磁道添加方向 ");
        int direction=scanner.nextInt();
        
        scan.scan(data, begin, direction);
        
	}
	//98 183 37 122 14 124 65 67
}