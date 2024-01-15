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

    public String tmp;
    
    //player
    public int playerX, playerY;
    public int botX, botY;

    public int num = -1;

    int time = 0;
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
        available = true;
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
         X = (gh.player.getX() + gh.player.solidArea.x +10);
         Y = (gh.player.getY() + gh.player.solidArea.y +10);


        if( y1 <= Y && Y <= y2 && x1 <= X && X <= x3 ){
            this.zone = true;

        }
        else{
            this.zone = false;

        }


    }

public void attack(){
     botX = (this.getY() + this.solidArea.x);
     botY = (this.getX() + this.solidArea.y);
     playerX = gh.player.getY() + gh.player.solidArea.x;
     playerY = gh.player.getX() + gh.player.solidArea.y;


}

public void tracking(){

    directionX = playerX - botX;
    directionY = playerY - botY;

    if( directionX > 8)
        this.direction = "down";
        else
        if(directionY < 0)
        this.direction = "left";
    else if(directionX < 0)
        this.direction = "up";
    else {


     if(directionY > 8)
        this.direction = "right";

    }

}

public void setAction(){
    time ++;
    if(this.level == 3){
    
        trespassing();
    if(gun == true){

    if(time == 45){
        Random rand = new Random();
        count = rand.nextInt(40);
        if(count <= 10)
            tmp = "left";
        else if(count > 10 && count <= 20)
            tmp = "right";
        else if(count > 20 && count <= 30)
            tmp = "up";
        else if(count >= 30)
           tmp = "down";

        gh.bulletList.add(new Bullet(this.x_coordinate , this.y_coordinate, tmp,gh));
        System.out.println("tien");
    }
    }
    if(this.zone == true){
        attack();
        tracking();
        move();{


    }
    }else{
        if(time == 50){
        Random rand = new Random();
        count = rand.nextInt(40);
        if(count <= 10)
            direction = "left";
        else if(count > 10 && count <= 20)
            direction = "right";
        else if(count > 20 && count <= 30)
            direction = "up";
        else if(count >= 30)
           direction = "down";
        
        time = 0;
        }
    }
}
else if(this.level == 1){

        
        if(time >= 45){
            if(this.direction == "left")
                this.direction = "right";
            else
                this.direction = "left";
            time = 0;
        }
        move();
}else if(this.level == 2){
        if(time >= 45){
            if(this.direction == "up")
                this.direction = "down";
            else
                this.direction = "up";
            time = 0;
        }
        move();
}
}
    
public void update(){
        if(this.available == false){
            duration ++;
            if(duration == 25){
                this.available = true;
                duration = 0;
            }
        
        }
        setAction();

    }
	// public int damage(Character entity){

		
	// 	int pillar = 1000;


	// 	{
    //         int hardX = this.solidArea.x;
    //         int hardY = this.solidArea.y;
    //         this.solidArea.x += this.x;
    //         this.solidArea.y += this.y;
    //         int solidX = gh.player.solidArea.x;
    //         int solidY = gh.player.solidArea.y;
    //         gh.player.solidArea.x += gh.player.getX();
    //         gh.player.solidArea.y += gh.player.getY();

	// 			switch (this.direction) {
	// 				case "up":

	// 				this.Y -= speed;
	// 				if(this.solidArea.intersects(gh.player.solidArea) == true){
    //                         dead(gh.player);
    //                         this.shot = true;

	// 				}
	// 				break;
	// 				case "down":

	// 				this.y += speed;
	// 				if(this.solidArea.intersects(gh.player.solidArea) == true){
    //                         dead(gh.player);
    //                     this.shot = true;

	// 				}
	// 				break;
	// 				case "left":

	// 				this.x -= speed;
	// 				if(this.solidArea.intersects(gh.player.solidArea) == true){
    //                             dead(gh.player);
    //                         this.shot = true;
	// 				}
	// 				break;
	// 				case "right":

	// 				this.x += speed;
	// 				if(this.solidArea.intersects(gh.player.solidArea) == true){
    //                             dead(gh.player);
    //                         this.shot = true;

					
	// 				}
	// 				break;
	// 			}
    //         this.solidArea.x = hardX;
    //         this.solidArea.y = hardY;
    //         this.solidArea.x = solidX;
    //         this.solidArea.y = solidY;

	// 		}

	// 	return pillar;

	// }


    public void move(){

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
    }

    
}
