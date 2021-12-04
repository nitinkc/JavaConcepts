package java7.a4declarationsNaccessModifiers;

/**
 * Created by Nitin Chaurasia on 12/29/16 at 12:51 AM.
 * Final is applicable for classes, methods and variables
 */
public class M1Final {

    static String finalString;
    public M1Final(String s) {
        finalString = s;
    }

    public void setM1Final(String s){
        finalString = s;
    }

    public String getM1Final(){
        return finalString;
    }

    public static void main(String[] args) {

        // If method is declared as final, then in Child Class, not allowed to over ride
        // If class is declared as final, we can't create child class.
           // Each method declared in Final class, is by default, final
           // Disadvantage : missing on OOPS Inheritance and Polymorphism

        final M1Final str = new M1Final ("Mahatma Gandhi");
        System.out.println("Final String is b_set to : "+ finalString);

        // CHANGING THE FINAL variable
        str.setM1Final("Modi");
        System.out.println("Final String is re-b_set to : "+ str.getM1Final());
    }

}
