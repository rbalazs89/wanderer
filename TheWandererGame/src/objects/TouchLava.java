package objects;

import java.awt.*;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class TouchLava extends MyObjects {

    public TouchLava() {
        try {
            image = read(getClass().getResourceAsStream("/objects/blank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        solidArea.x = 12;
        solidArea.y = 12;
        solidArea.width = 48;
        solidArea.height = 48;
    }

    public void objectAction() {
        gp.ui.showMessage("Even the ground beneath\nyour feet is your enemy.");
        if ((int)(Math.random() * 13) == 0) {
            gp.playSE(13);
            gp.hero.health -= 1;
        }
    }
}