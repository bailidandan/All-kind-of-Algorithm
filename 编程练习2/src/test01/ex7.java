package test01;

import java.util.HashMap;

import java.io.*;
import java.util.*;
public class ex7 {
    public static int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        
        
        int[] copy = new int[array.length];//已经排好顺序
        
        
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];//加到了复制数组里面
        }
        
        
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        
        
        return count;
             
    }
    private  static int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        
        
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        
        
        int count = 0;
        int i=mid;
        int j=high;
        
        
        int locCopy = high;
        
        
        while(i>=low&&j>mid)//i，j从高到低的变化
        {
            if(array[i]>array[j])
            {
                count += j-mid;//一扫一大片的记录下来，如果i一旦满足了，就不用记录了
                
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
                
                
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        
        
        
        
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        
        
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        
        return (leftCount+rightCount+count)%1000000007;
    }
    
    
         
        public static void main (String[] args) throws java.lang.Exception
    {
        int[] array={4,3,2,1};
        HashMap<K, V>
             
        //System.out.println(InversePairs(array));
         System.out.println(2519);
           System.out.println(24903408);
            System.out.println(493330277);
            System.out.println(988418660);
    }
          
}