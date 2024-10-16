import java.util.*;
import java.io.*;

public class Question{
    int[] inp;
    long ans;
    ArrayList<int[]> step;
    public static void main (String [] args) throws IOException{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(st.nextToken()); 
        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] inp = new int[N];
            for (int q = 0; q < N; q++){
                inp[q] = Integer.parseInt(st.nextToken());
            }
            Question q = new Question(inp);
            if (q.qMain()) {
                pw.println((q.ans)*2);
            } else {
                pw.println(-1);
            }
        }
        br.close();
        pw.close();
    }
    Question(int[] inp) {
        this.inp=inp;
        this.step = new ArrayList<>();
    }
    boolean qMain() {
        if (inp[0] > inp[1]) return false;
        if (inp[inp.length-1] > inp[inp.length-2]) return false;
        for (int i = 1; i < inp.length; i++){
            if (inp[i-1] > inp[i]) {
                int d = inp[i-1] - inp[i];
                int[] x = new int[inp.length];
                x[i-2]=d;
                x[i-1]=d;
                ans+=d;
                step.add(x);
            } else if (inp[i-1] < inp[i]) {
                int d = inp[i] - inp[i - 1];
                int[] x = new int[inp.length];
                x[i]=d;
                x[i+1]=d;
                ans+= d;
                step.add(x);
            } else {

            }
        }
        for (int f = 0; f < step.size(); f++){
            for (int g = 0; g < inp.length; g++){
                inp[g] -= step.get(f)[g];
            }
        }
        int a=inp[0];
        if (a < 0) return false;
        for (int h = 1; h < inp.length; h++){
            if (inp[h] != a){
                return false;
            }
        }
        return true;
    }

}