package ���л�;


import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) 
    {
        //����Ҫ���л��ļ��϶���
        List<TestObject> list = new ArrayList<TestObject>();
        
        //������
        for (int i = 0; i < 5; i++) 
        {
            TestObject testObject = new TestObject();
            testObject.setName("MJJ-"+i);
            testObject.setAddress("HangZhou");
            list.add(testObject);
        }

        File file = new File("object.adt");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)))
        {
            //��Listת��������
            TestObject[] obj = new TestObject[list.size()];
            
            list.toArray(obj);
            //ִ�����л��洢
            out.writeObject(obj);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}