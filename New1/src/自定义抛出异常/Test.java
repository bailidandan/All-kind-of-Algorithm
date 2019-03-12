package 自定义抛出异常;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Test {
	public static String path;
	public static void main(String[] args) throws FileNotFoundException {
		  try {  
	            throw new Exception("for no season");  
	        } catch (Exception e) {  
	            PrintWriter pw = new PrintWriter(new File("D:/TTT/err.txt"));  
	            e.printStackTrace(pw);  
	            pw.flush();  
	            pw.close();  
	        }  
	}
	public void print() {
		path=getClass().getResource("Err.txt").toString();

	}


}
