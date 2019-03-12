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
		return "进程号:" + this.id + ",其访问的磁道号:" + this.CiDaoNum+" 是否已被调度："+this.isVisited;
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
		// 初始化工作
		int originalNum = random.nextInt(4) + 4;
		Count = originalNum;
		for (int i = 1; i <= originalNum; i++) {
			PCB temp = new PCB(i, random.nextInt(200) + 1, false);
			pcbsOut.add(temp);
			pcbsIn.add(temp);
		}
		System.out.println("请求I/O表中已经有以下进程项:");
		Iterator<PCB> iterator = pcbsOut.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		isOutDirection = random.nextInt(200) > 100 ? true : false;
		System.out.println("当前移臂方向为:" + (isOutDirection ? "从内向外" : "从外向内"));
		currentCiDaoNum = random.nextInt(200) + 1;
		System.out.println("当前所访问的磁道为:" + currentCiDaoNum );
 
		System.out.println();
		System.out.println();
 
		boolean isGoOn = true;
		while (isGoOn) {
			System.out.println("请输入一个0~1的随机数，小于等于0.5表示进行磁盘调度,大于0.5表示进行新进程的请求接收:");
			double ran = scanner.nextDouble();
			if (ran <= 0.5)
				CiPanDiaoDu();
			else
				JieShouQingQiu(originalNum + 1);
			System.out.println("----------------------------");
		}
	}
 
	private static void JieShouQingQiu(int id) {
		System.out.println("请输入进程要访问的磁道号(保证磁道号在1~200内且不要与现有进程的磁道号重复)：");
		int Num = scanner.nextInt();
		PCB temp = new PCB(id, Num, false);
		pcbsOut.add(temp);
		pcbsIn.add(temp);
		Count++;
		System.out.println("该进程已被成功添加至请求I/O表!!");
		System.out.println();
		System.out.println();
		System.out.println("目前请求I/O表已经具备以下表项:");
		Iterator<PCB> iterator = pcbsOut.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("此时磁臂方向为：" + (isOutDirection ? "从内向外" : "从外向内") + ".");
		System.out.println("此时磁臂所在磁道的号码为：" + currentCiDaoNum );
		
	}
 
	private static void CiPanDiaoDu() {
		if (Count <= 0) {
			System.out.println("请求I/O表已空，请添加请求后再进行磁盘调度或者退出程序。");
			return;
		}
		System.out.println("开始在" + currentCiDaoNum + "磁道上并" + (isOutDirection ? "从内向外" : "从外向内") + "上查询--");
		Iterator<PCB> iterator = null;
		boolean isFindWithOneDirection = false;
		PCB mindPCB = null;
		if (isOutDirection) {
			iterator = pcbsOut.iterator();
			while (iterator.hasNext()) {
				PCB pcb = iterator.next();
				// 从内向外找,跳过已经找调度过的进程
				if (pcb.isVisited)
					continue;
				// 当磁道号小于磁臂所在的磁道号时，一直向外遍历寻找
				if (pcb.CiDaoNum < currentCiDaoNum) {
					mindPCB = pcb;
					continue;
				}
				// 只要找到一个大于等于磁臂所在的磁道号的进程时，就立马退出
				isFindWithOneDirection = true;
				mindPCB = pcb;
				break;
			}
			if (!isFindWithOneDirection)
				isOutDirection = false;
		} else
		// 磁臂从外向内
		{
			iterator = pcbsIn.iterator();
			while (iterator.hasNext()) {
				PCB pcb = iterator.next();
				// 从内向外找,跳过已经找调度过的进程
				if (pcb.isVisited)
					continue;
				// 当磁道号小于磁臂所在的磁道号时，一直向外遍历寻找
				if (pcb.CiDaoNum > currentCiDaoNum) {
					mindPCB = pcb;
					continue;
				}
				// 只要找到一个大于等于磁臂所在的磁道号的进程时，就立马退出
				isFindWithOneDirection = true;
				mindPCB = pcb;
				break;
			}
			if (!isFindWithOneDirection)
				isOutDirection = true;
 
		}
		// 上述while循环退出时，没找到时pcb为反方向上距离currentCiDaoNum最近的没被访问的进程
		// 找到时pcb为磁臂方向上离currentCiDaoNum最近的没被访问的进程
 
		// 当mindPCB为空时表明所有磁道号均大于磁臂所在的磁道号,这时取pcbsOut第一个元素即可
		if (mindPCB == null) {
			mindPCB = pcbsOut.first();
		}
		if (!isFindWithOneDirection) {
			System.out.println("在当前方向上没有查询到，转变磁臂方向查找," + "找到在" + mindPCB.CiDaoNum + "磁道上且进程编号为" + mindPCB.id + "的进程。");
		} else {
			System.out.println("在当前方向上找到符合要求的进程," + "其所在磁道号为：" + mindPCB.CiDaoNum + ",进程编号为:" + mindPCB.id);
		}
		mindPCB.isVisited=true;
		currentCiDaoNum = mindPCB.CiDaoNum;
		Count--;
		System.out.println("此时磁臂方向为：" + (isOutDirection ? "从内向外" : "从外向内") + ".");
		System.out.println("此时磁臂所在磁道的号码为：" + currentCiDaoNum );
	}
}
