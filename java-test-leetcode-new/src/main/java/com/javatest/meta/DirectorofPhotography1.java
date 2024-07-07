package com.javatest.meta;

public class DirectorofPhotography1 {
    public int getArtisticPhotographCount(int N, String C, int X, int Y) {

        // Подсчет количества комбинаций 'P' и 'B' в подстроках, содержащих 'A'
        // Backdrop(задник) и Photographer (фотограф), A (Актер)
        // расположение: ..B..A..P.. либо ..P..A..B.., нам нужно найти все комбинации P и B чтобы растояние от актра до
        // до P и B было от [X, Y] включительно


        // Инициализация массивов для подсчета количества 'P' и 'B' в префиксах строки C
        int[] B = new int[N + 1], P = new int[N + 1];
        int result = 0; // Переменная для хранения результата

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

                // end - start покажет количство P/B между координатами start и end
                result += (P[right_end] - P[right_start]) * (B[left_start] - B[left_end]); // P - справа, B - слева
                result += (B[right_end] - B[right_start]) * (P[left_start] - P[left_end]); // B - справа, P - слева
            }
        }

        return result; // Возвращаем результат
    }
}
//Note: Chapter 2 is a harder version of this puzzle. The only difference is a larger constraint on
//�
//N.
//A photography set consists of
//�
//N cells in a row, numbered from
//1
//1 to
//�
//N in order, and can be represented by a string
//�
//C of length
//�
//N. Each cell
//�
//i is one of the following types (indicated by
//�
//�
//C
//i
//​
// , the
//�
//ith character of
//�
//C):
//If
//�
//�
//C
//i
//​
//  = “P”, it is allowed to contain a photographer
//If
//�
//�
//C
//i
//​
//  = “A”, it is allowed to contain an actor
//If
//�
//�
//C
//i
//​
//  = “B”, it is allowed to contain a backdrop
//If
//�
//�
//C
//i
//​
//  = “.”, it must be left empty
//A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell, and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic if the distance between the photographer and the actor is between
//�
//X and
//�
//Y cells (inclusive), and the distance between the actor and the backdrop is also between
//�
//X and
//�
//Y cells (inclusive). The distance between cells
//�
//i and
//�
//j is
//∣
//�
//−
//�
//∣
//∣i−j∣ (the absolute value of the difference between their indices).
//Determine the number of different artistic photographs which could potentially be taken at the set. Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.