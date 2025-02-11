import com.example.logger.A;
import com.example.logger.B;
import com.example.logger.Named;
import com.test.Root;

public class Main {
  public static void main(String[] args) {
   Root root = new Root();
   Named named = new Named();
   A a = new A();
   B b = new B();

    System.out.println("\t\tROOT:");
   root.log(); // in CONSOLE with ROOT Suffix
    System.out.println("\n\t\tNAMED:");
    System.out.println("\tINFO:");
   named.log(); // in CONSOLE with IT's NAMED!!!! Suffix
    System.out.println("\tERROR:");
   named.logError(); // in CONSOLE with IT's NAMED!!!! Suffix
    System.out.println("\n\t\tA:");
   a.log();  // SIMPLE CONSOLE
    System.out.println("\n\t\tB:");
   b.log(); //File
  }
}
