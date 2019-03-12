package �������жϻ�;

public class JudgeRing {
	public static boolean judgeRing(List lst){
		Node v2=lst.first;
		Node v1=lst.first;
		boolean judge=false;
		while(v2.next!=null){
			v2=v2.next.next;
			v1=v1.next;
			if(v2.data==v1.data){
				judge=true;
				break;
			}
		}
		return judge;
	} 
	public static int getEntryPoint(List lst){//ǰ�ᣬ�Ѿ�֪�����ǻ���
		Node p=null;
		if((p = lst.first.next)==null){
			System.out.println("����Ϊ��");
			return 0;
		}
		int oldp=0,newp=0,entryPoint=0;
		while(p.next!=null){
			oldp=p.data;
			p=p.next;
			newp=p.data;
			if(oldp<newp){
				entryPoint=newp;
				break;
			}
		}
		return entryPoint;
	}
	
	public static void main(String[] args) {
		List lst1 = new List();
		lst1.insertFirst(1);
		lst1.insertFirst(2);
		lst1.insertFirst(3);
		lst1.insertFirst(4);
		lst1.insertFirst(5);
		lst1.insertFirst(6);
		lst1.insertFirst(7);
		lst1.insertFirst(8);
		lst1.buildRing();
		if(judgeRing(lst1)){
			System.out.println("�л���");
		}else{
			System.out.println("�޻���");
		}
		int point =getEntryPoint(lst1);
		System.out.println(point);
	}

}
