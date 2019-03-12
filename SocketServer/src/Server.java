import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    /**
     * Socket�����
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            System.out.println("��������������ȴ��ͻ�������..");
            Socket socket=serverSocket.accept();//���������ܵ����׽��ֵ�����,����һ��Socket����
            
            
            //��������������Ϳͻ�������
            InputStream inputStream=socket.getInputStream();//�õ�һ�������������տͻ��˴��ݵ���Ϣ
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");//���Ч�ʣ����Լ��ֽ���תΪ�ַ���
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//���뻺����
            String temp=null;
            String info="";
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("�ѽ��յ��ͻ�������");
                System.out.println("����˽��յ��ͻ�����Ϣ��"+info+",��ǰ�ͻ���ipΪ��"+socket.getInetAddress().getHostAddress());
            }
            
           
            
            OutputStream outputStream=socket.getOutputStream();//��ȡһ��������������˷�����Ϣ
            PrintWriter printWriter=new PrintWriter(outputStream);//���������װ�ɴ�ӡ��
            printWriter.print("��ã�������ѽ��յ�������Ϣ");
            printWriter.flush();
            socket.shutdownOutput();//�ر������
            
            
            
            //�ر����Ӧ����Դ
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}