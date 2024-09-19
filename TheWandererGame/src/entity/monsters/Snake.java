package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Snake extends Entity implements Enemy {
    public Snake(GamePanel gp){
        super(gp);
        direction = "left";
        speed = 1;
        getImage();
        entityCollision = true;
        isBoss = false;
        hasKey = false;
        defSpeed = 1;
        damage = 42;
        health = 160;
        defense = 15;
        hitChance = 80;
        avoidChance = 3;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/snake.png"));
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
