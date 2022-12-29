package Main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    //check movement collision
    public void checkTile(Entity entity) {

        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision || entity.y < 0) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision || entity.y > (gp.maxScreenRow - 1) * gp.tileSize - 2 * entity.speed) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision || entity.x < 0) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision || entity.x > (gp.maxScreenCol - 1) * gp.tileSize - entity.speed) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    //check for item pickup
    public int checkObject (Entity entity, boolean isHero) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if(gp.obj[i] != null){
                //Get entitys solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(isHero) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(isHero) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(isHero) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(isHero) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
    // check if hero move into entity
    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999;

        for (int i = 0; i < target.length; i++) {
            if(target[i] != null){
                //Get entitys solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            if(target[i].entityCollision) {
                                entity.collisionOn = true;
                            }
                                index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            if(target[i].entityCollision) {
                                entity.collisionOn = true;
                            }
                                index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            if(target[i].entityCollision) {
                                entity.collisionOn = true;
                            }
                                index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            if(target[i].entityCollision) {
                                entity.collisionOn = true;
                            }
                                index = i;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    //checks if entity moves into hero
    //this is not working well for some reason
    public void checkHero(Entity entity){

        //entity.solidArea.x = entity.x + entity.solidArea.x - 12;
        //entity.solidArea.y = entity.y + entity.solidArea.y - 12;
        entity.solidArea.width = 24;
        entity.solidArea.height = 24;
        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.y + entity.solidArea.y;
        gp.hero.solidArea.x = gp.hero.x + gp.hero.solidArea.x;
        gp.hero.solidArea.y = gp.hero.y + gp.hero.solidArea.y;

        switch(entity.direction) {
            case "up":
                entity.solidArea.y -= entity.speed;
                if (entity.solidArea.intersects(gp.hero.solidArea)) {
                    if(entity.entityCollision) {

                        gp.hero.currentEnemyIndex = entity.entityIndex;
                        //gp.gameState = gp.fightState;
                        gp.hero.interactEntity(entity.entityIndex);
                        entity.collisionOn = true;
                    }
                }
                break;
            case "down":
                entity.solidArea.y += entity.speed;
                if (entity.solidArea.intersects(gp.hero.solidArea)) {
                    if(entity.entityCollision) {

                        gp.hero.currentEnemyIndex = entity.entityIndex;
                        //gp.gameState = gp.fightState;
                        gp.hero.interactEntity(entity.entityIndex);
                        entity.collisionOn = true;
                    }
                }
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                if (entity.solidArea.intersects(gp.hero.solidArea)) {
                    if(entity.entityCollision) {

                        gp.hero.currentEnemyIndex = entity.entityIndex;
                        //gp.gameState = gp.fightState;
                        gp.hero.interactEntity(entity.entityIndex);
                        entity.collisionOn = true;
                    }
                }
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(gp.hero.solidArea)) {
                    if(entity.entityCollision) {

                        gp.hero.currentEnemyIndex = entity.entityIndex;
                        //gp.gameState = gp.fightState;
                        gp.hero.interactEntity(entity.entityIndex);
                        entity.collisionOn = true;
                    }
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        entity.solidArea.width = entity.solidAreaDefaultWidth;
        entity.solidArea.height = entity.solidAreaDefaultHeight;
        gp.hero.solidArea.x = gp.hero.solidAreaDefaultX;
        gp.hero.solidArea.y = gp.hero.solidAreaDefaultY;

    }
}
