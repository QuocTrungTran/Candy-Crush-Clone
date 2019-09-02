package Game;

import Game.Renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        renderer = new Renderer("assets/images/football/field.png",8, false);
        position.set(0, 0);
    }

    @Override
    public void run() {
        super.run(); //position.add(velocity.x, velocity.y);
//        if (position.y >= 0) {
//            position.y = 0;
//        }
    }
}
