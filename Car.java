package Web3assignment;
public class Car{
        private String make;
        private String model;
        private double a[];
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
            this.a[0]=e/j;
            this.a[1]=f/j;
            this.a[2]=g/j;
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
            x+=speed*(int)a[0];
            y=y+speed*(int)a[1];
            z+=speed*(int)a[2];
        }

        public boolean detect_collision(Car car2)
        {
            if(this.x== car2.getX() && this.y== car2.getY()&&this.z==car2.getZ())
            return true;
            else
            return false;
        }
        
        public double time_to_coll (Car car2)
        {
            int xdiff=car2.getX()-this.x;
            int ydiff=car2.getY()-this.y;
            int zdiff=car2.getZ()-this.z;
            double dist=Math.sqrt(xdiff*xdiff+ydiff*ydiff+zdiff*zdiff);
            int relspeed=this.speed-car2.speed;
            if(relspeed>0)
            {
                return dist/relspeed;
            }
            if(relspeed==0&&dist==0)
            return 0.0;
            else
            return Double.POSITIVE_INFINITY;
        }
    }

