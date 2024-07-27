package nitin.recursion;

public class PrintDigitChar {
    public static void main(String[] args) {
        int n = 532164327;
        System.out.println(n);
        //printDigitCharZeroBase(5321);
        printDigitChar(n);
    }

    private static void printDigitCharZeroBase(int i) {
        if (i == 0) {
            return;
        }
        printDigitCharZeroBase(i / 10);
        printCharNumber(i);
    }

    private static void printDigitChar(int n) {
        if (n < 10) {
            printCharNumber(n);
        }
        printDigitCharZeroBase(n / 10);
        printCharNumber(n);
    }

    private static void printCharNumber(int i) {
        char x = (char) ('0' + i % 10);
        System.out.println(x);
    }
}
