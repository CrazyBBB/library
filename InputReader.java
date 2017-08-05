package crazybbb;

import java.io.*;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class InputReader {
    public String nextString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), " ");
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        return tok.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public long nextLong() {
        return Long.parseLong(nextString());
    }

    public double nextDouble() {
        return Double.parseDouble(nextString());
    }

    public String[] nextStringArray(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextString();
        }
        return res;
    }

    public int[] nextIntArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    public int[] nextIntArray0indexed(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt() - 1;
        }
        return res;
    }

    public long[] nextLongArray(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    public long[] nextLongArray0indexed(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextLong() - 1;
        }
        return res;
    }

    BufferedReader in;
    StringTokenizer tok;

    public InputReader(InputStream inputStream) {
        in = new BufferedReader(new InputStreamReader(inputStream));
        tok = new StringTokenizer("");
    }
}
