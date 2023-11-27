package nitin.exceptionHandling;

public class E1BasicExceptions {
    public static void main(String[] args) {
        System.out.println(divide(10,0));
    }

    /**
     * Returns null if ArithmaticException
     * @param divident
     * @param divisor
     * @return
     */
    public static Integer divide(Integer divident, Integer divisor){

        Integer result = null;
       try{
           result = divident/divisor;
       }catch (ArithmeticException ae){
           System.out.println("Divisor cant be zero, thus returning null");
           System.out.println("Exception Thrown message is : " + ae.getMessage());
           //throw new RuntimeException(ae);
       }finally {
           System.out.println("This will always run");
       }

       // Final, Finally and Finalize : Durgasoft
        
        System.out.println("Continuing......");
       return result;
    }
}
