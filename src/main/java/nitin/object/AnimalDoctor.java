package nitin.object;

abstract class Animal {
    public abstract void checkup();
}

class Dogs extends Animal {
    public void checkup() {
        System.out.println("Dog Checkup");
    }
}

class Cats extends Animal {
    public void checkup() {
        System.out.println("Cat Checkup");
    }
}

class Bird extends Animal {
    public void checkup() {
        System.out.println("Bird Checkup");
    }
}

public class AnimalDoctor {
    public void checkAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.checkup();
        }
    }

    public static void main(String[] args) {
        Dogs[] dog = {new Dogs(), new Dogs()};
        Bird[] bird = {new Bird(), new Bird(), new Bird()};
        Cats[] cat = {new Cats()};

        AnimalDoctor rinkoo = new AnimalDoctor();
        rinkoo.checkAnimals(cat);
        rinkoo.checkAnimals(bird);
        rinkoo.checkAnimals(dog);
    }

}
