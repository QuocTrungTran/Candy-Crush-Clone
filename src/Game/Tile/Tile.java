package Game.Tile;

import Game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static Game.Settings.TILES_HEIGHT;
import static Game.Settings.TILES_WIDTH;

public class Tile extends GameObject {
    int width, height;
    public int type;
    public boolean isBeingPointed = false;
    public int fallCount, fallCountLimit;
    BufferedImage image;
    int [][] colors = {
            {255,0,0},
            {255,244,0},
            {255,162,241},
            {168,230,254},
            {85,206,91},
            {10,9,2},
    };

    public Tile() {
        this.width = TILES_WIDTH;
        this.height = TILES_HEIGHT;
    }

    public static Tile randomType() {
        Tile tile = new Tile();
        tile.type = tile.random();
        return tile;
    }

    public int random() {
        Random rand = new Random();
        return rand.nextInt(6   );
    }

    int frameCount = 0;
//    @Override
//    public void run() {
//        //super.run();
////        falling animation below ( NOT DONE YET )
//        frameCount ++;
//        if (frameCount > -1) {
//            fallCount++;
//            if (fallCount <= fallCountLimit ) {
//                this.position.add(velocity.x, velocity.y);
//                System.out.println( (this.position.x-2.2) + " position " + (this.position.y-2) );
//                System.out.println("fallCount = " + fallCount + " ,limit = " + fallCountLimit);
//            } else {
//                velocity.x=0;
//                velocity.y=0;
//            }
//            frameCount = 0;
//        }
//    }

    public void tileFall(Graphics g) {
        for (int i = 0; i <= fallCountLimit ; i++) {
            this.position.add(velocity.x, velocity.y);
            GameObject.renderAll(g);
            System.out.println( (this.position.x-2.2) + " position " + (this.position.y-2) );
            System.out.println("fallCount = " + i + " ,limit = " + fallCountLimit);
        }
    }

//    int countRender;
//    @Override
//    public void render(Graphics g) {
//        g.setColor(new Color(colors[this.type][0], colors[this.type][1], colors[this.type][2]));
//        if (this.isBeingPointed) {
//            countRender++;
//            if (countRender % 2 == 0) {
//                g.fillRect((int) (this.position.x *TILES_WIDTH), (int) (this.position.y *TILES_HEIGHT), this.width, this.height );
//            }
//        } else {
//            g.fillRect((int) (this.position.x * TILES_WIDTH), (int) (this.position.y * TILES_HEIGHT), this.width, this.height);
//            //System.out.println(this.position.x*30 + " p*30 " + this.position.y*30);
//        }
//    }
//
    int countRender;
    @Override
    public void render(Graphics g) {
        switch (this.type) {
            case 0 :
                image = SpriteUtils.loadImage("assets/images/football/ball.png");
                break;
            case 1 :
                image = SpriteUtils.loadImage("assets/images/football/flag.png");
                break;
            case 2 :
                image = SpriteUtils.loadImage("assets/images/football/shoe.png");
                break;
            case 3 :
                image = SpriteUtils.loadImage("assets/images/football/goal.png");
                break;
            case 4 :
                image = SpriteUtils.loadImage("assets/images/football/red card.png");
                break;
            case 5 :
                image = SpriteUtils.loadImage("assets/images/football/yellow card.png");
                break;
        }
        //g.setColor(new Color(colors[this.type][0], colors[this.type][1], colors[this.type][2]));
        if (this.isBeingPointed) {
            countRender++;
            if (countRender % 2 == 0) {
                g.drawImage(image, (int) (this.position.x *TILES_WIDTH), (int) (this.position.y *TILES_HEIGHT), null );
            }
        } else {
            g.drawImage(image, (int) (this.position.x *TILES_WIDTH), (int) (this.position.y *TILES_HEIGHT), null );
            //System.out.println(this.position.x*30 + " p*30 " + this.position.y*30);
        }
    }

}
