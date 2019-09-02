package Game;

import static Game.Map.Map.tiles;
import static Game.Program.panel;

public class DetectMatch {
    static int currentMatch;
    static boolean isAnyMatch;


    public static void firstDetect() {   // phan vertical va horizontal giong nhau hoan toan, chi doi cho "i" va "j"
        isAnyMatch = false;

        // detect based on column ( vertical)
        for (int i = 0; i < 8; i++) {
            currentMatch = 0;
            for (int j = 0; j < 8; j++) {
                if (j < 7) {
                    if (tiles[i][j].type == tiles[i][j + 1].type) {
                        currentMatch++;
                    } else {
                        if (currentMatch >= 2) {
                            isAnyMatch = true;
                        }
                        currentMatch = 0;
                    }
                } else {
                    if (currentMatch >= 2) {
                        isAnyMatch = true;
                    }
                }
            }
        }
        // detect based on row ( horizontal)
        for (int j = 0; j < 8; j++) {
            currentMatch = 0;
            for (int i = 0; i < 8; i++) {
                if (i < 7) {
                    if (tiles[i][j].type == tiles[i + 1][j].type) {
                        currentMatch++;
                    } else {
                        if (currentMatch >= 2) {
                            isAnyMatch = true;
                        }
                        currentMatch = 0;
                    }
                } else {
                    if (currentMatch >= 2) {
                        isAnyMatch = true;
                    }
                    currentMatch = 0;
                }
            }
        }
//        for (int j = 0; j < 8; j++) {
//            for (int i = 0; i < 8; i++) {
//                System.out.print(tiles[i][j].type+" ");
//            }
//            System.out.println("");
//        }
    }

    public static void detect() {   // phan vertical va horizontal giong nhau hoan toan, chi doi cho "i" va "j"
        isAnyMatch = false;
        // detect based on column ( vertical)
        for (int i = 0; i < 8; i++) {
            currentMatch = 0;
            for (int j = 0; j < 8; j++) {
                if (j < 7) {
                    if (tiles[i][j].type == tiles[i][j + 1].type) {
                        currentMatch++;
                    } else {
                        if (currentMatch >= 2) {
                            System.out.println(i + " doc " + j + ", length =" + (currentMatch + 1));
                            FallDown fall = new FallDown(i, j, currentMatch, true);
                            isAnyMatch = true;
                            fall.run();
                        }
                        currentMatch = 0;
                    }
                } else {
                    if (currentMatch >= 2) {
                        System.out.println(i + " doc " + j + ", length =" + (currentMatch + 1));
                        FallDown fall = new FallDown(i, j, currentMatch, true);
                        isAnyMatch = true;
                        fall.run();
                    }
                }
            }
        }
        // detect based on row ( horizontal)
        for (int j = 0; j < 8; j++) {
            currentMatch = 0;
            for (int i = 0; i < 8; i++) {
                if (i < 7) {
                    if (tiles[i][j].type == tiles[i + 1][j].type) {
                        currentMatch++;
                    } else {
                        if (currentMatch >= 2) {
                            System.out.println(i + " ngang " + j + ", length =" + (currentMatch + 1));
                            FallDown fall = new FallDown(i, j, currentMatch, false);
                            isAnyMatch = true;
                            fall.run();
                        }
                        currentMatch = 0;
                    }
                } else {
                    if (currentMatch >= 2) {
                        System.out.println(i + " ngang " + j + ", length =" + (currentMatch + 1));
                        FallDown fall = new FallDown(i, j, currentMatch, false);
                        isAnyMatch = true;
                        fall.run();
                    }
                    currentMatch = 0;
                }
            }
        }
//        for (int j = 0; j < 8; j++) {
//            for (int i = 0; i < 8; i++) {
//                System.out.print(tiles[i][j].type+" ");
//            }
//            System.out.println("");
//        }
    }

//    public static void main(String[] args) {
//        Map map = new Map();
//        map.createMap();
//        detect();
//    }
}
