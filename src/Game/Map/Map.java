package Game.Map;

import Game.GameObject;
import Game.KeyEventPress;
import Game.Tile.Tile;

import static Game.Settings.TILES_HEIGHT;
import static Game.Settings.TILES_WIDTH;

public class Map extends GameObject {
    int width, height;
    public static Tile tiles[][] = new Tile[9][9];

    public Map() {
        this.width = TILES_WIDTH * 8;
        this.height = TILES_HEIGHT * 8;
    }

    @Override
    public void run() {
//        super.run();
    }

    public void createMap() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = Tile.randomType();
                tiles[i][j].position.set(2.2+i, 2.5+j);
                tiles[i][j].reset();
            }
        }
    }

//    public Tile firstClickedTile() {
//        if (clickedX / 30 < 8 && clickedY / 30 < 8) { // kiem tra xem vi tri click chuot co nam trong map ko ?
//            return tiles[clickedX / 30][clickedY / 30];
//        } else return null;
//    }
//
//    public Tile secondClickedTile() {
//        int secondX = clickedX / 30;
//        int secondY = clickedY / 30;
//
//        if ((Math.abs(secondX + secondY - t1.position.x - t1.position.y) == 1)) {
//            if (secondX == t1.position.x || secondY == t1.position.y) { // kiem tra xem tile nay co nam canh voi firstClickedTile ko ?
//                return tiles[secondX][secondY];
//            } else return null;
//        } else return null;
//    }
//
//    public void swap(Tile t1, Tile t2) {
//        int tmp;
//        tmp = t1.type;
//        t1.type = t2.type;
//        t2.type = tmp;
//    }

}
