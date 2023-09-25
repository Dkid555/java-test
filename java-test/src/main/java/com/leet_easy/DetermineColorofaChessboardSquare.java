package com.leet_easy;

public class DetermineColorofaChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        char[] coord = coordinates.toCharArray();
        return ((coord[0] - 'a' + 1) % 2 != 1 || (coord[1] - '1' + 1) % 2 != 1) && ((coord[0] - 'a' + 1) % 2 != 0 || (coord[1] - '1' + 1) % 2 != 0);
    }
}
