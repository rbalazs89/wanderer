package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Scorpion extends Entity implements Enemy {
    public Scorpion(GamePanel gp){
        super(gp);
        defSpeed = 1;
        direction = "down";
        speed = 1;
        getImage();
        entityCollision = true;
        damage = 42;
        health = 150;
        defense = 19;
        hitChance = 50;
        avoidChance = 15;
        isBoss = false;
        hasKey = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/scorpion.png"));
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
