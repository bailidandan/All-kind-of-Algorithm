package test;

public class ex3 {
	public static void main(String[] args) {
		LinkNode lk1=new LinkNode(1);
		LinkNode lk2=new LinkNode(2);
		LinkNode lk3=new LinkNode(3);
		
		lk1.next=lk2;
		lk2.next=lk3;
		lk3.next=lk1;
		
		LinkNode fatherMark=lk1;
		LinkNode mark=fatherMark.next;
		
		reverseRing(mark,mark,mark.next);
		mark.next=fatherMark;//最后修正一下
		
		fatherMark=findFatherP(mark);//修成此时mark的父亲结点
		
		//打印信息
		print(mark);
		System.out.println(fatherMark.value);
	}

	private static void print(LinkNode lk1) {
		LinkNode p=lk1;
		while(p.next!=lk1){
			System.out.println(p.value);
			p=p.next;
		}
	}

	public static LinkNode findFatherP(LinkNode mark){
		LinkNode p=mark;
		while(true){
			if(p.next==mark)
			return p;
			p=p.next;
		}
	}
	
	public static void reverseRing(LinkNode mark,LinkNode fatherP,LinkNode p) {
		if(p!=mark){
			reverseRing(mark, p, p.next);
			p.next=fatherP;
		}
		
	}



}
