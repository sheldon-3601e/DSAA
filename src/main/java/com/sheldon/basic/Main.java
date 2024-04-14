package com.sheldon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final boolean debug = false;
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0, ans = 0;
    public static int n, m, K, Q, MAXN = (int)1e6+7, INF = 0x3f3f3f3f;

    static List<Edge> G[] = new ArrayList[MAXN];

    static class Edge {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    public static int dfs(int u, int fa) {
        int chls = 0, edchls = 0;
        for (Edge ed : G[u]) {
            int v = ed.v, w = ed.w;
            if(v == fa) continue ;
            edchls = dfs(v, u);
            chls += edchls;
            ans += (w*1l* abs(edchls-(n-edchls)));
        }
        return chls + 1;
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = read_int();
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        for(int i=1; i<=n+1; i++) G[i] = new ArrayList<>();
        for(int i=1; i<n; i++) {
            u = read_int(); v = read_int(); w = read_int();
            G[u].add(new Edge(v, w));
            G[v].add(new Edge(u, w));
        }
        dfs(1, 1);
        cout.printf("%d\n", ans);

    }

    public static String next_str() {
        try {
            tok.nextToken();
            if (tok.ttype == StreamTokenizer.TT_EOF)
                return null;
            else if (tok.ttype == StreamTokenizer.TT_NUMBER) {
                return String.valueOf((int)tok.nval);
            } else if (tok.ttype == StreamTokenizer.TT_WORD) {
                return tok.sval;
            } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int read_int() {
        String tmp_next_str = next_str();
        return null==tmp_next_str ? -1 : Integer.parseInt(tmp_next_str);
    }


    class Pair implements Comparable<Pair>{
        int fst, sec;
        public Pair() { }
        public Pair(int fst, int sec) {
            this.fst = fst;
            this.sec = sec;
        }
        @Override
        public int compareTo(Pair o) {
            return fst - o.fst == 0 ? sec - o.sec : fst - o.fst;
        }
    }
}

