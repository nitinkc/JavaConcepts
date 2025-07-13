package nitin.arrays;

/** Created by nitin.chaurasia on 12/27/2016. */
public class L3Arrays2DSkewed {
    public static void main(String[] args) {
        String[][] arr = new String[3][];
        arr[0] = new String[3]; // 3 columns
        arr[1] = new String[2]; // 2 columns
        arr[2] = new String[5]; // 5 columns

        int[][] a = {{1, 23, 3}, {1, 2}};

        for (int i = 0; i < arr.length; i = i + 1) {
            // each row has a diff column
            for (int j = 0; j < arr[i].length; j = j + 1) {
                // NOTICE: arr[i].length
                arr[i][j] = i + "" + j + " ";
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("Printing 2D skewed declared and initialized together");
        for (int i = 0; i < a.length; i = i + 1) {
            // each row has a diff column
            for (int j = 0; j < a[i].length; j = j + 1) {
                // NOTICE: arr[i].length
                System.out.print(a[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
