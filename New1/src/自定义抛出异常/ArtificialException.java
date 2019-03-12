package 自定义抛出异常;

public class ArtificialException extends Throwable{

	public void printErr(){
		System.out.println("自定义异常类抛出");
	}
}
