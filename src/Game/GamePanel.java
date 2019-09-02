package Game;
import Game.Map.Map;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Game.Map.Map.tiles;
import static Game.Program.clickFirst;
import static Game.Settings.score;


public class GamePanel extends JPanel {
    // duong dan tuyet doi: /Users/ngando1720/Documents/Java OOP/ci-begin-master/assets/images/players/straight/0.png
    // duong dan tuong doi: assets/images/players/straight/0.png

    public Background background;
    public Map map = new Map();
    public double fps;
    BufferedImage logoImage;
    BufferedImage scoreImage;
    BufferedImage edgeImage;
    BufferedImage cover;
    BufferedImage cover2;

    public GamePanel() {
        background = new Background();

//        Enemy enemy = new Enemy()
        map.createMap();
        DetectMatch.firstDetect();

        while (DetectMatch.isAnyMatch) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    tiles[i][j].deactive();
                }
            }
            map.createMap();
            DetectMatch.firstDetect();
        }


//        DetectMatch.detect();
    }
    static Font fontStart = new Font("Verdana", Font.BOLD, 20);
    /**
     * auto been called by program
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (clickFirst <1) {
            background.render(g);
            logoImage = SpriteUtils.loadImage("assets/images/football/logo.png");
            g.drawImage(logoImage, 150, 200, null);
            cover = SpriteUtils.loadImage("assets/images/football/cover.png");
            g.drawImage(cover,450, 300, null  );
            cover2 = SpriteUtils.loadImage("assets/images/football/cover2.png");
            g.drawImage(cover2,30, 300, null  );
            g.setFont(fontStart);
            g.setColor(Color.white);
            g.drawString( " Click anywhere to start !!! ", 305, 860);

        } else {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

//        background.render(g);
//        player.render(g);
            System.out.println("painting ");
            GameObject.renderAll(g);
            this.drawMenu(g);
        }
    }

    static Font font = new Font("Verdana", Font.BOLD, 46);
    private void drawMenu(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.fillRect(Settings.BACKGROUND_WIDTH,0,Settings.GAME_WIDTH - Settings.BACKGROUND_WIDTH, Settings.GAME_HEIGHT);
        g.setColor(Color.RED);
        g.drawString(fps + " ",750, 50);
        logoImage = SpriteUtils.loadImage("assets/images/football/logo.png");
        g.drawImage(logoImage, 150, 10, null);
        scoreImage = SpriteUtils.loadImage("assets/images/football/score.png");
        g.drawImage(scoreImage, 220, 765, null );
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString(Settings.score + " ", 445, 840);
        edgeImage = SpriteUtils.loadImage("assets/images/football/edge.png");
        g.drawImage(edgeImage, 115, 145, null );
    }

    int frameCount=0;
    public void runAll() {
        // not necessary to make all objects run
        GameObject.runAll();
    }

    public void gameLoop() {
        //long ~ big int
        long lastTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= 1000 / 60) {
                fps = 1000/ (currentTime - lastTime);
                //paint
                this.repaint();
                //runt all logic  ()
                this.runAll();
//                System.out.println(currentTime - lastTime);
                lastTime = currentTime;
            }

        }
    }
}

