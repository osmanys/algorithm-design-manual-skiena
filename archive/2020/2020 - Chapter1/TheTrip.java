package main;

import net.egork.generated.collections.comparator.IntComparator;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;
import net.egork.numbers.IntegerUtils;

public class TheTrip {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        while (n != 0) {
            int d[] = new int[n];
            int total = 0;
            for(int i = 0; i < n; i++) {
                d[i] = (int)Math.round(in.readDouble() * 100);
                total += d[i];
            }
            int r = total % n;
            int c = total / n;
            ArrayUtils.sort(d, IntComparator.REVERSE);
            double res = 0;
            for(int i = 0; i < n; i++){
                if(d[i] <= c)
                    break;
                res += d[i] - c;
                if(r > 0){
                    res--;
                    r--;
                }
            }
            out.printFormat("$%.2f\n", res / 100);
            n = in.readInt();
        }
    }
}
