package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Ninja extends Entity implements Enemy {
    int deltax = 0;
    int deltay = 0;
    public Ninja(GamePanel gp) {
        super(gp);
        defSpeed = 5;
        direction = "left";
        speed = 5;
        getNinjaImage();
        entityCollision = false; // make it false to allow easy retreat
        damage = 69;
        health = 220;
        defense = 25;
        isBoss = true;
        hasKey = true;
        avoidChance = 0;
        hitChance = 150;
    }

    public void getNinjaImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/ninja.png"));
            //TODO draw more images for walking animation
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionLockCounter++;
        if((int)(Math.random()*5) == 0 && actionLockCounter > 12){
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
        else {
            if (actionLockCounter > 12) {
                deltax = Math.abs(gp.hero.x - x);
                deltay = Math.abs(gp.hero.y - y);
                if (deltax >= deltay) {
                    if (gp.hero.x > x) {
                        direction = "right";
                    } else {
                        direction = "left";
                    }
                } else {
                    if (gp.hero.y > y) {
                        direction = "down";
                    } else {
                        direction = "up";
                    }
                }
                actionLockCounter = 0;
            }
        }
    }
}


