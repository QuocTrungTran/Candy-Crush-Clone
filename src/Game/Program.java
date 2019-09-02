package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.Map.Map;

import static Game.Map.Map.tiles;
import static Game.Settings.TILES_HEIGHT;
import static Game.Settings.TILES_WIDTH;


public class Program {

    public static double clickedX, clickedY;
    public static int clickCount;
    public static int clickFirst;
    public static GamePanel panel = new GamePanel();

    public static void main(String[] args) {


        System.out.println(System.currentTimeMillis());
        JFrame window = new JFrame();
        window.setTitle("Game Touhou");
//        window.setSize(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        window.setResizable(true);
//        window.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JPanel panel = new JPanel();

        //GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));
        window.add(panel);
        window.pack();
        //panel.setBackground(Color.CYAN);

        // bat su kien phim
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isSelectPress = true;
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isSelectPress = false;
                }
            }
        };

        // clickCount is odd <=> selected the first tile
        // clickCount is even <=> selected the second tile
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clickFirst++;
                clickedX = e.getX() - window.getInsets().left;
                clickedY = e.getY() - window.getInsets().top;
                System.out.println((int) ((clickedX - 2.2) / TILES_WIDTH) + "  " + (int) ((clickedY - 2) / TILES_HEIGHT));
//                System.out.println("clickCount = " + clickCount);
                if (clickFirst > 1 ) {
                    clickCount++;
                    SelectAndSwap s = new SelectAndSwap((int) ((clickedX - 2.2 * TILES_WIDTH) / TILES_WIDTH), (int) ((clickedY - 2.5 * TILES_HEIGHT) / TILES_HEIGHT), clickCount);
                    s.collectClickedValue();
                }
            }
        };
        window.addMouseListener(mouseHandler);
        window.addKeyListener(keyHandler);
        window.setVisible(true);
        // start game
        panel.gameLoop();
    }
}


