# web3assignment
SnT summer project

The project includes a Java code for the detection of collision of 2 cars and if collision is possible then it tells the time of collision. The class does not includes a main function as it deals only with the functions and sttributes. An extra function and an extra attribute is added which the direction of motion i.e. the direction of speed in the x,y and z axis and calculates a unit vector in the direction of speed which facilitates in updating the speed in the function move() by adding the component of  speed in their respective directions namely x,y and z directions. 
In the case when the cars would not collide then we would return the time to be Double.POSITIVE_INFINITY which implies that collision might occur after infinite time. 
It is assumed that car 1 is behind car 2 and thus if car1 moving with greater velocity than that of car 2 the function would return a finite time. If they are moving with same speed then collision would be detected only if their separation is 0.
