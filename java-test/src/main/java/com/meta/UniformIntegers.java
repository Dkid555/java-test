package com.meta;

public class UniformIntegers {
    public int getUniformIntegerCountInInterval2(long A, long B) {
        int ans = 0;
        long start = A;
        if (B < 10) {
            return (int) (B - A + 1);
        }
        while (start <= B) {
            String s = String.valueOf(start);
            int n = s.length() - 1;
            char temp = s.charAt(0);
            int i = 1;
            while (i <= n) {
                if (s.charAt(i) != temp)
                    break;
                if (i == n)
                    ++ans;
                ++i;
            }
            ++start;
        }
        return ans;
    }

    public int getUniformIntegerCountInInterval(long A, long B) {
        long res = 0; // Инициализируем переменную для хранения результата

        if (A == 0) { // Если A равно 0, устанавливаем A равным 1
            A = 1;
        }

        int start, end; // Объявляем переменные для хранения количества цифр в числах A и B

        start = (int) Math.log10(A); // Определяем количество цифр в числе A
        end = (int) Math.log10(B); // Определяем количество цифр в числе B

        int first_A = (int) (A / Math.pow(10, start)); // Получаем первую цифру числа A
        int first_B = (int) (B / Math.pow(10, end)); // Получаем первую цифру числа B

        if (A == B) { // Если A равно B, проверяем, является ли A уникальным числом в интервале
            if (A == getUniform(first_A, (int) start)) { // Если A уникально, возвращаем 1, иначе 0
                return 1;
            } else {
                return 0;
            }
        }

        if (A <= getUniform(first_A, (int) start)) { // Если A не уникальное, увеличиваем результат на 1
            res++;
        }
        if (end > start) { // Если число B имеет больше цифр, чем число A
            res += (9 - first_A); // Увеличиваем результат на количество уникальных чисел, начинающихся с first_A
            res = res + 9L * (end - start - 1); // Увеличиваем результат на количество чисел с уникальными первыми цифрами
            res += (first_B - 1); // Увеличиваем результат на количество уникальных чисел до числа B
        } else { // Если число B имеет такое же количество цифр, как и число A
            res += first_B - first_A - 1; // Увеличиваем результат на количество уникальных чисел между A и B
        }
        if (B >= getUniform(first_B, end)) { // Если число B включает уникальное число, увеличиваем результат на 1
            res++;
        }

        return (int) res; // Возвращаем результат
    }

    long getUniform(int d, int pow) {
        long ud = d; // Инициализируем переменную для хранения уникального числа
        while (pow > 0) { // Повторяем операции, чтобы сформировать уникальное число
            ud *= 10; // Умножаем на 10 для добавления следующей цифры
            ud += d; // Добавляем цифру d
            pow--; // Уменьшаем счетчик цифр
        }
        return ud; // Возвращаем уникальное число
    }
}
//A positive integer is considered uniform if all of its digits are equal. For example,
//222 is uniform, while 223 is not.
//Given two positive integers A and B, determine the number of uniform integers between
//A and B, inclusive.
//Please take care to write a solution which runs within the time limit.