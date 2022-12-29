package objects;

import Main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyObjects {
    public String pickupMessage[] = new String[5];

    public int pillarcounter;

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;
    GamePanel gp;
    public Rectangle solidArea = new Rectangle(0,0,72,72);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public boolean pickable = true;
    public boolean messageStatus = true;
    public String itemAlreadyOwnedMessage = " ";
    public void draw(Graphics2D g2, GamePanel gp) {
        //this.keyH = keyH;
        this.gp = gp;
        //super(gp);
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
    public void objectAction() throws InterruptedException {
    }
}
