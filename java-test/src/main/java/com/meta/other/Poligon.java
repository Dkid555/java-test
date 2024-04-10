package com.meta.other;

public class Poligon {
    public static int findS(int n) {
        int triangle_side = n - 1;
        int full_side = triangle_side * 2 + 1;
        int s_triangle = 0;
        while (triangle_side > 0) {
            s_triangle += triangle_side--;
        }
        return full_side * full_side - 4 * (s_triangle);
    }

    public static void main(String[] args) {
        System.out.println(findS(2));
    }
}
