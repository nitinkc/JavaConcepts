package java7.a4coreJavaAPI.arrays;

/**
 * Created by nitin.chaurasia on 12/27/2016.
 */
public class L2Arrays2DRectangular {
    public static void main(String[] args) {
        String[][] arr = new String[3][3];
        int row = arr.length;// Row = 6
        int col = arr[0].length; // Columns = 7
        for (int i = 0; i < row; i = i + 1) {
            for (int j = 0; j < col; j = j + 1) {
                arr[i][j] = i + "" + j + " ";
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
