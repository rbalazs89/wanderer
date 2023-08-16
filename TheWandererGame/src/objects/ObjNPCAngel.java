package objects;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class ObjNPCAngel extends MyObjects {

    public ObjNPCAngel() {
        try {
            image = read(getClass().getResourceAsStream("/objects/angel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void objectAction() {
        if(gp.obj[6] == null) {
            gp.ui.showMessage("Now you are ready to face\nthe demon lurking below. Don't\nneglect reading the stone tablets\ndeeper below. They offer\ngreat wisdom.");
        }
        else {
            gp.ui.showMessage("Before venturing further,\nstep into the light behind me\nto receive the blessing of the\nangels.");
        }
    }
}