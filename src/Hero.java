import java.awt.*;

public class Hero {

    //variable decleration section
    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    //movement booleans
    public boolean upIsPressed=false;
    public boolean downIsPressed=false;
    public boolean leftIsPressed;
    public boolean rightIsPressed;


    //constructor method
    public Hero(int pXpos, int pYpos, int pdx, int pdy, int pwidth, int pheight, boolean pisAlive){
        xpos = pXpos;
        ypos = pYpos;
        dx=pdx;
        dy=pdy;
        width=pwidth;
        height=pheight;
        isAlive=pisAlive;
        rec=new Rectangle(xpos+(width/4), ypos+(height/3),(width/2),(height/2));
    }

    public void move(int speed){

        if(upIsPressed) {
            dy=-speed;
        } else if (downIsPressed) {
            dy=speed;
        }else{
            dy=0;
        }

        if(leftIsPressed){
            dx=-speed;
        } else if(rightIsPressed){
            dx=+speed;
        }else{
            dx=0;
        }

        //makes the cat snake/wrap
        if(xpos>1000){
            xpos=-width;
        }
        if(xpos<-width){
            xpos=1000;
        }
        if(ypos>700){
            ypos=-height;
        }
        if(ypos<-height){
            ypos=700;
        }

        ypos = ypos+dy;
        xpos = xpos+dx;
        rec=new Rectangle(xpos+(width/4), ypos+(height/3),(width/2),(height/2));
    }

    public void wrappingMove(){
        if(xpos>1000){
            xpos=0;
        }
        if(xpos<0){
            xpos=1000;
        }
        if(ypos>700){
            ypos=0;
        }
        if(ypos<0){
            ypos=700;
        }
        //these move things come after because you need to check for position first then decide where to move to
        ypos = ypos-dy;
        xpos = xpos+dx;
        rec=new Rectangle(xpos+(width/4), ypos+(height/3),(width/2),(height/2));
    }

    public void bouncingMove(){
        if(xpos>(2100-width) || xpos<-1000){
            dx=-dx;
        }
        if(ypos>(1800-height) || ypos<-1000){
            dy=-dy;
        }
        ypos = ypos-dy;
        xpos = xpos+dx;
        rec=new Rectangle(xpos+(width/4), ypos+(height/3),(width/2),(height/2));
    }

    public void printInfo(){
        System.out.println("(x,y): (" + xpos + "," + ypos + ")");
        System.out.println("x speed: " + dx);
        System.out.println("y speed: " + dy);
        System.out.println("width: " + width);
        System.out.println("height: " + height);
        System.out.println("is alive: " + isAlive);
    }

}
