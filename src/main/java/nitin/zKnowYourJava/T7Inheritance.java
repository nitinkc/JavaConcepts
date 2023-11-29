package nitin.zKnowYourJava;

public class T7Inheritance {
    public static void main(String[] args) {
        try {
            new Derived("");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

class Base{
    public Base(){//Constructor
        System.out.println("In base");
        check();// The check of the Derived is called
    }
    public void check(){}
}

class Derived extends Base{
    private String value;
    public Derived(String value){
        System.out.println("In Derived");
        this.value = value;
    }

    @Override
    public void check(){
        if(value.length() == 0) {
            throw new RuntimeException("Null Value");
        }
    }
}