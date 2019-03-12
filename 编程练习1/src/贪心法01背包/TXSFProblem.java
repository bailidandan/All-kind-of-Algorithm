package ̰�ķ�01����;

import java.util.Arrays;
import java.util.Collections;

public class TXSFProblem {
    // ���е���Ʒ
    private Knapsack[] bags;
    // �������ܳ���
    private int totalWeight;
    // ��������ܼ�ֵ
    private int bestValue;

    public TXSFProblem(Knapsack[] bags, int totalWeight) {
        this.bags = bags;
        this.totalWeight = totalWeight;
        // �Ա�������λ������ֵ�Ӵ�С����
        
        Arrays.sort(bags, Collections.reverseOrder());
        
    }

    
    public void solve() {
        int tempWeight = totalWeight;//ʣ��ı�������

        for (int i = 0; i < bags.length; i++) {
            //�жϵ�ǰ��Ʒ�Ƿ���Է��뱳���У������������ѭ����������һ����Ʒ
            if (tempWeight - bags[i].getWeight() < 0)
                continue;

            tempWeight -= bags[i].getWeight();
            bestValue += bags[i].getValue();
        }
    }

    
    public int getBestValue() {
        return bestValue;
    }
    
    //test
    public static void main(String[] args) {

        Knapsack[] bags = new Knapsack[] { new Knapsack(2, 13),
                new Knapsack(1, 10), new Knapsack(3, 24), new Knapsack(2, 15),
                new Knapsack(4, 28), new Knapsack(5, 33), new Knapsack(3, 20),
                new Knapsack(1, 8) };
        
        int totalWeight = 12;

        TXSFProblem problem = new TXSFProblem(bags, totalWeight);
        problem.solve();

        System.out.println("bags����������");
        for (int i = 0; i < bags.length; i++) {
			System.out.print(bags[i].getUnitValue()+" ");
		}
        System.out.println();
        System.out.println(problem.getBestValue());
    }
}