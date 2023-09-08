package com.leet_easy;

public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int A = 0; A < 2; A++)
                for (int L = 0; L < 3; L++) {
                    int val = f[i - 1][A][2]; // ...P
                    if (A > 0) val = (val + f[i - 1][A - 1][2]) % MOD; // ...A
                    if (L > 0) val = (val + f[i - 1][A][L - 1]) % MOD; // ...L
                    f[i][A][L] = val;
                }
        return f[n][1][2];
    }
}
