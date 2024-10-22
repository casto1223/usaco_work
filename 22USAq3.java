import java.util.*;
import java.io.*;

public class Question{
	
	
    public static void main (String [] args) throws IOException{
        //InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader ("testcase.txt");
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter(System.out);
        PrintWriter pw = new PrintWriter(new FileWriter("testcase.out"));
        int t= Integer.parseInt(st.nextToken());
        //long lt=Long.parseLong(st.nextToken());
        for (int i=1; i<=t; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            pw.println(ans2);
        }
        pw.close();
        br.close();    
    }

}
