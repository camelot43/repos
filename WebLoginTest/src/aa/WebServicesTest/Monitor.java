package aa.WebServicesTest;

import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 * Web Service End-point implementation class
 */
   
@WebService
public class Monitor {
   // Constructor
   public void Monitor() {}
   
   @WebMethod
   public String sayHello(String name) {
      return "Hello, " + name + ".";
   }
   
   @WebMethod
   public int addNumbers(int number1, int number2) {
      return number1 + number2;
   }
   
   @WebMethod
   public double divideNumbers(int dividend, int divisor)
         throws DivideNumbersException {
      if (divisor == 0) {
         throw new DivideNumbersException("Divisor cannot be zero!");
      }
      return (double)dividend/divisor;
   }
}
