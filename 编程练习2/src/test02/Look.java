package test02;

import java.io.InputStream;
import java.net.*;

public class Look implements Runnable{
	URL url;
	public void setURL(URL url){
		this.url=url;
	}
	public void run() {
		try {
			InputStream in=url.openStream();
			byte []b=new byte[1024];
			int n=-1;
			while((n=in.read(b))!=-1){
				String str=new String(b,0,n);
				System.out.println("already reach here");
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
