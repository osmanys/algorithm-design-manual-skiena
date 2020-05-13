package main;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class AustralianVoting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int imax, max, min, c, zeros, n, tc = in.readInt();
        int[] d, idata;
        ArrayList<Integer> minList;
        ArrayList<Integer>[] ballots;
        String line;
        String[] names;
        ArrayList<int[]> data;
        while (tc > 0) {
            n = in.readInt();
            imax = -1;
            names = new String[n];
            for (int i = 0; i < n; i++)
                names[i] = in.readLine();
            data = new ArrayList<>();
            while (in.peek() != 10 && in.peek() != -1)
                data.add(in.readIntArray(n));
            ballots = new ArrayList[n];
            for (int i = 0; i < n; i++)
                ballots[i] = new ArrayList<>();
            idata = new int[data.size()];
            for(int i = 0; i < data.size(); i++)
                ballots[data.get(i)[0] - 1].add(i);
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
            while (imax == -1 && zeros + minList.size() < n) {
                for (int del : minList) {
                    for (Integer b : ballots[del]) {
                        for(int i = idata[b] + 1; i < n; i++) {
                            c = data.get(b)[i] - 1;
                            if(ballots[c].size() > 0) {
                                ballots[c].add(b);
                                idata[b] = i;
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
                    if(ballots[i].size() > data.size() / 2) {
                        imax = i;
                        break;
                    }
                }
            }
            if(imax == -1) {
                for (int i = 0; i < n; i++) {
                    if (ballots[i].size() > 0)
                        out.printLine(names[i]);
                }
            }
            else
                out.printLine(names[imax]);
            tc--;
            if(tc > 0)
                out.printLine();
        }
    }
}
