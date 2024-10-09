import java.io.*;
import java.util.*;

public class chunkSearch {
    public static void main(String[] args) throws IOException {
        
        //BufferedReader br = new BufferedReader (new FileReader ("vector.in"));
        //InputStreamReader r = new InputStreamReader(System.in);
        //StringTokenizer st = new StringTokenizer (br.readLine());
        //int n = Integer.parseInt(st.nextToken());
        //st = new StringTokenizer (br.readLine());

        int[] que = {0,-1,-2,3,4,-1,-3,5};
        int[] ans = chunkS(que);
        System.out.println(Arrays.toString(ans));
    }

    static int[] chunkS(int[] que) {
        int i=0;
        while (i<que.length) {
            if (que[i] !=0) break;
            i++;            
        }
        int[] ans = new int[2];
        if (i== que.length) return ans; // if ans[1] is zedro, then no chunk
        ans[0]=i;
        boolean isPos = que[i] >0;
        int len=1;
        while (i+len < que.length) {
            if (isPos) {
                if (que[i+len]<=0) break;
                len++;
            } else {
                if (que[i+len]>=0) break;
                len++;
            }
        }
        ans[1]=len;
        return ans;
    }
}