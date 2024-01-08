package dev.entities;

public class Map {
    // 0 - rock
    // 1 - path
    // 2 - tree
    // 3 - grass
    
    public static int[][] map_1 = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 3, 0, 3, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 3, 3, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 0, 3, 3, 1, 1, 1, 1, 2, 0, 1},
            {1, 3, 3, 0, 0, 0, 3, 3, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 3, 0, 2, 0, 1},
            {1, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 5, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 5, 0, 1},
            {1, 3, 0, 0, 3, 3, 3, 3, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 1},
            {1, 3, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {1, 0, 0, 26, 27, 28, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 2, 1},
            {1, 21,22, 23, 24, 25, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 5, 0, 0, 0, 2, 1},
            {1, 16,17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1},
            {1, 11,12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1},
            {1, 6, 7, 8, 9, 10, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
    };
    public static int[][] map_2 = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 3, 0, 3, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 3, 3, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 0, 3, 3, 1, 1, 1, 1, 2, 0, 1},
            {1, 3, 3, 0, 0, 0, 3, 3, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 3, 0, 2, 0, 1},
            {1, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 5, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 5, 0, 1},
            {1, 3, 0, 0, 3, 3, 3, 3, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 1},
            {1, 3, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {1, 0, 0, 26, 27, 28, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 2, 1},
            {1, 21,22, 23, 24, 25, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 5, 0, 0, 0, 2, 1},
            {1, 16,17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1},
            {1, 11,12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

    };


}
