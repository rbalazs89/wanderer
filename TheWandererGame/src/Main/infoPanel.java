package Main;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

public class infoPanel {

    GamePanel gp;
    int widthSize = 4 * 72;
    Font arial_40, arial_80B;
    ///////////////////////////////////////////////////
    public String statusToDraw = " ";
    private final int screenTile = 72;
    private final int screenTileXn = 12;
    //private final int screenTileYn = 10;
    private final int width = 4 * screenTile;
    private final int height = 10 * screenTile;
    // declare again to not have conflict with GamePanel
    public BufferedImage images[] = new BufferedImage[15];
    public final int x1 = screenTile * screenTileXn;
    public final int y1 = 0;
    //public final int x2 = x1;
    //private final int y2 = screenTile * 2;
    private final int adjustdown = 30;
    public boolean messageOn = false;
    public String messageToDraw = "";
    int messageCounter = 0;
    int healthBarFancyDisplayCounter = 0;
    public boolean gameIsFinished = false;
    public boolean gameIsCompleted = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    private int savedHealth;
    private int savedHealth2;
    private int savedHealthDelta;
    private boolean healthJustChanged = false;
    private final int healthBarX = 884;
    private final int healthBarY = 30;
    private final int healthBarWidth = 248;
    private final int healthBarHeight = 35;
    private final int healthBarBorder = 4;
    private final int healthBarArc = 5;

    public int countmessage1;
    public boolean newIncMessage = false;

    public infoPanel(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        getImage();
        savedHealth = gp.hero.health;
        savedHealth2 = gp.hero.health;
    }

    public void draw(Graphics2D g2) {

        //countmessage1 = 0;

        if (gameIsFinished) {
            drawEnding(g2);
        }
        if(gameIsCompleted) {
            drawCompleted(g2);
        }
        drawMessageBox(g2);
        drawInventoryAndStats(g2);
        drawMessageInPanel(g2);
        drawControls(g2);
        if (gp.keyH.Tpressed) {
            showTheTime(g2);
            showStatus(g2);
        }
    }

    public void drawControls(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.setFont(g2.getFont().deriveFont(20F));
        int x = 885;
        int y = 470;
        g2.drawImage(images[10], x, y, 40, 40, null);
        g2.drawString( "Ambient music",x + 50, y + 25);
        if (gp.musicOn) {
            g2.drawImage(images[5], x + 200, y, 40, 40, null);
        }
        else if (!gp.musicOn) {
            g2.drawImage(images[6], x + 200, y, 40, 40, null);
        }

        y += 50;
        g2.drawImage(images[9], x, y, 40, 40, null);
        g2.drawString( "Retreat",x + 50, y + 25);

        y += 50;
        g2.drawImage(images[11], x, y, 100, 40, null);
        g2.drawString( "PUNCH",x + 50 + 60, y + 25);

        y += 50;
        g2.drawImage(images[12], x, y, 80, 50, null);
        g2.drawString( "Interact",x + 35 + 60, y + 30);

    }
    public void drawMessageBox(Graphics2D g2){
        g2.setColor(new Color(1,1,1,255));
        int x = 885;
        int y = 230;
        int width = 245;
        int length = 220;
        int arc = 10;
        g2.fillRoundRect(x,y,width,length, arc,arc);

        g2.setStroke(new BasicStroke(2));
        width += 2;
        length += 2;
        x -= 1;
        y -= 1;
        g2.setColor(new Color(234, 221, 202));
        g2.drawRoundRect(x,y,width,length, 15,15);

        g2.setStroke(new BasicStroke(5));
        width -= 6;
        length -= 6;
        x += 3;
        y += 3;
        g2.setColor(Color.gray);
        g2.drawRoundRect(x,y,width,length, arc,arc);
    }

    public void drawEnding (Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setFont(g2.getFont().deriveFont(45F));
        g2.setColor(Color.RED);

        String text;
        int textLength;
        int x, y;
        text = "You have died.";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gp.screenWidth / 2 - textLength/2;
        y = gp.screenHeight / 2 - (gp.tileSize * 3)+60;
        g2.drawString(text, x , y);

        text = "Your deeds of valor will be remembered.";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gp.screenWidth / 2 - textLength/2;
        y += 50;
        g2.drawString(text, x , y);


        g2.setFont(g2.getFont().deriveFont(30F));
        g2.setColor(Color.BLACK);
        text = "press L to restart this level";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gp.screenWidth / 2 - textLength/2;
        y += 60;
        g2.drawString(text, x , y);

        if (gp.musicOn) {
            gp.stopMusic();
        }
        gp.gameState = gp.fightState;
        //gp.pauseState = true;
        //gp.gameThread = null;
    }
    public void drawCompleted (Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setFont(g2.getFont().deriveFont(45F));
        g2.setColor(Color.YELLOW);

        String text;
        int textLength;
        int x, y;
        text = "You have completed the game!";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gp.screenWidth / 2 - textLength/2;
        y = gp.screenHeight / 2 - (gp.tileSize * 3)+60;
        g2.drawString(text, x , y);

        text = "Congratulations.";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gp.screenWidth / 2 - textLength/2;
        y += 50;
        g2.drawString(text, x , y);
        if (gp.musicOn) {
            gp.stopMusic();
        }
        gp.gameThread = null;
    }
    public void drawInventoryAndStats (Graphics2D g2) {

        //HealthBar(g2);
        fancyHealthBar(g2);

        g2.setFont(arial_40);
        g2.drawImage(images[0], x1, y1, width, height, null);
        g2.drawImage(images[2], x1 + 20, y1 + 50 + adjustdown, 40, 40, null);
        g2.drawString(String.valueOf(gp.hero.attack), x1 + 65, 84 + adjustdown);
        g2.drawImage(images[1], x1 + 20, y1 + 100 + adjustdown, 40, 40, null);
        g2.drawString(String.valueOf(gp.hero.defense), x1 + 65, 84 + 50 + adjustdown);

        if (gp.hero.hasKey) {
            g2.drawImage(images[4], x1 + 20, y1 + 150 + adjustdown, 40, 40, null);
        }
        if (gp.hero.hasBoots) {
            g2.drawImage(images[3], x1 + 69, y1 + 150 + adjustdown, 40, 40, null);
        }
        if (gp.hero.hasSword) {
            g2.drawImage(images[7], x1 + 69 + 50, y1 + 150 + adjustdown, 40, 40, null);
        }
        if (gp.hero.hasArmor) {
            g2.drawImage(images[8], x1 + 69 + 100, y1 + 150 + adjustdown, 40, 40, null);
        }
    }
    public void drawMessageInPanel(Graphics2D g2) {
        if (newIncMessage) {
            messageCounter = 0;
        }
        g2.setColor(Color.WHITE);
        if (messageOn) {
            int x = 895;
            int y = 255;
            g2.setFont(arial_40);
            g2.setFont(g2.getFont().deriveFont(17F));
            for(String line : messageToDraw.split("\n")){
                g2.drawString(line, x , y);
                y += 25;
            }
            messageCounter++;
            if (messageCounter > 240) {
                messageCounter = 0;
                messageOn = false;
                newIncMessage = false;
            }
        }
    }

    /*public void HealthBar(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setStroke(new BasicStroke(healthBarBorder));
        g2.drawRoundRect(x1 + 20, 30, healthBarWidth, healthBarHeight, healthBarArc, healthBarArc);
        g2.setColor(new Color(255,71,76));
        g2.fillRoundRect(x1 + 20 + 1, 30 + 1, (int) (healthBarWidth * gp.hero.health / gp.hero.maxHealth) - 2, healthBarHeight - 2, 5, 5);
        g2.setFont(g2.getFont().deriveFont(20F));
        g2.setColor(Color.BLACK);
        g2.drawString(String.valueOf(gp.hero.health) + " / " + gp.hero.maxHealth, x1 + 90, 55);
    }*/

    public void fancyHealthBar(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setStroke(new BasicStroke(healthBarBorder));
        g2.setColor(new Color(255,71,76));
        g2.fillRoundRect(healthBarX, healthBarY, (int)(Math.ceil((healthBarWidth * savedHealth2 / gp.hero.maxHealth))), healthBarHeight, healthBarArc, healthBarArc);

        g2.setColor(Color.BLACK);
        g2.drawRoundRect(healthBarX-1, healthBarY-1, healthBarWidth+1, healthBarHeight+2, healthBarArc, healthBarArc);

        if(savedHealth != gp.hero.health){
            healthJustChanged = true;
        }

        if(healthJustChanged) {
            savedHealthDelta = Math.abs(savedHealth2 - gp.hero.health);

            if (savedHealth2 < gp.hero.health) {
                // health increased

                g2.setColor(new Color(255, 71, 76));
                g2.fillRoundRect(healthBarX, healthBarY, (healthBarWidth * savedHealth2 / gp.hero.maxHealth), healthBarHeight, healthBarArc, healthBarArc);
                g2.setColor(new Color(230, 120, 150));
                g2.fillRoundRect(healthBarX + (healthBarWidth * savedHealth2 / gp.hero.maxHealth), healthBarY, (int) (healthBarWidth * (savedHealthDelta) / gp.hero.maxHealth), healthBarHeight, healthBarArc, healthBarArc);
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(healthBarX-1, healthBarY-1, healthBarWidth+1, healthBarHeight+2, healthBarArc, healthBarArc);
            }
            if (savedHealth2 > gp.hero.health) {
                //health decreased

                g2.setColor(new Color(255, 71, 76));
                g2.fillRoundRect(healthBarX, healthBarY, (healthBarWidth * gp.hero.health / gp.hero.maxHealth), healthBarHeight, healthBarArc, healthBarArc);
                g2.setColor(new Color(230, 120, 150));
                g2.fillRoundRect(healthBarX + (healthBarWidth * gp.hero.health / gp.hero.maxHealth), healthBarY, (healthBarWidth * (savedHealthDelta) / gp.hero.maxHealth), healthBarHeight, healthBarArc, healthBarArc);
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(healthBarX-1, healthBarY-1, healthBarWidth+1, healthBarHeight+2, healthBarArc, healthBarArc);
            }

            healthBarFancyDisplayCounter ++;
            if(savedHealth != gp.hero.health){
                healthBarFancyDisplayCounter = 0;
            }

            if(healthBarFancyDisplayCounter > 60){

                healthBarFancyDisplayCounter = 0;
                healthJustChanged = false;
                savedHealth2 = gp.hero.health;
            }
        }
        g2.setFont(g2.getFont().deriveFont(30F));
        g2.setColor(Color.BLACK);
        g2.drawString(gp.hero.health + " / " + gp.hero.maxHealth, x1 + 96, 58);
        savedHealth = gp.hero.health;
    }

    public void showTheTime(Graphics2D g2) {
        g2.setFont(g2.getFont().deriveFont(30F));
        playTime += (double) 1/60;
        g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 10, 660);
    }

    public void showStatus(Graphics2D g2) {
        g2.setFont(g2.getFont().deriveFont(25F));
        g2.drawString(statusToDraw, gp.tileSize * 10, 690);
    }

    public void showMessage(String text1) {
        messageToDraw = text1;
        messageOn = true;
        countmessage1 ++;
    }
    public void getImage() {
        try{
            images[0] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/bracket.png"));
            images[1] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/shield.png"));
            images[2] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/sword.png"));
            images[3] = ImageIO.read(getClass(). getResourceAsStream("/objects/boots.png"));
            images[4] = ImageIO.read(getClass(). getResourceAsStream("/objects/key.png"));
            images[5] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/soundOn.png"));
            images[6] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/soundOff.png"));
            images[7] = ImageIO.read(getClass().getResourceAsStream("/objects/redsword.png"));
            images[8] = ImageIO.read(getClass().getResourceAsStream("/infoPanel/armoricon.png"));
            images[9] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/r.png"));
            images[10] = ImageIO.read(getClass(). getResourceAsStream("/infoPanel/m.png"));
            images[11] = ImageIO.read(getClass().getResourceAsStream("/infoPanel/space.png"));
            images[12] = ImageIO.read(getClass().getResourceAsStream("/infoPanel/enter.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
