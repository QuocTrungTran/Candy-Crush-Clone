package Game;

import Game.Tile.Tile;

import java.awt.*;

import static Game.Map.Map.tiles;
import static Game.Program.clickCount;
import static Game.Program.panel;

public class SelectAndSwap {
    int x,y;
    static int firstX, firstY, secondX, secondY;
    static int clickedCount;
    public SelectAndSwap (int x, int y, int clickedCount) {
        this.x=x;
        this.y=y;
        this.clickedCount = clickedCount;
    }

    public void collectClickedValue() {

        if ( x>=0 && x<8 && y>=0 && y<8) {
            if (clickedCount % 2 == 1) {
                firstX = x;
                firstY = y;
                tiles[x][y].isBeingPointed = true; // isBeingPointed = true <=> flashing ( nhap nhay)
            } else {
                secondX = x;
                secondY = y;
                if (((Math.abs(secondX + secondY - firstX - firstY) == 1) && (secondX == firstX || secondY == firstY))) {// check if 2 tiles selected are adjacent or not
                    swap(tiles[firstX][firstY], tiles[secondX][secondY]); // swap two selected tiles
                    panel.repaint();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {}
                    DetectMatch.detect();
                    // check if there is any match
                    if (!DetectMatch.isAnyMatch) {
                        //if not any match => swap back
                        swap(tiles[firstX][firstY], tiles[secondX][secondY]);
                    }
                }
                tiles[firstX][firstY].isBeingPointed = false;
                while (DetectMatch.isAnyMatch) {
                    DetectMatch.detect();
                }
//                System.out.println("Cac vi tri swap: " + firstX + " " + firstY + " " + secondX + " " + secondY);
            }
        } else {
            clickCount =0;
            tiles[firstX][firstY].isBeingPointed = false;
        }
    }

    public void swap(Tile t1, Tile t2) {
        int tmp;
        tmp = t1.type;
        t1.type = t2.type;
        t2.type = tmp;
    }
}
