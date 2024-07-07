package com.javatest.meta;

import java.util.HashMap;
import java.util.Map;

public class RotaryLock2 {
    public long getMinCodeEntryTime_not_WORKING(int N, int M, int[] C) {
        long seconds = 0L;
        int[] starts = {1, 1};

        for (int pick : C) {
            int[] small = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            Map<Integer, Integer> findC = new HashMap<>();
            for (int i = 0; i < 2; ++i) {
                small[i] = Math.min(Math.min(starts[i], N - starts[i]) + Math.min(N - pick, pick), Math.abs(starts[i] - pick));
                findC.put(small[i], i);
            }

            int smallest = Math.min(small[0], small[1]);

            seconds += smallest;

            starts[findC.get(smallest)] = pick;
        }

        return seconds;
    }

    //

    public long getMinCodeEntryTime(int N, int M, int[] C) {
        long[] dp = new long[M]; // Массив для хранения минимальных стоимостей для каждого состояния
        int[] C2 = new int[M + 1]; // Расширенный массив C, включающий начальное состояние 1

        // Расширяем массив C, чтобы включить начальное состояние 1
        // TODO
        // for(int i = 1; i <= M; i++) {
        //    C2[i] = C[i - 1];
        //}
        System.arraycopy(C, 0, C2, 1, M);
        C2[0] = 1;

        // Инициализируем dp[0] расстоянием между 1 и следующим состоянием
        dp[0] = getDist(C2[0], C2[1], N);

        for (int i = 2; i < M + 1; i++) {
            int nextNumber = C2[i];
            long minDist = Long.MAX_VALUE; // Минимальное расстояние для обновления dp[i - 1]

            // Обновляем dp[i - 1] с наименьшей стоимостью, чтобы один замок остался на i-1, а другой достиг i
            for (int j = 0; j <= i - 2; j++) {
                minDist = Math.min(minDist, dp[j] + getDist(C2[j], nextNumber, N));
            }
            dp[i - 1] = minDist;

            // Обновляем каждый dp[j] для j в (0, i - 2), представляющий стоимость для одного замка, чтобы остаться на j, и другого, чтобы достичь i
            for (int j = 0; j <= i - 2; j++) {
                dp[j] = dp[j] + getDist(C2[i - 1], nextNumber, N);
            }
        }

        // ans - минимум всех возможных общих стоимостей
        long ans = dp[0];
        for (int i = 1; i < M; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }

    // Возвращает минимальное расстояние между двумя состояниями i и j, учитывая N как максимальную длину круговой дорожки
    private int getDist(int i, int j, int N) {
        int dist = Math.abs(i - j); // Вычисляем абсолютное расстояние между i и j
        dist = Math.min(dist, N - dist); // Находим минимальное из расстояний между i и j или N - этого расстояния
        return dist; // Возвращаем минимальное расстояние
    }
}
