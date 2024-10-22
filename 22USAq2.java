import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question{
	
    public static void main (String [] args) throws IOException{
        InputStreamReader r = new InputStreamReader(System.in);
        //FileReader r = new FileReader ("testcase.txt");
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        //PrintWriter pw = new PrintWriter(new FileWriter("testcase.out"));
        //long lt=Long.parseLong(st.nextToken());
        String s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            String pa="[abcdefghijklmnopqr]+";
            for (int j=0; j<q.length(); j++) {
                pa=pa.replace(q.charAt(j)+"", "");
            }
            String ns = s.replaceAll(pa, "");
            String nt = t.replaceAll(pa, "");
            if (ns.equals(nt)){
                pw.print("Y");
            } else {
                pw.print("N");
            }
        }
        pw.println("");
        pw.close();
        br.close();    
    }

}
