package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int defSpeed;
    public int damage = 10;
    public int health = 10;
    public int defense = 10;
    public int avoidChance;
    public int hitChance;
    //public int level = 1;
    public boolean hasKey = false;
    public GamePanel gp;
    public int x, y;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    //public BufferedImage image;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(12,12 , 48,48);
    public int solidAreaDefaultWidth = 36;
    public int solidAreaDefaultHeight = 36;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    // collisionOn checks if entity can move in the certain direction in one moment when the game is running
    // not related to entity starting attribute
    public boolean collisionOn = false;

    //counter for AI movement
    public int actionLockCounter;

    //attribute if the entity has collision or can walk thru
    public boolean entityCollision;
    public boolean isBoss = false;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public String dialogues[] = new String[20];
    public int currentDialogueIndex = 0;
    public int entityIndex;
    public void setAction() {
    }
    public void update() throws InterruptedException {
        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkHero(this);

        if(collisionOn == false)

            switch ( direction) {
                case "up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right":
                    x += speed;
                    break;
            }
        spriteCounter ++;
        if(spriteCounter > 12) {
            if(spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum ==2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction) {
            case "up":
                image = up1;
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                image = down1;
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                image = left1;
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                image = right1;
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
    public void speak() {

    }
}
