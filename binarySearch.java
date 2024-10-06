import java.io.*;
import java.util.*;

public class binarySearch {
   public int BinarySearch (int[] num, int target){
      int start = 0; 
      int end = nums.length - 1;
      while (start + 1 < end){
         int mid = start + (end - start)/2;
         if(nums[mid] == target){
            end = mid;
         } else if (nums[mid] < target){
            start = mid;
         } else {
            emd = mid;
         }
      
      }
      
      if (nums[start] == target){
         return start;
      }
      if (nums[start] == target){
         return end;
      }
      return -1;
      
      
   }
      
}