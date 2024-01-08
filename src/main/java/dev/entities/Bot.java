package dev.entities;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import dev.controller.GameConstants;
import dev.controller.GameHandler;

public class Bot extends Character {
    int count = 0;
    // MAP
    public Tile[] tile;
    public int[][] map;
    //int dem = -1;

    //GameHandler gh;
    public boolean hitPlayer;
    private int directionX, directionY;
    public boolean ok = false;
    public boolean zone = false;
    public int[][] territory;
    int fix;
    // path
    public int[] path;
    public int[] f_path;

    public int[][] check;
    
    //player
    public int playerX, playerY;
    public int botX, botY;

    public int num = -1;

    int time =0;
    int r[] = {-1, 1, 0, 0};
    int l[] = {0, 0, -1, 1};

    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;
    int x4;
    int y4;
    /*
    0 : left
    1 : right
    2 : up
    3 : down
     */
    int X;
    int Y;

    public Bot(GameHandler gh){
        
        super(gh);
        // PLAYER

        map =  Map.map_1;
        direction = "down";
        speed = 1;
        //isDead = false;
        // SIZE
        // solidArea.x = 0;
        // solidArea.y = 0;
        // solidArea.width = 48;
        // solidArea.height = 48;
        solidArea.x = 16;
        solidArea.y = 8;
        solidArea.width = 32;
        solidArea.height = 32;
        setImage();
        
        //HEALTHY
        this.max_total_lives = 4;
        this.total_lives = this.max_total_lives;
        // ACTIVE ZONE
        check = new int[100][100];

        path = new int[1000];
        f_path = new int[1000];

        territory = new int[80][80];
        SolidX = 16;
        SolidY = 8;
    }

    public void setImage(){
                try{
            up1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_left_3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/spider/spider_right_3.png"));
        }catch(IOException e){
            
        }
    }
    public void trespassing(){
         x1 = this.Regionx * GameConstants.tileSize;
         y1 = this.Regiony * GameConstants.tileSize;

         x2 = this.Regionx * GameConstants.tileSize;
         y2 = (this.Regiony + this.heig) * GameConstants.tileSize;

         x3 = (this.Regionx +this.wid) * GameConstants.tileSize;
         y3 = this.Regiony * GameConstants.tileSize;

         x4 = (this.Regionx +this.wid) * GameConstants.tileSize;
         y4 = (this.Regiony + this.heig) * GameConstants.tileSize;


        // PLAYER COORDINATE
         X = (gh.player.getX() + gh.player.solidArea.x);
         Y = (gh.player.getY() + gh.player.solidArea.y);
         //X = (gh.player.getY() + gh.player.solidArea.x) / GameConstants.tileSize;
         //Y = (gh.player.getX()+ gh.player.solidArea.y) / GameConstants.tileSize;

        if( y1 <= Y && Y <= y2 && x1 <= X && X <= x3 ){
            this.zone = true;
            //System.out.println("zone");
        }
        else{
            this.zone = false;
            // fix = 0;
            // ok = false;
            //System.out.println("out zone");
        }
        // x1 = this.Regionx;
        //  y1 = this.Regiony;

        //  x2 = this.Regionx;
        //  y2 = (this.Regiony + this.heig);

        //  x3 = (this.Regionx +this.wid);
        //  y3 = this.Regiony;

        //  x4 = (this.Regionx +this.wid);
        //  y4 = (this.Regiony + this.heig);

    }

public void attack(){
     botX = (this.getY() + this.solidArea.x);
     botY = (this.getX() + this.solidArea.y);
     playerX = gh.player.getY() + gh.player.solidArea.x;
     playerY = gh.player.getX() + gh.player.solidArea.y;


}

public void tracking(){
        //Random number = new Random();
        //int t = number.nextInt(2);
        directionX = playerX - botX;
        directionY = playerY - botY;

    //if(!directionX){
        {
    if( directionX > 8)
        this.direction = "down";
        else    if(directionY < 0)
        this.direction = "left";
    else if(directionX < 0)
        this.direction = "up";
    else {


     if(directionY > 8)
        this.direction = "right";

    }
    }

//}
}

public void setAction(){

    //direction = "down";
    //zone();
    trespassing();
    if(this.zone == true){
        attack();
        tracking();
        //System.out.println(direction);
        move();
    }
    else{
        time ++;
        if(time == 25){
        Random rand = new Random();
        count = rand.nextInt(40);
        if(count <= 10)
            direction = "left";
        else if(count > 10 && count <= 20){
            direction = "right";
        }else if(count > 20 && count <= 30){
            direction = "up";
        }else if(count >= 30){
           direction = "down";
        }
        time = 0;
        }
        //move();
    }
    }
    public void update(){
        setAction();
        //System.out.println(this.index +" " +total_lives);
    }


    public void move(){
        //if(ok == true){

        //num ++;
        //checkDirection(f_path[num]);
        //for(int i = 0 ; i <= 1; i++){
        isCollide = false;
        gh.checker.checkTile(this);

        gh.checker.checkEntity( this, gh.bot);
        
        gh.checker.checkPlayer(this);
        
    
        if(this.isCollide == false){
            switch (this.direction) {
                case "up": this.setY(y_coordinate - speed); break;
                case "down": this.setY(y_coordinate + speed); break;
                case "left": this.setX(x_coordinate - speed); break;
                case "right": this.setX(x_coordinate + speed); break;
            }
        }
        //this.draw(graphics2D);
    //}
    //}
    }

    
}
