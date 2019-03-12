package 序列化;


import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) 
    {
        //创建要序列化的集合对象
        List<TestObject> list = new ArrayList<TestObject>();
        
        //加数据
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
            //将List转换成数组
            TestObject[] obj = new TestObject[list.size()];
            
            list.toArray(obj);
            //执行序列化存储
            out.writeObject(obj);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}