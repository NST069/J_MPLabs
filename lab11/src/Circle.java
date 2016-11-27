import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Nikola Slavich on 21.11.2016.
 */
public class Circle extends JFrame {
    private static Random randomizer = new Random();

    private int X;
    private int Y;
    private int speedX;
    private boolean axisX;
    private int speedY;
    private boolean axisY;
    private Color color;
    private int size;

    public Circle(){
        this.X=50;
        this.Y=50;
        this.speedX=1;
        this.speedY=1;
        this.axisX=true;
        this.axisY=true;
        this.color=Color.BLACK;
        this.size=10;
    }

    public Circle(int X, int Y, int size, Color color){
        this.X=X;
        this.Y=Y;
        this.size=size;
        this.color=color;
        this.speedX=randomSpeed();
        this.speedY=randomSpeed();
        this.axisX=randomAxis();
        this.axisY=randomAxis();
    }

    public Circle(Circle ob){
        this.X=ob.X;
        this.Y=ob.Y;
        this.size=ob.size;
        this.color=ob.color;
        this.speedX=ob.speedX;
        this.speedY=ob.speedY;
        this.axisX=ob.axisX;
        this.axisY=ob.axisY;
    }

    private int randomSpeed(){
        return randomizer.nextInt(20);
    }
    private boolean randomAxis(){
        return randomizer.nextBoolean();
    }
    private Color randomColor(){
        return Color.getHSBColor(randomizer.nextFloat(), randomizer.nextFloat(), randomizer.nextFloat());
    }

    public void move(){
        this.X+=this.speedX/3*((this.axisX)?1:-1);
        this.Y+=this.speedY/3*((this.axisY)?1:-1);

    }

    public void reverseAxis(char xy){
        if(xy == 'x'){
            if (speedX==0) axisX=randomAxis();
            else this.axisX = !this.axisX;
        }
        else if(xy=='y'){
            if(speedY==0) axisY=randomAxis();
            else this.axisY = !this.axisY;
        }
    }

    public void Collision(boolean isX, boolean isY) {
        if (!isX && !isY) return;
        else {
            System.out.println("Collision\nAxis:"+((isX)?"x":"")+((isY)?"y":""));
            if (isX) reverseAxis('x');
            if (isY) reverseAxis('y');
            this.color = randomColor();
            this.speedX=randomSpeed();
            this.speedY=randomSpeed();
        }
    }

    public int getX(){return this.X;}
    public int getY(){return this.Y;}
    public void setX(int X){this.X=X;}
    public void setY(int Y){this.Y=Y;}
    public int getCSize(){return this.size;}
    public void setCSize(int size){this.size=size;}
    public Color getColor(){return this.color;}
    public void setColor(Color color){this.color=color;}
    public double getSpeed(){return Math.sqrt(Math.pow(this.speedX*((axisX)?1:-1),2)+Math.pow(this.speedY*((axisY)?1:-1),2));}
    public int getSpeedX(){return this.speedX*((axisX)?1:-1);}
    public int getSpeedY(){return this.speedY*((axisY)?1:-1);}
    public String getStrSpeed(){return "["+this.speedX*((this.axisX)?1:-1)+", "+this.speedY*((this.axisY)?1:-1)+"]";}
    public void setSpeed(char xy, int speed){
        if(xy=='x'){
            this.speedX=Math.abs(speed);
            this.axisX=speed>=0;
        }
        if(xy=='y'){
            this.speedY=Math.abs(speed);
            this.axisY=speed>=0;
        }
    }

    @Override
    public String toString(){
        return "["+this.X+", "+this.Y+"],{"+(this.X+this.size)+", "+(this.Y+this.size)+"} speed"+getStrSpeed();
    }
}
