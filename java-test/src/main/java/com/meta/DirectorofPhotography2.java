package com.meta;

public class DirectorofPhotography2 {
    public long getArtisticPhotographCount(int N, String C, int X, int Y) {
// Подсчет количества комбинаций 'P' и 'B' в подстроках, содержащих 'A'
        // Backdrop(задник) и Photographer (фотограф), A (Актер)
        // расположение: ..B..A..P.. либо ..P..A..B.., нам нужно найти все комбинации P и B чтобы растояние от актра до
        // до P и B было от [X, Y] включительно


        // Инициализация массивов для подсчета количества 'P' и 'B' в префиксах строки C
        int[] B = new int[N + 1], P = new int[N + 1];
        long result = 0L; // Переменная для хранения результата

        // Вычисление количества 'P' и 'B' в префиксах строки C
        for (int i = 1; i <= N; ++i) {
            char curr = C.charAt(i - 1); // текущий char (мы сместились на N+1, для меморайзинга)
            P[i] = P[i - 1] + ((curr == 'P') ? 1 : 0); // считаем количетво предыдущих P  для каждой из точек
            B[i] = B[i - 1] + ((curr == 'B') ? 1 : 0); // считаем количетсво предыдущих B для каждой из точек
        }

        // Перебор каждого символа в строке C
        for (int i = 0; i < N; ++i) {
            if (C.charAt(i) == 'A') {
                // Вычисление начального и конечного индексов для подстроки, которую мы рассматриваем
                int right_start = Math.min((i + X), N); // окно вправо, старт
                int right_end = Math.min((i + Y + 1), N); // окно вправо, конец
                int left_start = Math.max((i - X + 1), 0); // окно влево, старт
                int left_end = Math.max((i - Y), 0); // окно влево, конец

                // Подсчет количества комбинаций 'P' и 'B' в подстроках, содержащих 'A'
                // Backdrop(задник) и Photographer (фотограф), A (Актер)
                // расположение: ..B..A..P.. либо ..P..A..B.., нам нужно найти все комбинации P и B чтобы растояние от актра до
                // до P и B было от [X, Y] включительно
                result += (long) (P[right_end] - P[right_start]) * (B[left_start] - B[left_end]); // P - справа, B - слева
                result += (long) (B[right_end] - B[right_start]) * (P[left_start] - P[left_end]); // B - справа, P - слева
            }
        }

        return result; // Возвращаем результат
    }

}
