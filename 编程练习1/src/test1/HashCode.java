package test1;
class Person{
	public String name;
	public int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
}
public class HashCode {

	public static void main(String[] args) {
		Person p1=new Person("����", 22);
		Person p2=new Person("����",23);
		
		Object p3=p1;
		Object p4=p2;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}

}
