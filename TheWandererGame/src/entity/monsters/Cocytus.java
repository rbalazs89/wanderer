package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Cocytus extends Entity implements Enemy {

    public Cocytus(GamePanel gp){
        super(gp);
        defSpeed = 0;
        direction = "left";
        speed = 0;
        getImage();
        entityCollision = true;
        defense = 85;
        damage = 110;
        health = 500;
        hitChance = 100;
        avoidChance = 10;
        isBoss = true;
        hasKey = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/cocytus.png"));
            //TODO draw more images for walking animation

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction() {
        actionLockCounter++;
        if(actionLockCounter == 60) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "right";
            }
            if (i > 25 && i <= 50) {
                direction = "left";
            }
            if (i > 50 && i <= 75) {
                direction = "up";
            }
            if (i > 75 && i <= 100) {
                direction = "down";
            }
            actionLockCounter = 0;
        }
    }
}