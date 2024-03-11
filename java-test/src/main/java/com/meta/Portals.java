package com.meta;

import java.util.*;

public class Portals {
    public int getSecondsRequired(int R, int C, char[][] G) {
        int count = 0; // Счетчик секунд, необходимых для достижения цели
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Массив смещений для движения в четырех направлениях: вниз, вверх, вправо, влево
        boolean[][] visited = new boolean[G.length][G[0].length]; // Массив для отметки посещенных клеток
        Queue<Integer> queue_of_cells = new LinkedList<>(); // Очередь для обхода клеток

        Map<Character, List<Integer>> map = new HashMap<>(); // Карта для хранения координат всех букв
        for (int row = 0; row < G.length; row++) {
            for (int column = 0; column < G[0].length; column++) {
                if (G[row][column] >= 'a' && G[row][column] <= 'z') { // Если текущая клетка содержит букву
                    map.putIfAbsent(G[row][column], new LinkedList<>()); // Если ключа нет, создаем новый список для координат
                    map.get(G[row][column]).add(row * 100 + column); // Добавляем координаты текущей клетки в список для данной буквы
                }

                if (G[row][column] == 'S') { // Если текущая клетка - начальная позиция 'S'
                    visited[row][column] = true; // Отмечаем начальную клетку как посещенную
                    queue_of_cells.offer(row * 100 + column); // Добавляем начальную клетку в очередь для обхода
                }
            }
        }

        while (!queue_of_cells.isEmpty()) { // Пока очередь не пуста
            count++; // Увеличиваем счетчик секунд

            int size = queue_of_cells.size(); // Получаем текущий размер очереди
            for (int x = 0; x < size; x++) { // Обходим все клетки в текущем слое (временно добавленные в очередь на предыдущем шаге)
                int num = queue_of_cells.poll(); // Извлекаем координаты клетки из очереди
                int i = num / 100; // Получаем координату по вертикали
                int j = num % 100; // Получаем координату по горизонтали

                for (int k = 0; k < 4; k++) { // Перебираем все четыре направления движения
                    int a = i + directions[k][0]; // Вычисляем новую координату по вертикали
                    int b = j + directions[k][1]; // Вычисляем новую координату по горизонтали

                    if (a >= 0 && a < G.length && b >= 0 && b < G[0].length && !visited[a][b]) { // Проверяем, что новая клетка внутри границ лабиринта и не посещена ранее
                        if (G[a][b] == 'E')
                            return count; // Если новая клетка - целевая 'E', возвращаем текущее значение счетчика секунд
                        visited[a][b] = true; // Отмечаем новую клетку как посещенную
                        if (G[a][b] == '.')
                            queue_of_cells.offer(a * 100 + b); // Если новая клетка - проходимая, добавляем ее в очередь для обхода
                        else if (G[a][b] == '#')
                            continue; // Если новая клетка - стена, пропускаем эту клетку
                        else if (G[a][b] >= 'a' && G[a][b] <= 'z')
                            queue_of_cells.offer(a * 100 + b); // Если новая клетка - буква, добавляем ее в очередь для обхода
                    }
                }

                if (G[i][j] >= 'a' && G[i][j] <= 'z') { // Если текущая клетка содержит букву
                    List<Integer> list = map.get(G[i][j]); // Получаем список координат для данной буквы
                    for (int nn : list) { // Перебираем все координаты
                        if (nn != num && !visited[nn / 100][nn % 100]) { // Если координата не совпадает с текущей и не была посещена ранее
                            visited[nn / 100][nn % 100] = true; // Отмечаем клетку с новыми координатами как посещенную
                            queue_of_cells.offer(nn); // Добавляем клетку с новыми координатами в очередь для обхода
                        }
                    }
                }
            }
        }

        return -1; // В случае невозможности достижения цели возвращаем -1
    }
}
//You've found yourself in a grid of cells with R rows and C columns. The cell in the i-th row from the top and
//j-th column from the left contains one of the following (indicated by the character, G-i,j):
//If, G-i,j = ".", the cell is empty.
//If, G-i,j  = "S", the cell contains your starting position. There is exactly one such cell.
//If, G-i,j = "E", the cell contains an exit. There is at least one such cell.
//If, G-i,j = "#", the cell contains a wall.
//Otherwise, if, G-i,j is a lowercase letter (between "a" and "z", inclusive), the cell contains a portal marked with that letter.

//Your objective is to reach any exit from your starting position as quickly as possible.
// Each second, you may take either of the following actions:
//Walk to a cell adjacent to your current one (directly above, below, to the left, or to the right),
// as long as you remain within the grid and that cell does not contain a wall.
//If your current cell contains a portal, teleport to any other cell in the grid containing a portal
// marked with the same letter as your current cell's portal.
//Determine the minimum number of seconds required to reach any exit, if it's possible to do so at all.
// If it's not possible, return −1 instead.