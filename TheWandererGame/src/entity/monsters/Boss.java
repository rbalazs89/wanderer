package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Boss extends Entity implements Enemy {

    public Boss(GamePanel gp) {
        super(gp);
        defSpeed = 2;
        direction = "left";
        speed = 2;
        getImage();
        entityCollision = false; // make it false to allow easy retreat
        damage = 150;
        health = 6300;
        defense = 0;
        avoidChance = -100;
        hitChance = 200;
        isBoss = true;
        hasKey = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/boss.png"));
            //TODO draw more images for walking animation
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionLockCounter++;

        if(actionLockCounter > 432) {
            direction = "right";
            if (actionLockCounter > 864 ) {
                actionLockCounter = 0;
            }
        }
        else{
            direction = "left";
        }
    }
}
