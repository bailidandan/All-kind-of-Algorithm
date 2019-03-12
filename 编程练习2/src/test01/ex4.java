package test01;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
 
class PCB {
	public int id;
	public int CiDaoNum;
	public boolean isVisited;
 
	@Override
	public String toString() {
		return "���̺�:" + this.id + ",����ʵĴŵ���:" + this.CiDaoNum+" �Ƿ��ѱ����ȣ�"+this.isVisited;
	}
 
	public PCB(int id, int ciDaoNum, boolean isVisited) {
		super();
		this.id = id;
		CiDaoNum = ciDaoNum;
		this.isVisited = isVisited;
	}
}
 
public class ex4 {
	public static Scanner scanner = new Scanner(System.in);
	public static TreeSet<PCB> pcbsOut = new TreeSet<PCB>(new Comparator<PCB>() {
		public int compare(PCB p1, PCB p2) {
			if (p1.CiDaoNum >= p2.CiDaoNum)
				return 1;
			return -1;
		}
 
	});
	public static TreeSet<PCB> pcbsIn = new TreeSet<PCB>(new Comparator<PCB>() {
		public int compare(PCB p1, PCB p2) {
			if (p1.CiDaoNum >= p2.CiDaoNum)
				return -1;
			return 1;
		}
 
	});
	public static Random random = new Random();
	public static boolean isOutDirection;
	public static int currentCiDaoNum;
	public static int Count;
 
	public static void main(String[] args) {
		// ��ʼ������
		int originalNum = random.nextInt(4) + 4;
		Count = originalNum;
		for (int i = 1; i <= originalNum; i++) {
			PCB temp = new PCB(i, random.nextInt(200) + 1, false);
			pcbsOut.add(temp);
			pcbsIn.add(temp);
		}
		System.out.println("����I/O�����Ѿ������½�����:");
		Iterator<PCB> iterator = pcbsOut.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		isOutDirection = random.nextInt(200) > 100 ? true : false;
		System.out.println("��ǰ�Ʊ۷���Ϊ:" + (isOutDirection ? "��������" : "��������"));
		currentCiDaoNum = random.nextInt(200) + 1;
		System.out.println("��ǰ�����ʵĴŵ�Ϊ:" + currentCiDaoNum );
 
		System.out.println();
		System.out.println();
 
		boolean isGoOn = true;
		while (isGoOn) {
			System.out.println("������һ��0~1���������С�ڵ���0.5��ʾ���д��̵���,����0.5��ʾ�����½��̵��������:");
			double ran = scanner.nextDouble();
			if (ran <= 0.5)
				CiPanDiaoDu();
			else
				JieShouQingQiu(originalNum + 1);
			System.out.println("----------------------------");
		}
	}
 
	private static void JieShouQingQiu(int id) {
		System.out.println("���������Ҫ���ʵĴŵ���(��֤�ŵ�����1~200���Ҳ�Ҫ�����н��̵Ĵŵ����ظ�)��");
		int Num = scanner.nextInt();
		PCB temp = new PCB(id, Num, false);
		pcbsOut.add(temp);
		pcbsIn.add(temp);
		Count++;
		System.out.println("�ý����ѱ��ɹ����������I/O��!!");
		System.out.println();
		System.out.println();
		System.out.println("Ŀǰ����I/O���Ѿ��߱����±���:");
		Iterator<PCB> iterator = pcbsOut.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("��ʱ�ű۷���Ϊ��" + (isOutDirection ? "��������" : "��������") + ".");
		System.out.println("��ʱ�ű����ڴŵ��ĺ���Ϊ��" + currentCiDaoNum );
		
	}
 
	private static void CiPanDiaoDu() {
		if (Count <= 0) {
			System.out.println("����I/O���ѿգ������������ٽ��д��̵��Ȼ����˳�����");
			return;
		}
		System.out.println("��ʼ��" + currentCiDaoNum + "�ŵ��ϲ�" + (isOutDirection ? "��������" : "��������") + "�ϲ�ѯ--");
		Iterator<PCB> iterator = null;
		boolean isFindWithOneDirection = false;
		PCB mindPCB = null;
		if (isOutDirection) {
			iterator = pcbsOut.iterator();
			while (iterator.hasNext()) {
				PCB pcb = iterator.next();
				// ����������,�����Ѿ��ҵ��ȹ��Ľ���
				if (pcb.isVisited)
					continue;
				// ���ŵ���С�ڴű����ڵĴŵ���ʱ��һֱ�������Ѱ��
				if (pcb.CiDaoNum < currentCiDaoNum) {
					mindPCB = pcb;
					continue;
				}
				// ֻҪ�ҵ�һ�����ڵ��ڴű����ڵĴŵ��ŵĽ���ʱ���������˳�
				isFindWithOneDirection = true;
				mindPCB = pcb;
				break;
			}
			if (!isFindWithOneDirection)
				isOutDirection = false;
		} else
		// �ű۴�������
		{
			iterator = pcbsIn.iterator();
			while (iterator.hasNext()) {
				PCB pcb = iterator.next();
				// ����������,�����Ѿ��ҵ��ȹ��Ľ���
				if (pcb.isVisited)
					continue;
				// ���ŵ���С�ڴű����ڵĴŵ���ʱ��һֱ�������Ѱ��
				if (pcb.CiDaoNum > currentCiDaoNum) {
					mindPCB = pcb;
					continue;
				}
				// ֻҪ�ҵ�һ�����ڵ��ڴű����ڵĴŵ��ŵĽ���ʱ���������˳�
				isFindWithOneDirection = true;
				mindPCB = pcb;
				break;
			}
			if (!isFindWithOneDirection)
				isOutDirection = true;
 
		}
		// ����whileѭ���˳�ʱ��û�ҵ�ʱpcbΪ�������Ͼ���currentCiDaoNum�����û�����ʵĽ���
		// �ҵ�ʱpcbΪ�ű۷�������currentCiDaoNum�����û�����ʵĽ���
 
		// ��mindPCBΪ��ʱ�������дŵ��ž����ڴű����ڵĴŵ���,��ʱȡpcbsOut��һ��Ԫ�ؼ���
		if (mindPCB == null) {
			mindPCB = pcbsOut.first();
		}
		if (!isFindWithOneDirection) {
			System.out.println("�ڵ�ǰ������û�в�ѯ����ת��ű۷������," + "�ҵ���" + mindPCB.CiDaoNum + "�ŵ����ҽ��̱��Ϊ" + mindPCB.id + "�Ľ��̡�");
		} else {
			System.out.println("�ڵ�ǰ�������ҵ�����Ҫ��Ľ���," + "�����ڴŵ���Ϊ��" + mindPCB.CiDaoNum + ",���̱��Ϊ:" + mindPCB.id);
		}
		mindPCB.isVisited=true;
		currentCiDaoNum = mindPCB.CiDaoNum;
		Count--;
		System.out.println("��ʱ�ű۷���Ϊ��" + (isOutDirection ? "��������" : "��������") + ".");
		System.out.println("��ʱ�ű����ڴŵ��ĺ���Ϊ��" + currentCiDaoNum );
	}
}
