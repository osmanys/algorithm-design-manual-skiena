package main;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class The3nplus1problem {
    private final int LIMIT = 10000000;
    private final int[] c = new int[LIMIT];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a, b, m1, m2, max, v;
        c[1] = 1;
        while (in.peek() != -1) {
            a = in.readInt();
            b = in.readInt();
            m1 = Math.min(a, b);
            m2 = Math.max(a, b);
            max = 0;
            for (int i = m1; i <= m2; i++) {
                v = Calc(i);
                if (v > max)
                    max = v;
            }
            out.printLine(a, b, max);
        }
    }

    private int Calc(int idx) {
        if (idx < LIMIT && c[idx] != 0)
            return c[idx];
        int v;
        if (idx % 2 == 0)
            v = Calc(idx / 2) + 1;
        else
            v = Calc(3 * idx + 1) + 1;
        if (idx < LIMIT)
            c[idx] = v;
        return v;
    }
}
