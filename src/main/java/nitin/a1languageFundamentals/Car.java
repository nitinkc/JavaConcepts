package nitin.a1languageFundamentals;

class LeftHandDrive {
    public static void m1() {
        System.out.println(" this is from static method of left hand drive class");

    }

    public void horn() {
    }

    public void run() {
    }

    public void drivingMode() {

        System.out.println(" this left hand drive");
    }

}

class RightHandDrive extends LeftHandDrive {
    public static void m1() {

        System.out.println(" this is from static method of right hand drive class");
    }

//	public  int drivingMode() {
//		System.out.println(" this is right hand drive");
//		return 1;
//	}

}

public class Car {

    public static void main(String[] args) {

        LeftHandDrive ld = new LeftHandDrive();
        LeftHandDrive ld1 = new RightHandDrive();
        ld.drivingMode(); // relating a method to a method call
        ld1.drivingMode();
        LeftHandDrive.m1();
        LeftHandDrive.m1();

    }
}
