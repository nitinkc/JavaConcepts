package nitin.nestedClasses.innerClass;

/**
 * Created by nitin on 1/14/16.
 * Anonymous Inner Class is a local inner class that does not have a name
 * Inner Class can only be accessed only through live instance of outer class
 */


interface Demo{
    void show();
}

public class I3AnonymousClassDemo {
    public void data() {
        System.out.println("Outer Class");
    }

    public static void main(String[] args) {

        Demo demo = new Demo(){//Anonymous Class
            public void show() {
                System.out.println("Show from Anonymous class...");
            }
        };

        I3AnonymousClassDemo ref=new I3AnonymousClassDemo(){//Anonymous inner Class
            public void data() {
                System.out.println("Anonymous Inner Class...");
            }
            public void display(){
                System.out.println("Display of Outer...");
            }
        };
        ref.data();
        demo.show();
    }
}
