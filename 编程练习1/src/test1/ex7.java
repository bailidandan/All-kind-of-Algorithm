import java.util.ArrayList;
import java.util.Stack;
 
public class ex7 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=popA.length)return false;
          
          int i=0,j=0;
          Stack st=new Stack();
          st.push(pushA[i++]);
          while(j<popA.length){
              while(popA[j]!=(int)st.peek()){
                  if(i==pushA.length)return false;//记录加入的第几个数
                  st.push(pushA[i++]);
              }
              j++;
              st.pop();
          }
          return true;
      }
}
