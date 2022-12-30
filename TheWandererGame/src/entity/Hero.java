package entity;

import Main.GamePanel;
import Main.KeyHandler;
import entity.monsters.Zombie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Hero extends Entity {
    //GamePanel gp;
    public KeyHandler keyH;
    public boolean hasKey;
    public boolean hasArmor;
    public boolean hasBoots;
    public int maxHealth;
    public int attack;
    public int currentEnemyIndex;
    public int currentObjectIndex;
    public int level;
    public boolean hasSword = false;
    public int gracePeriod = 120;
    public int gracePeriodCounter = 0;
    public int interactionCounter = 0;
    public boolean interactCD = false;
    public boolean isCurrentlyGraced = false;

    public Hero(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        level = 1;
        health = 100;
        maxHealth = 100;
        defense = 5;
        attack = 10;
        entityCollision = false;
        hasArmor = false;
        hitChance = attack;
        avoidChance = calcAvoidChance(defense);
        hitChance = calcHitChance(attack);

        solidArea = new Rectangle(0,0,gp.tileSize, gp.tileSize);
        solidArea.x = 10;
        solidArea.y = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 48;
        solidArea.height = 48;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 0;
        y = 0;
        speed = 2;
        direction = "down";
    }

    public void update() throws InterruptedException {
        if(gp.gameState == gp.fightState){
            gp.ui.statusToDraw = "fightstate " + currentEnemyIndex;
        }
        else{
            gp.ui.statusToDraw = "playstate " + currentEnemyIndex;
        }

        if (health > maxHealth){ // not supposed to happen but you never know
            health = maxHealth;
        }

        if (health <=0){
            gp.ui.gameIsFinished = true;
        }

        int entityIndex = gp.cChecker.checkEntity(this, gp.monsterOrNPC);
        currentEnemyIndex = entityIndex;
        interactEntity(entityIndex);

        int objIndex = gp.cChecker.checkObject(this, true);
        currentObjectIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        if (isCurrentlyGraced){
            gracePeriodCounter++;
            if (gracePeriodCounter > gracePeriod){
                isCurrentlyGraced = false;
                gracePeriodCounter = 0;
            }
        }

        if (interactCD){
            interactionCounter++;
            if (interactionCounter > 30){
                interactCD = false;
                interactionCounter = 0;
            }
        }

        if(keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed) {

            if (keyH.upPressed) {
                direction = "up";

            } else if (keyH.downPressed) {
                direction = "down";

            } else if (keyH.rightPressed) {
                direction = "right";

            } else if (keyH.leftPressed) {
                direction = "left";
            }

            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //check entity collision but not interact
            entityIndex = gp.cChecker.checkEntity(this, gp.monsterOrNPC);
            currentEnemyIndex = entityIndex;
            //interactEntity(entityIndex); handle it instead if no key is pressed too

            //in case object collision true:
            //only door object has collision
            //interaction is already handled outside keyevents. This is only for interactable AND not walkable door.
            objIndex = gp.cChecker.checkObject(this, true);
            currentObjectIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //if collision is false, player can move
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
        // Last level event trigger have to be called here, multiple object interaction is used at the same time.
        if (gp.currentMap ==12) {
            gp.aSetter.SpecialTriggers();
        }
    }

    public void getPlayerImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-up1.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-up2.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-down1.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-down2.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-right1.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-right2.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-left1.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/hero/hero-left2.png"));
            //TODO draw more images for walking animation

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void punch(Entity opponent){
        int enemyHitChance = Math.min(Math.max((opponent.hitChance-avoidChance),5),95);
        int myHitChance = Math.min(Math.max((hitChance-opponent.avoidChance),5),95);
        System.out.println("EnemyChance: " + enemyHitChance + "MyChance: " +myHitChance);

        //ENEMY PUNCH TO HERO
        if (Math.min(Math.max((opponent.hitChance-avoidChance),5),95) >= (int)(Math.random() * 100 + 1)) {
            if (hasArmor) {
                health = health - Math.max((int)(0.8*(opponent.damage - defense)), 1);
                System.out.println("Enemy hit you for "+ Math.max((int)(0.8*(opponent.damage - defense)), 1) + " damage.");
            } else {
                health = health - Math.max((opponent.damage - defense), 1);
                System.out.println("Enemy hit you for "+ Math.max((opponent.damage - defense), 1) + " damage.");
            }
        }
        else{
            System.out.println("Enemy missed his attack.");
        }
        //MY PUNCH TO ENEMY
        if (Math.min(Math.max((hitChance-opponent.avoidChance),5),95) >= (int)(Math.random() * 100 + 1)) {
            if (hasSword) {
                opponent.health = opponent.health - Math.max(2 * (attack - opponent.defense), 1);
                System.out.println("You hit enemy for " + Math.max(2 * (attack - opponent.defense), 1) + " damage.");
            } else {
                opponent.health = opponent.health - Math.max((attack - opponent.defense), 1);
                System.out.println("You hit enemy for " + Math.max((attack - opponent.defense), 1) + " damage.");
            }
        }
        else{
            System.out.println("You missed your attack.");
        }

        //SOUND
        int temprand = (int)(Math.random()*5) + 7; // 7...11 are punch audio
        gp.playSE(temprand);
    }

    public void fight(Entity opponent){
        if(opponent.health > 0) {
            this.punch(opponent);
            System.out.println("opponenthealth:" + opponent.health + " myhealth:" + health);
            System.out.println(level);
            System.out.println();
        }

        if(opponent.health <= 0){
            if(gp.monsterOrNPC[currentEnemyIndex].hasKey && hasKey == false) {
                hasKey = true;
                levelUp();
                gp.ui.showMessage(keyDropMessage());
                if(opponent.isBoss){
                    levelUp();
                    levelUp();
                }
                gp.monsterOrNPC[currentEnemyIndex] = null;
                gp.gameState = gp.playState;
            }
            else {
                gp.aSetter.nextMapTriggers(); //spawns door if map entity 15 is killed
                if(opponent.isBoss){
                    levelUp();
                    levelUp();
                }
                gp.monsterOrNPC[currentEnemyIndex] = null;
                gp.gameState = gp.playState;
                if (!(opponent instanceof Zombie)) {
                    levelUp();
                }
            }
        }
    }
    public void retreat(Entity opponent) {
        health = health - (int)(opponent.damage * 1.2 - defense);
        gp.gameState = gp.playState;
        isCurrentlyGraced = true;
        System.out.println("You retreated from the fight.");
        gp.playSE(13);
    }

    public void retreat2() {
        gp.gameState = gp.playState;
        isCurrentlyGraced = true;
        gp.playSE(13);
    }
    public void pickUpObject(int i) throws InterruptedException {
        if (i != 999 && gp.obj[i].pickable) {
            gp.obj[i].objectAction();
        }
    }

    public void interactEntity(int i) {
        if (i !=999) {
            if (gp.monsterOrNPC[i] instanceof Enemy && isCurrentlyGraced == false){
                gp.gameState = gp.fightState;
            }
            else if (keyH.enterPressed && interactCD == false && gp.monsterOrNPC[i] instanceof NPC_Gandalf){
                gp.monsterOrNPC[i].speak();
                interactCD = true;
                gp.monsterOrNPC[i].speed = 0;
            }
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

    public void levelUp() {
        if(level == 1){
            this.attack = 12;
            this.defense = 7;
            this.maxHealth = 104;
            level ++;
        }
        if(level%2 == 0 ){
            maxHealth += 5;
            attack += 2;
            defense += 2;
            hitChance = calcHitChance(attack);
            avoidChance = calcAvoidChance(defense);
            level ++;
        }
        else{
            maxHealth += 5;
            attack += 1;
            defense += 1;
            hitChance = calcHitChance(attack);
            avoidChance = calcAvoidChance(defense);
            level ++;
        }
    }

    public void setupHero() {
        attack = 10;
        defense = 5;
        maxHealth = 100;
        health = 100;
    }

    private int calcAvoidChance(int defense) {
        return (int)(Math.pow(defense + 1, 0.25) * myLog(defense + 1, 1.4));
    }

    private int calcHitChance(int attack) {
        return (70 + (int)(Math.pow(attack + 1, 0.2) * myLog(attack + 1, 1.3)));
    }

    private static double myLog(double number, double base){
        return (Math.log(number) / Math.log(base));
    }

    public String keyDropMessage(){
        String[] pickupMessageLocal = new String[5];
        int temprand = (int)Math.random() * 5;
        pickupMessageLocal[0] = "You discovered a key. May it\ncome useful in your travels.\n";
        pickupMessageLocal[1] = "You have found a key. You are\n eager to find what it opens.\n";
        pickupMessageLocal[2] = "You came upon a key. Its\nshiny glow is mesmerizing.\n";
        pickupMessageLocal[3] = "You came across a key. You\ncan't help but wonder what\nit opens.\n";
        pickupMessageLocal[4] = "You picked up a key. It might\nlead to the next level.\n";
        return pickupMessageLocal[temprand];
    }
}
