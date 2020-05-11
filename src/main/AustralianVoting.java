package main;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class AustralianVoting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int min, c, zeros, n, tc = in.readInt();
        int[] d;
        ArrayList<Integer> minList;
        ArrayList<Integer>[] ballots;
        String line;
        String[] names;
        ArrayList<int[]> data;
        Scanner sc;
        while (tc > 0) {
            n = in.readInt();
            names = new String[n];
            for (int i = 0; i < n; i++)
                names[i] = in.readLine();
            data = new ArrayList<>();
            while (in.peek() != 10 && in.peek() != -1) {
                line = in.readLine();
                sc = new Scanner(line);
                d = new int[n];
                for (int i = 0; i < n; i++)
                    d[i] = sc.nextInt() - 1;
                data.add(d);
            }
            ballots = new ArrayList[n];
            for (int i = 0; i < n; i++)
                ballots[i] = new ArrayList<>();
            for(int i = 0; i < data.size(); i++)
                ballots[data.get(i)[0]].add(i);
            zeros = 0;
            minList = new ArrayList<>();
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(ballots[i].size() == 0) {
                    zeros++;
                }
                else if(ballots[i].size() < min) {
                    minList = new ArrayList<>();
                    minList.add(i);
                    min = ballots[i].size();
                }
                else if(ballots[i].size() == min)
                    minList.add(i);
            }
            while (zeros + minList.size() < n) {
                for (int del : minList) {
                    for (Integer b : ballots[del]) {
                        for(int i = 0; i < n; i++) {
                            c = data.get(b)[i];
                            if(c != del && ballots[c].size() > 0) {
                                ballots[c].add(b);
                                break;
                            }
                        }
                    }
                    ballots[del] = new ArrayList<>();
                }
                zeros = 0;
                min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if(ballots[i].size() == 0) {
                        zeros++;
                    }
                    else if(ballots[i].size() < min) {
                        minList = new ArrayList<>();
                        minList.add(i);
                        min = ballots[i].size();
                    }
                    else if(ballots[i].size() == min)
                        minList.add(i);
                }
            }
            for (int i = 0; i < n; i++) {
                if(ballots[i].size() > 0)
                    out.printLine(names[i]);
            }
            tc--;
            if(tc > 0)
                out.printLine();
        }
    }
}
