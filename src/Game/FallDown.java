package Game;
import Game.Tile.Tile;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.awt.*;

import static Game.Map.Map.tiles;
import static Game.Program.panel;
import static Game.Settings.*;

public class FallDown {
    int x, y, length;
    boolean isOnColumn; // for distinguishing matches on column and row ( vertical and horizontal) because each type has its own method
    Clip matchSound;
    Clip matchSound2;
    GoalBanter goalBanter = new GoalBanter();

    public FallDown(int x, int y, int currentMatch, boolean isOnColumn) {
        this.x = x;
        this.y = y;
        this.length = currentMatch + 1;
        this.isOnColumn = isOnColumn;
        score += this.length;
        matchSound = AudioUtils.loadSound("assets/music/sfx/Goal Sound.wav");
        matchSound2 = AudioUtils.loadSound("assets/music/sfx/Goal Sound 2.wav");
        goalBanter.position.set(this.x * TILES_WIDTH,this.y * TILES_HEIGHT);
    }

    int frameCount = 0;

    public void run() {
        this.deactiveTiles();
     //   this.fallingAnimation();
        this.swapTiles();

    }

    public void deactiveTiles() {
        // deactivate matched tiles
        //deactivate on column
        if (isOnColumn) {
            AudioUtils.replay(matchSound);
            for (int j = 0; j < length; j++) {
                tiles[x][y - j].deactive();
                //System.out.println("deactive");
            }
        } else { // deactivate on row
            AudioUtils.replay(matchSound2);
//            for (int i = x - length+1; i <= x; i++) {
//                tiles[i][y].deactive();
//            }
        }
    }

    public void fallingAnimation() { // NOT DONE YET !
        // falling on column ( vertical)
        if (isOnColumn) {
            for (int j = 0; j <= y - length; j++) {
                tiles[x][j].fallCount = 0;
                tiles[x][j].fallCountLimit = length ;
                tiles[x][j].velocity.set(0, 1.0 / 10.0); // make each tile fall
                // tiles[x][j].type= tiles[x][j+length].type;
                System.out.println("animation");
            }
            for (int k = 0; k < length ; k++) {
                for (int j = 0; j <= y - length; j++) {
                    tiles[x][j].position.add(tiles[x][j].velocity.x, tiles[x][j].velocity.y);
             //       panel.repaint();
                    System.out.println((tiles[x][j].position.x - 2.2) + " position " + (tiles[x][j].position.y - 2));
                    System.out.println("fallCount = " + k + " ,limit = " + length + ", j= " + j);
                }
            }
        }
//        } else { //falling on row (horizontal)
//            for (int i = x - length ; i <= x; i++) {
//                for (int j = 0; j < y; j++) {
//                    tiles[i][j].fallCountLimit = 10;
//                    tiles[x][j].velocity.set(0, 1/10.0);
//                }
//            }
//          }
    }

        public void swapTiles ()
        { // phan method nay minh code hoi kho hieu, minh khong biet comment nhu the nao, mong moi nguoi thong cam :(
            if (isOnColumn) {  // swap based on column (vertical)
                //if (y == 2) return;
                for (int j = y - length; j >= 0; j--) {
                    if (!tiles[x][j + length].active) {
                        this.swap(tiles[x][j], tiles[x][j + length]);
                        //System.out.println("Swapping: " + j + length);
                    }
                }
                for (int j = 0; j < length; j++) {
                    tiles[x][j].type = tiles[x][j].random();
                    tiles[x][j].reset();
                }

            } else { // swap based on row (horizontal)
                for (int i = x - length + 1; i <= x; i++) {
                    for (int j = y - 1; j >= 0; j--) {
                        this.swap(tiles[i][j], tiles[i][j + 1]);
                    }
                }
                for (int i = x - length + 1; i <= x; i++) {
                    tiles[i][0].type = tiles[i][0].random();
                }
            }
        }

        public void swap (Tile t1, Tile t2){
            int tmp;
            tmp = t1.type;
            t1.type = t2.type;
            t2.type = tmp;
            t2.reset();
        }
    }
