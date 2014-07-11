import java.util.HashSet;
import java.lang.StringBuilder;
public class LittleElephantAndIntervalsDiv2 {
     
    int M;
    int[] L, R;
    char[] color;
     
    int total;
    HashSet<String> counted;
     
    char[][] list;
     
    void process()
    {
        // simulate using the colors in color[] array:
        char[] seq = new char[M];
        for (int i = 0; i < L.length; i++) {
            for (int j = L[i]-1; j < R[i]; j++) {
                seq[j] = color[i];
            }
        }
        // build color sequence
        StringBuilder sb = new StringBuilder();
        for (char ch: seq) {
            sb.append(ch);
        }
        // If color sequence not in HashSet, increment total.
        String s = sb.toString();
        if (! counted.contains(s)) {
            counted.add(s);
            total++;
        }
    }
     
     
    void backtrack(int p)
    {
        if (p == L.length) {
            // decided all the colors:
            process();
        } else {
            // pick a color for p-th interval: W or B?
            color[p] = 'W';
            backtrack(p+1); // Continue
            color[p] = 'B';
            backtrack(p+1); // Continue
        }
    }
     
    public int getNumber(int M, int[] L, int[] R)
    {
        this.M = M;
        this.L = L;
        this.R = R;
        color = new char[L.length];
        counted = new HashSet<String>();
        backtrack(0);
        return total;
    }
    
    public static void main(String args[]){
    	
    	LittleElephantAndIntervalsDiv2 obj = new LittleElephantAndIntervalsDiv2();
    	System.out.println(obj.getNumber(4, new int[]{1,2,3}, new int[]{1,2,3}));
    }
}