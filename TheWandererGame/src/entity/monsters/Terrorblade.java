package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Terrorblade extends Entity implements Enemy {
    public Terrorblade(GamePanel gp){
        super(gp);
        defSpeed = 1;
        direction = "left";
        speed = 1;
        getImage();
        entityCollision = true;
        defense = 80;
        damage = 105;
        health = 600;
        hitChance = 75;
        avoidChance = 20;
        isBoss = false;
        hasKey = false;
    }
    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/terrorblade.png"));
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