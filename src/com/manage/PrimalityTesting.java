package manage;

public class PrimalityTesting {

	public static void main(String[] args) {
		int n = 100000000;
		
		for (int i=2;i<=Math.sqrt(n);i++){
			while (n%i == 0){
				System.out.println("Factor is " + i);
				n /= i;				
			}
		}
		if (n>1)				
			System.out.println("Factor is " + n);
	}

}
