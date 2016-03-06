package com.nitin;

/**
 * Created by Nitin C on 3/5/2016.
 */
public class VirtualMethod {
    public static void main(String[] args) {
        Animal bird = new Bird();
        bird.feedAnimal(bird);
    }
}

abstract class Animal{
    public abstract void feed();

    public void feedAnimal(Animal animal){
        animal.feed();
    }
}

class Cow extends Animal{
    @Override
    public void feed(){
        addHay();
    }

    private void addHay() {
        System.out.println("Cow eats Hay!!");
    }
}

class Lion extends Animal {
    @Override
    public void feed() {
        addMeat();
    }

    private void addMeat() {
        System.out.println("Lion  eats Meat");
    }
}

class Bird extends Animal{
    @Override
    public void feed() {
        addSeed();
    }

    private void addSeed() {
        System.out.println("Little baby bird eats Seed");
    }
}