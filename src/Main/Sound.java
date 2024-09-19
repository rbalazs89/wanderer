package Main;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    //public boolean soundOn = true;
    Clip clip;
    URL soundURL[] = new URL[30];
    public Sound() {
        soundURL[0] = getClass().getResource("/sound/forestambient.wav");
        soundURL[1] = getClass().getResource("/sound/healthpickup.wav");
        soundURL[2] = getClass().getResource("/sound/metalpickup.wav");
        soundURL[3] = getClass().getResource("/sound/keypickup.wav");
        soundURL[4] = getClass().getResource("/sound/desertambient.wav");
        soundURL[5] = getClass().getResource("/sound/caveambient.wav");
        soundURL[6] = getClass().getResource("/sound/hellambient.wav");
        soundURL[7] = getClass().getResource("/sound/punch/punch1.wav");
        soundURL[8] = getClass().getResource("/sound/punch/punch2.wav");
        soundURL[9] = getClass().getResource("/sound/punch/punch3.wav");
        soundURL[10] = getClass().getResource("/sound/punch/punch4.wav");
        soundURL[11] = getClass().getResource("/sound/punch/punch5.wav");
        soundURL[12] = getClass().getResource("/sound/drinkwater.wav");
        soundURL[13] = getClass().getResource("/sound/retreat.wav"); // take damage sound
        soundURL[14] = getClass().getResource("/sound/bear.wav");
        soundURL[15] = getClass().getResource("/sound/scaryninjaappears.wav");
        soundURL[16] = getClass().getResource("/sound/cactus.wav");
        soundURL[17] = getClass().getResource("/sound/pushdoor.wav");
        soundURL[18] = getClass().getResource("/sound/swordpickup.wav");
        soundURL[19] = getClass().getResource("/sound/miertGyurcsanyJobbVolt.wav");
        soundURL[20] = getClass().getResource("/sound/blessing.wav");
        soundURL[21] = getClass().getResource("/sound/kissthefrog.wav");
    }
    public void setFile(int a) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[a]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){
        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }

}
