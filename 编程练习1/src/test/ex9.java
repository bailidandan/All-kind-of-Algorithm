package test;

public class ex9 {
	public int i;
	public int way;
	public int target;
	public void jump(int i){
		if(i==target){way++;return;}
		if(i>target)return;
		for (int j = 1; j <=target; j++) {
			jump(i+j);
		}
	}
    public int JumpFloor(int target) {
    	this.target=target;
    	jump(i);
    	return way;
    }
    public static void main(String[] args) {
		ex9 e=new ex9();
		System.out.println(e.JumpFloor(3));
	}

}
