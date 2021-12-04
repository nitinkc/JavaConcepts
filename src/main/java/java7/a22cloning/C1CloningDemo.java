package java7.a22cloning;

/**
 * Created by Nitin Chaurasia on 12/4/15 at 1:49 AM.
 */
public class C1CloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Stock obj = new Stock(560, " google");
        Stock obj1 = new Stock(560, " google");

        // Clone returns Object Type
        Stock s = (Stock) obj.clone();
        System.out.println(obj.name + "   " + obj.price);
        System.out.println(s.name + "  " + s.price);

    }
}

/**
 * If the Cloneable Interface is not implemented it throws CloneNotSupportedException
 */

class Stock implements Cloneable
{
    int price;
    String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Constructor
    public Stock(int price, String name) {
        super();
        this.price = price;
        this.name = name;
    }

    // Compulsory Implemrntation
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

}