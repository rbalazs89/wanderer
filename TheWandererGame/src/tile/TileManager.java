package tile;

import Main.GamePanel;
import Main.resizeimages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/maps/map"+ Integer.toString(gp.currentMap) +".txt");
    }

    public void getTileImage() {

        //try{
            //tile[0] = new Tile();
            //tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            //tile[0].collision = false;

        // only tile collision added here
        // tile effects are added by objects
            setup(0, "grass", false);
            setup(1, "grasswall", true);
            setup(2, "grasspond", false);
            setup(3, "bearden", true);
            setup(4, "sand", false);
            setup(5, "sandrock1", true);
            setup(6, "sandrock2", true);
            setup(7, "sandrock3", true);
            setup(8, "sandhole", false);
            setup(9, "cavetile", false);
            setup(10, "rock1", true);
            setup(11, "rock2", true);
            setup(12, "rock3", true);
            setup(13, "rock4", true);
            setup(14, "rock5", true);
            setup(15, "rock6", true);
            setup(16, "rock7", true);
            setup(17, "rock8", true);
            setup(18, "healingpool", false);
            setup(19, "rock8", false);
            setup(20, "stonehut", true);
            setup(21, "hellfloor", false);
            setup(22, "lavafloor", false);
            setup(23, "heaventile", false);
            setup(24, "hellrock1", true);
            setup(25, "marble", false);
            setup(26, "heavenwall", true);
    }
    public void setup(int index, String imagePath, boolean collision){
        resizeimages resizing = new resizeimages();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath + ".png"));
            tile[index].image = resizing.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String mapLocation) {
        try{
            InputStream is = getClass().getResourceAsStream(mapLocation);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while( col < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col ++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row ++;
                }
            }
        }
        catch(Exception e){
        }
    }
    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, null);
            col ++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
