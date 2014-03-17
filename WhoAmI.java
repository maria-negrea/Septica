package chatS;

import java.net.*;

public class WhoAmI {
  public static void main(String[] args) 
      throws Exception {
//	  args[0]=new String("Kandinsky");
//    if(args.length != 1) {
//      System.err.println(
//        "Usage: WhoAmI MachineName");
//      System.exit(1);
//    }
    InetAddress a = 
      InetAddress.getByName("Kandinsky");
    System.out.println(a);
    System.out.println("Afara bate vantul!);
    System.out.println("Bla bla bla");
  }
}
