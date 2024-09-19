package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Spider extends Entity implements Enemy {
    public Spider(GamePanel gp){
        super(gp);
        direction = "right";
        speed = 0;
        getImage();
        entityCollision = true;
        damage = 49;
        health = 145;
        defense = 25;
        hitChance = 70;
        avoidChance = 13;
        isBoss = false;
        hasKey = false;
        defSpeed = 0;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/spider.png"));
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
