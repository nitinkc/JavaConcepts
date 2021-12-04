package java7.a10collections.a_list.ArrayList;


import java.util.ArrayList;
import java.util.List;

public class ArrayListModification {
    public static void main(String[] args) {

        List<ListInteger> list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(new ListInteger(i));
        }

        for (ListInteger a :
                list) {
            System.out.print(a.getA() + "\t");
        }

        for (int i = 0; i < list.size(); i++) {
            if(i == 5)
                list.get(i-4).setA(i*2);
        }

        System.out.println();
        for (ListInteger a :
                list) {
            System.out.print(a.getA() + "\t");
        }
    }
}

class ListInteger{
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public ListInteger(int a) {
        this.a = a;
    }
}
