import java.util.*;
import java.io.*;

public class Question{

    static void allC(int[] c, int[] a, int[] b, boolean isAB, double[] ans){
        if (isAB){
            ans[0] = calcprob (b, c);
            ans[1] = calcprob (c, a);
        } else {
            ans[0] = calcprob (a, c);
            ans[1] = calcprob (c, b);
        }
    }

    static double calcprob(int[] x, int[] y){
        double ans=0;
        int tieCount = 0;
        for (int i = 0; i < 4; i++){
            for (int q = 0; q < 4; q++){

                if (x[i] > y[q]){
                    ans++;
                } else if (x[i] == y[q]){
                    tieCount++;
                }
            }
        }
        return ans /(16 - tieCount);
    }
    public static void main (String [] args) throws IOException{
        InputStreamReader r = new InputStreamReader(System.in);
        //FileReader r = new FileReader("2.in");
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        //PrintWriter pw = new PrintWriter("my2.out");
        ArrayList<String> ans2 = new ArrayList<>();
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] a = new int[4];
            int[] b = new int[4];
            for (int j = 0; j < 4; j++){
                a[j] = Integer.parseInt(st2.nextToken());
            } 
            for (int j = 0; j < 4; j++){
                b[j] = Integer.parseInt(st2.nextToken());
            } 
            double ab = calcprob(a, b);
            boolean isAB; 
            int [] c = new int[4];
            double [] ans = new double [2];
            boolean isFound = false;
            if (ab == 0.5){
                ans2.add("no");
            } else if (ab > 0.5) {
                isAB = true;
                for (int i1 = 1; i1 <= 10; i1++){
                    c[0] = i1;  
                    for (int i2 = 1; i2 <= 10; i2++){
                        c[1] = i2;
                        for (int i3 = 1; i3 <= 10; i3++) {
                            c[2] = i3;
                            for (int i4 = 1; i4 <= 10; i4++){
                                c[3] = i4;
                                allC(c, a, b, isAB, ans);
                                if (ans[0] > 0.5 && ans[1] > 0.5){
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound) break;
                        }
                        if (isFound) break;
                    }
                    if (isFound) break;
                }
                if (!isFound){
                    ans2.add("no");
                } else {
                    ans2.add("yes");
                }
            } else {
                isAB = false;
                for (int i1 = 1; i1 <= 10; i1++){
                    c[0] = i1;  
                    for (int i2 = 1; i2 <= 10 ; i2++){
                        c[1] = i2;
                        for (int i3 = 1; i3 <= 10; i3++) {
                            c[2] = i3;
                            for (int i4 = 1; i4 <= 10; i4++){
                                c[3] = i4;
                                allC(c, a, b, isAB, ans);
                                if (ans[0] > 0.5 && ans[1] > 0.5){
                                    isFound = true;
                                    break;
                                }
                            }
                            if (isFound) break;
                        }
                        if (isFound) break;
                    }
                    if (isFound) break;
                }
                if (!isFound){
                    ans2.add("no");
                } else {
                    ans2.add("yes");
                }
            }
        }
        for (int f = 0; f < T; f++){
            pw.println(ans2.get(f));
        }
        pw.close();
        br.close();
    }
}