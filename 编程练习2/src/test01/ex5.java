package test01;

import java.util.Scanner;


public class ex5 {

	int visitAdd[];
	int visitSub[];
	int index=0;   //����±�,�������������ҵ����������Сֵ���±�
	public void scan(int data[],int begin,int direction){
		int temp=0;
		//��С��������
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
			if(data[i]>begin){   //���������������ҵ����������Сֵ���±�
				index=i;
				break;
			}
		}
		//����ʼλ��С��
		visitSub=new int[index];   //����С�Ĺ�ͬӵ��index��
		for(int i=0;i<index;i++){
			visitSub[i]=data[i];
		}
		//����ʼλ�ô��
		visitAdd=new int[data.length-index];   //������Ĺ�data.length-index��
		for(int i=0;i<visitAdd.length;i++){
			visitAdd[i]=data[i+index];
		}
		//����ƽ��ʱ��
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
		
		if(direction==0){   //��С��
			for(int i=visitSub.length-1;i>=0;i--){              
				System.out.print(visitSub[i]+"    ");
			}
			//��ת
			for(int i=0;i<visitAdd.length;i++){              
				System.out.print(visitAdd[i]+"    ");
			}
			length+=Math.abs(visitSub[0]-begin);
		}else{        //�Ҵ��
			for(int i=0;i<visitAdd.length;i++){              
				System.out.print(visitAdd[i]+"    ");
			}
			//��ת
			for(int i=visitSub.length-1;i>=0;i--){              
				System.out.print(visitSub[i]+"    ");
			}
			length+=Math.abs(visitAdd[visitAdd.length-1]-begin);
		}
		
		System.out.println("ƽ��Ѱ������Ϊ"+length/data.length);
		System.out.println("��Ѱ������Ϊ"+length);
	}
	public static void main(String[] args) {
		ex5 scan=new ex5();
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������ݸ���");
        int num=scanner.nextInt();
        System.out.println("��һ���������ݣ��ո����");
        int data[]=new int[num];
        for(int i=0;i<num;i++){
        	data[i]=scanner.nextInt();
        }
        System.out.println("�������дͷ��ʼλ��");
        int  begin=scanner.nextInt();
        System.out.println("�������ͷ�ƶ�����  0:�ŵ����ͷ���   1���ŵ���ӷ��� ");
        int direction=scanner.nextInt();
        
        scan.scan(data, begin, direction);
        
	}
	//98 183 37 122 14 124 65 67
}