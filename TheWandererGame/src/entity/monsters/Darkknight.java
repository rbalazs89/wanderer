package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;
public class Darkknight extends Entity implements Enemy {
    int deltax = 300;
    int deltay = 300;
    public Darkknight(GamePanel gp){
        super(gp);
        defSpeed = 1;
        direction = "down";
        speed = 1;
        getImage();
        entityCollision = true;
        defense = 52;
        damage = 105;
        health = 800;
        hitChance = 66;
        avoidChance = 16;
        isBoss = false;
        hasKey = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/darkknight.png"));
            //TODO draw more images for walking animation

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction() {
        actionLockCounter++;
        deltax = Math.abs(gp.hero.x - x);
        deltay = Math.abs(gp.hero.y - y);
        if (Math.sqrt(Math.pow(deltax,2) + Math.pow(deltay,2)) > 200) {
            if (actionLockCounter > 60) {
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

        else {
            speed = 5;
            setAction2();
        }
    }

    public void setAction2() {
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