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
        int t= Integer.parseInt(st.nextToken());
        //long lt=Long.parseLong(st.nextToken());
        int[] a = new int[t+1];
        long[] v = new long[t+1];
        ArrayList<ArrayList<Integer>> vis = new ArrayList<>();
        vis.add(new ArrayList<>());
        for (int i=1; i<=t; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            a[i]=ai;
            v[i] = Long.parseLong(st.nextToken());
        }
        int ii=1;
        boolean[] isp=new boolean[a.length];
        for (int i=1; i<=t; i++) {
            int ai=a[ii];
            if (vis.get(vis.size()-1).contains(ai)) {
                vis.add(new ArrayList<>());
                for (int j=1; j<=t; j++) {
                    if (! isp[j]) {
                        ai=j;
                        break;
                    }
                }
            }
            vis.get(vis.size()-1).add(ai);
            isp[ai]=true;
            ii=ai;
        }
        long[] ans = new long[vis.size()];
        for (int i=0; i<vis.size(); i++) {
            long minv=Long.MAX_VALUE;
            for (int j=0; j<vis.get(i).size(); j++) {
                if (v[vis.get(i).get(j)]<minv) minv = v[vis.get(i).get(j)];
                ans[i] +=v[vis.get(i).get(j)];
            }
            ans[i] -=minv;
        }
        long aa=0;
        for (int i=0; i<ans.length; i++) {
            aa += ans[i];
        }
        pw.println(aa);
        pw.close();
        br.close();    
    }

}
