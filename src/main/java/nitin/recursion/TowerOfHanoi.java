package nitin.recursion;

public class TowerOfHanoi {
    static int count = 1;

    public static void main(String[] args) {
        int n = 3;
        //towerOfHanoi(n, "A", "B", "Temp");
        towerOfHanoiZeroBase(n, "A", "B", "Temp");
    }

    private static void towerOfHanoi(int n, String start, String end, String temp) {
        if(n == 1) {
            System.out.println("Move disk 1 from " + start + " to " + end + " :: move = " + count++);
        }else {
            towerOfHanoi(n-1, start, temp, end);
            System.out.println("Move disk from " + start + " to " + end + " :: move = " + count++);
            towerOfHanoi(n-1,temp, end, start);
        }
    }

    private static void towerOfHanoiZeroBase(int n, String start, String end, String temp) {
        if(n == 0) {
            return;
        } else {
            towerOfHanoiZeroBase(n-1, start, temp, end);
            System.out.println("Move disk from " + start + " to " + end + " :: move = " + count++);
            towerOfHanoiZeroBase(n-1,temp, end, start);
        }
    }
}