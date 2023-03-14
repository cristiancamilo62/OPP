package com.camilo.car.domain;

public class Car {
    public String typeOfWheels;
    public String color;
    public String serial;
    public String plate;
    public float speed;
    public float maximumSpeed = 300;
    public String bodyType;
    public int actualChange;
    public int maximumChange = 5;

    public void accelerate(float amountIncrementSpeed){
        if((this.speed+=amountIncrementSpeed) < this.maximumSpeed){
            this.speed+= amountIncrementSpeed;
            System.out.println("the actual speed is:"+this.speed);
        }

    }
    public void breaking(int amountDecrementSpeed){
        if(this.speed<=amountDecrementSpeed){
            System.out.println("the car is stopped");

        }
        else{
            this.speed-=amountDecrementSpeed;
            System.out.println("the actual speed is:"+ this.speed);
        }
    }
    public void upChange(){
        if(this.actualChange < this.maximumChange){
            this.actualChange++;
            System.out.println("the actual change is: "+this.actualChange);
        }
        else{
            System.out.println("You only can down change");
        }

    }
    public void downChange(){
        if(this.actualChange >0){
            this.actualChange--;
            System.out.println("the actual change is: "+this.actualChange);
        }
        else{
            System.out.println("You only can up change");
        }
    }
    public void PutReversed(){
        if(this.actualChange == 0 && this.speed == 0){
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "typeOfWheels: " + typeOfWheels +
                "color=" + color+
                "serial: " + serial +
                "plate: " + plate +
                "speed: " + speed +
                "bodyType: " + bodyType;
    }
}
