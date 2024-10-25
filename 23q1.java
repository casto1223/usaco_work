import java.util.*;
import java.io.*;

public class Question{
    public static void main (String [] args) throws IOException{
        InputStreamReader r = new InputStreamReader(System.in);
        //FileReader r = new FileReader ("testcase.txt");
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        //PrintWriter pw = new PrintWriter(new FileWriter("testcase.out"));
        int t= 1;
        //long lt=Long.parseLong(st.nextToken());
        for (int i=1; i<=t; i++) {
            int ans = 0;
            int N = Integer.parseInt(st.nextToken());
            int[] cur = new int[N];
            int[] goal = new int[N];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int q = 0; q< N; q++){
                cur[q] = Integer.parseInt(st2.nextToken());
            }
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int h = 0; h < N; h++){
                goal[h] = Integer.parseInt(st3.nextToken());
            }
            int[] trans = new int[N+1];
            for (int j=0; j<N; j++) {
                trans[goal[j]]=j+1;
            }
            for (int h = 0; h < N; h++){
                cur[h] = trans[cur[h]];
            }
            int max=0;
            for (int h = 0; h < N; h++){
                if (cur[h]>max) {
                    max=cur[h];
                    continue;
                }
                if (cur[h]<max) {
                    ans++;
                }
            }
            pw.println(ans);
        }
        pw.close();
        br.close();    
    }
}