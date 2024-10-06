import java.io.*;
import java.util.*;

public class npowerm {

   public static void main(String[] args) {
      int n = 3;
      int m = 2;
      ArrayList<Integer> nm = new ArrayList<Integer>();
      for (int i = 0; i < m; i++){
         nm.add(0);   
      }
      boolean isEnd = false;
      while (!isEnd){
      
         // do the task with n^m here below:
         System.out.println (nm.toString());
         // do the task with n^m here above
         
         nm.set(0, nm.get(0) + 1);
         for (int i = 0; i < m; i++){
            if (nm.get(i) == n){
               if (i == m - 1){
                  isEnd = true;
               } else {
                  nm.set(i, 0);
                  nm.set(i + 1, nm.get(i + 1) + 1);
               }
            } else {
               break;
            } 
         }
      }
      
   }
}