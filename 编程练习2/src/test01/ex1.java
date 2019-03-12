package test01;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ex1 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	ArrayList<Integer> level=new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
		level.add(scan.nextInt());
	}
	Collections.sort(level);
	int sum=0;
	while(true){
		sum+=3;
		if(sum>n)break;
	}
	System.out.println(sum-n);
}
}
