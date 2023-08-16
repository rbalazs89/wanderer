package Main;

import entity.Entity;
import entity.Hero;
import objects.MyObjects;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 72;
    public final int tileSize = originalTileSize;
    public final int maxScreenCol = 12;
    public final int maxScreenRow = 10;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    //public static final int maxNumberOfMaps = 13;
    public int currentMap = 1;
    private int localcounter = 0;
    // maps setting
    //FPS
    int FPS = 60;
    //SYSTEM LOGIC
    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Hero hero = new Hero(this, keyH);
    public infoPanel ui = new infoPanel(this);
    public InfoPanel2 ui2 = new InfoPanel2(this);

    Thread gameThread;
    public boolean musicOn = true;

    //ENTITY AND OBJECT PICKUPS
    //Hero hero1 = new Hero(this, keyH);
    public MyObjects obj[] = new MyObjects[31];
    public Entity monsterOrNPC[] = new Entity[16];
    //public Entity
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int fightState = 3;

    //public final int dialogueState = 4;

    public final int deadState = 5;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth + ui.widthSize, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        currentMap = 1;
    }

    public void nextLevel() {
        hero.health = hero.maxHealth;
        hero.hasKey = false;
        hero.x = 0;
        hero.y = 0;
        currentMap ++;
        tileM.loadMap("/maps/map"+ Integer.toString(currentMap) +".txt"); //Don't remove Integer.toString.
        aSetter.setObject(currentMap);
        aSetter.setEntities(currentMap);
        gameState = playState;
        if (musicOn){
            stopMusic();
            playMusic(currentMap);
        }
        calculateEntityIndex();
        mapStartMessage();
        if (currentMap == 4){
            hero.speed -= 1;
        }

        hero.savedHeroLevel = hero.level;
        hero.savedMaxHealth = hero.maxHealth;
        hero.savedDefense = hero.defense;
        hero.savedAttack = hero.attack;
        hero.savedHitChance = hero.hitChance;
        hero.savedAvoidChance = hero.avoidChance;
        hero.savedHasArmor = hero.hasArmor;
        hero.savedHasBoots = hero.hasBoots;
        hero.savedHasSword = hero.hasSword;
        hero.savedHeroSpeed = hero.speed;
    }

    public void restartLevel(){
        hero.level = hero.savedHeroLevel;
        hero.maxHealth = hero.savedMaxHealth;
        hero.health = hero.maxHealth;
        hero.defense = hero.savedDefense;
        hero.attack = hero.savedAttack;
        hero.avoidChance = hero.calcAvoidChance(hero.defense);
        hero.hitChance = hero.calcHitChance(hero.attack);
        hero.hasKey = false;
        hero.hasBoots = hero.savedHasBoots;
        hero.hasArmor = hero.savedHasArmor;
        hero.hasSword = hero.savedHasSword;
        hero.speed = hero.savedHeroSpeed;

        hero.x = 0;
        hero.y = 0;
        tileM.loadMap("/maps/map"+ Integer.toString(currentMap) +".txt"); //Don't remove Integer.toString.
        aSetter.setObject(currentMap);
        aSetter.setEntities(currentMap);
        gameState = playState;
        if (musicOn){
            stopMusic();
            playMusic(currentMap);
        }
        calculateEntityIndex();
        mapStartMessage();
    }

    public void setupGame(int currentMap) {
        aSetter.setObject(currentMap);
        aSetter.setEntities(currentMap);
        gameState = playState;
        if (musicOn){
            playMusic(currentMap); // this is needed at setup because of the load order
            stopMusic();
            playMusic(currentMap);
        }
        calculateEntityIndex();
        hero.setupHero();
    }
    public void startGameThread() {
        gameThread = new Thread( this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                try {
                    update();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println(("FPS:" + drawCount));
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() throws InterruptedException {

        if (gameState == playState){
            hero.update();
            for (int i = 0; i < monsterOrNPC.length; i++) {
                if(monsterOrNPC[i] != null){
                    //monsterOrNPC[i].speed = monsterOrNPC[i].deSpeed;
                    monsterOrNPC[i].update();
                }
            }
        }
        if (gameState == fightState) {
            hero.update();
            /*for (int i = 0; i < monsterOrNPC.length; i++) {
                if(monsterOrNPC[i] != null){
                    monsterOrNPC[i].speed = 0;
                    monsterOrNPC[i].update();
                }
            }*/
        }
        /////////////////////////////////////
        if (ui.countmessage1 > 0){ // to handle more than one incoming messages within 5 seconds, cannot be called locally
            ui.newIncMessage = true;}
        if (ui.newIncMessage){
            localcounter++;
            if (localcounter > 300){
                localcounter = 0;
                ui.newIncMessage = false;}}
        //////////////////////////////////////
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; // Change graphics to Graphics2D
        ui.countmessage1 = 0; // counter to detect more than 1 messages
        long drawStart = 0;
        if(keyH.checkDrawTime){
            drawStart = System.nanoTime();
        }

        tileM.draw(g2);

        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        for (int i = 0; i < monsterOrNPC.length; i++) {
            if( monsterOrNPC[i] != null){
                monsterOrNPC[i].draw(g2);
            }
        }
        hero.draw(g2);

        ui.draw(g2);

        ui2.draw(g2);

        if (keyH.checkDrawTime == true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;

            g2.setColor(Color.WHITE);
            g2.drawString("Draw Time:  " + passed, 10, 400);
            System.out.println(passed);
        }

        //ENDING:
        if(currentMap == 12 && monsterOrNPC[15] == null){
            ui.gameIsCompleted = true;
        }

        g2.dispose();
    }
    public void playMusic(int currentLevel) {
        if (currentLevel == 1 || currentLevel == 2 || currentLevel == 3) {
            music.setFile(0);
        }
        else if (currentLevel == 4 || currentLevel == 5 || currentLevel == 6)
            music.setFile(4);
        else if (currentLevel == 7 || currentLevel == 8 || currentLevel == 9)
            music.setFile(5);
        else if (currentLevel == 10 || currentLevel == 11 || currentLevel == 12)
            music.setFile(6);
        else if (currentLevel == 13) {
            music.setFile(6);
        }
        music.play();
        music.loop();
    }

    public void mapStartMessage() {
        if (currentMap == 4){
            ui.showMessage("The wet sand hinders your\nmovement.");
        }
        if (currentMap == 12){
            ui.showMessage("Read the tables for guidance.");
        }
    }

    public void stopMusic() {
        if (musicOn){ music.stop();}
    }

    public void playSE (int i) {
        soundEffect.setFile(i);
        soundEffect.play();
    }

    public void calculateEntityIndex() {
        for (int i = 0; i < 16; i++) {
            if(monsterOrNPC[i] != null){
                monsterOrNPC[i].entityIndex = i;
            }
        }
    }
}