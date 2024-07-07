package com.javatest.meta;

public class StackStabilization {
    public int getMinimumDeflatedDiscCount(int N, int[] R) {

        int Bottom = R[N - 1]; // нижний диск
        int moves = 0; // количество сдуваний
        for (int i = N - 2; i >= 0; --i) {
            if (R[i] >= Bottom) { // если текущий диск больше либо равен тому на котором он лежит, то у нас нестабильность
                ++moves; // тогда мы прибавляем в сдувания +1
                R[i] = Bottom - 1; // и присваиваем в текущий диск значение предыдущего, которое меньше на 1 (они строго меньше должны быть)
                if (R[i] <= 0) // но у нас не может быть пустого диска, поэтому вернем что невозможно
                    return -1;
            }
            Bottom = R[i]; // смещаем дно в R[i]
        }

        return moves;
    }
}
//There's a stack of N inflatable discs, with the ith disc from the top having an initial radius of Ri inches.
//The stack is considered unstable if it includes at least one disc whose radius is larger than or equal to
// that of the disc directly under it. In other words, for the stack to be stable,
// each disc must have a strictly smaller radius than that of the disc directly under it.
//As long as the stack is unstable, you can repeatedly choose any disc of your choice and deflate
// it down to have a radius of your choice which is strictly smaller than the disc’s prior radius.
// The new radius must be a positive integer number of inches.
//Determine the minimum number of discs which need to be deflated in order to make the stack stable,
// if this is possible at all. If it is impossible to stabilize the stack, return −1 instead.