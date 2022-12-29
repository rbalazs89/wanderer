package Main;

import java.awt.*;

public class InfoPanel2 {
    //class handles pause screen only
    Graphics2D g2;
    GamePanel gp;
    Font arial_40, arial_80B;
    public InfoPanel2(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }


    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState) {

        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //if(gp.gameState == gp.dialogueState){
            //drawDialogueScreen();
        //}
    }
    public void drawDialogueScreen() {

    }

    public void drawPauseScreen() {
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(120F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text,x,y);
    }

    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }

}
