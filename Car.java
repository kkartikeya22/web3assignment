/*The class Car only include the attributes and methods asked to be made in the assignment. For inputting the data a separate class has to be made which imports the present class and can implement all the methods of the class Car */


/*An extra attribute namely private double a[] is made to include the direction of motion or speed(both same) thus helping in updating the coordinates of the car. Corresponding to the attribute a function namely public void vvector(double e,double f,double g) is also made, which takes the components of speed vector in x,y and z direction as input in the variables e,f and g. Further in the function the components are divided by the modulus of the so called vector inputted so the it could be converted in  a unit vector.  */

import java.util.*;
public class Car{
    private String make;
    private String model;
    private double a[]; // stores the direction of speed and thus the direction of motion
    private int year;
    private int speed;
    private int x;
    private int y;
    private int z;
    
    public Car(String make,String model, int year, int speed,int x,int y,int z){
        this.make=make;
        this.model=model;
        this.year=year;
        this.speed=speed;
        this.x=x;
        this.y=y;
        this.z=z;
        this.a=new double[3];
    }

    public void vvector(double e,double f,double g)
    {
        double j=Math.sqrt(e*e+f*f+g*g);
        this.a[0]=e/j;//x-component of velocity 
        this.a[1]=f/j;//y component of velocity
        this.a[2]=g/j;//z component of velocity
    }

    public String getmake()
    {
        return make;
    }

    public String getModel(){
        return model;
    } 

    public int getyear(){
        return year;
    }

    public int getSpeed(){
        return speed;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ()
    {
        return z;
    }

    public void accelerate(int speed_Increment){
        speed+=speed_Increment;
    }

    public void brake(int speed_Decrement)
    {
        speed-=speed_Decrement;
        if(speed<=0)
        speed=0;
    }

    public void move(){
        x+=speed*(int)a[0];//increasing the x coordinate with the component of velocity in x-direction
        y=y+speed*(int)a[1];//increasing the y coordinate with the component of velocity in y-direction
        z+=speed*(int)a[2];//increasing the z coordinate with the component of velocity in z-direction
    }

    public boolean detect_collision(Car car2)
    {
        if(this.x== car2.getX() && this.y== car2.getY()&&this.z==car2.getZ())
        return true;
        else
        return false;
    }
    
    public double time_to_collision (Car car2)
    {
        int xdiff=car2.getX()-this.x;
        int ydiff=car2.getY()-this.y;
        int zdiff=car2.getZ()-this.z;
        int relspeedX=this.speed*(int)this.a[0]-car2.speed*(int)car2.a[0];
        int relspeedY=this.speed*(int)this.a[1]-car2.speed*(int)car2.a[1];
        int relspeedZ=this.speed*(int)this.a[2]-car2.speed*(int)car2.a[2];
        int time[]=new int[3];
        int k=0;
        
        //for x direction
       if(relspeedX!=0&&xdiff!=0)
           time[k++]=xdiff/relspeedX;
       if(relspeedX==0&& xdiff!=0)
           return Double.POSITIVE_INFINITY;
        
        //for Y direction
       if(relspeedY!=0&&ydiff!=0)
           time[k++]=ydiff/relspeedY;
       if(relspeedY==0&& ydiff!=0)
           return Double.POSITIVE_INFINITY;
        
        //for x direction
       if(relspeedZ!=0&& zdiff!=0)
           time[k++]=zdiff/relspeedZ;
       if(relspeedZ==0&& zdiff!=0)
           return Double.POSITIVE_INFINITY;
        
        if(k==0)
            return 0.0;
        else if(k==1)
            return (double)time[0];
        else if(k==2)
        {
            if(time[0]==time[1])
                return (double)time[0];
            else return Double.POSITIVE_INFINITY;
        }
        else
        {
            if(time[0]==time[1]&& time[0]==time[2] && time[1]==time[2])
                return (double)time[0];
            else
                return Double.POSITIVE_INFINITY;
        }
    }
}


