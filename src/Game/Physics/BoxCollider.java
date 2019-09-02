package Game.Physics;

import Game.GameObject;
import Game.Vector2D;

import javax.swing.*;

public class BoxCollider {
    public Vector2D position;
    int width;
    int height;

    public BoxCollider(double x, double y, int width, int height) {
        this.position = new Vector2D(x, y);
        this.width = width;
        this.height = height;
    }

    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return position.y;
    }

    public double bot() {
        return this.top() + height;
    }

    public double left() {
        return position.x;
    }

    public double right() {
        return this.left() + width;
    }

    public boolean intersect(BoxCollider other) {
        // 2 rect: this vs other
        return this.right() >= other.left()
                && this.left() <= other.right()
                && this.bot() >= other.top()
                && this.top() <= other.bot();
    }
    public static void main(String[] args) {
        BoxCollider rect1 = new BoxCollider(1,1,1,1);
        BoxCollider rect2 = new BoxCollider(1,1,2,2);
        BoxCollider rect3 = new BoxCollider(4,4,2,2);

        System.out.println(rect1.intersect(rect2)); // true
        System.out.println(rect1.intersect(rect3)); // false
        System.out.println(rect2.intersect(rect3));  // false
    }
}
