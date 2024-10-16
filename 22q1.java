import java.util.*;
import java.io.*;

public class Question{
    public static void main (String [] args) throws IOException{
    for (int tc=2; tc<=2; tc++) {
        //InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader (tc + ".in");
        BufferedReader br = new BufferedReader(r);
        char[][] answer = new char[3][3]; 
        char[][] guess = new char[3][3];
        int ycount = 0;
        for (int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int q = 0; q < 3; q++){
                answer[i][q] = str.charAt(q);
            }
        }
        for (int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int q = 0; q < 3; q++){
                guess[i][q] = str.charAt(q);
            }
        }

        HashMap<Character, Integer> green = new HashMap<>();
        HashMap<Character, Integer> all = new HashMap<>();

        for (int i = 0; i < 3; i++){
            for (int q = 0; q < 3; q++){
                if (all.containsKey(answer[i][q])){
                    Integer x = all.get(answer[i][q]);
                    x++;
                    all.put(answer[i][q], x);
                } else {
                    all.put(answer[i][q], 1);
                }
                if (guess[i][q] == answer[i][q]){
                    if (green.containsKey(guess[i][q])){
                        Integer x = green.get(guess[i][q]);
                        x++;
                        green.put(guess[i][q], x);
                    } else {
                        green.put(guess[i][q], 1);
                    }
                }
            }
        }
        Set<Character> gc = green.keySet();
        for (Character e : gc) {
            if (all.containsKey(e)){
                Integer x = all.get(e);
                x--;
                if (x == 0){
                    all.remove(e);
                } else {
                    all.put(e,x);
                }
            }
        }
        for (int i = 0; i < 3; i++){
            for (int q = 0; q < 3; q++){
                if (guess[i][q] != answer[i][q] && all.containsKey(guess[i][q])){
                    ycount++;
                    
                    Integer t = all.get(guess[i][q]);
                    t--;
                    if (t == 0){
                        all.remove(guess[i][q]);
                    } else {
                        all.put(guess[i][q],t);
                    }
                    
                }
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter(tc + "my.out"));
        //PrintWriter pw = new PrintWriter(System.out);
        int g=0;
        for (Character c : green.keySet()) {
            g+=green.get(c);
        }
        pw.println(g);
        pw.println(ycount);
        pw.close();
    }
    }
}