package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean enterPressed;
    public boolean Tpressed = false;
    boolean checkDrawTime = false;
    public boolean lPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_T){
            Tpressed = !Tpressed;
        }

        if (code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        if (code == KeyEvent.VK_L){
            lPressed = true;
            gp.restartLevel();
            gp.ui.gameIsFinished = false;
        }

        if (code == KeyEvent.VK_M){
            if (gp.musicOn) {
                gp.stopMusic();
                gp.musicOn = false;
            }
            else {
                gp.playMusic(gp.currentMap);
                gp.musicOn = true;
            }
        }

        if(gp.gameState == gp.fightState){
            if (code == KeyEvent.VK_SPACE){
                if (gp.hero.currentEnemyIndex == 999){ // this should never happen, but sometimes I get this error
                gp.gameState = gp.playState;
                gp.hero.isCurrentlyGraced = true;
                }else {
                    gp.hero.fight(gp.monsterOrNPC[gp.hero.currentEnemyIndex]);
                }
            }
            if (code == KeyEvent.VK_R){
                if (gp.hero.currentEnemyIndex == 999){ //should never happen
                    gp.hero.retreat2(); // can retreat without damage
                }
                else {gp.hero.retreat(gp.monsterOrNPC[gp.hero.currentEnemyIndex]);}
            }
        }
        if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_UP) {
                upPressed = true;
            } else if (code == KeyEvent.VK_DOWN) {
                downPressed = true;
            } else if (code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            } else if (code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_T) {
                checkDrawTime = !checkDrawTime;
            }
        }
        if (code == KeyEvent.VK_P) {
            if (gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }

        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }

        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }

        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if (code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }
        if (code == KeyEvent.VK_L){
            lPressed = false;
        }
    }
}
