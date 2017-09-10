package tools.key_generator.random;

import java.util.UUID;
import java.math.BigInteger;

class Random {
  public static void main(String args[]){
    SessionIdentifierGenerator gen = new SessionIdentifierGenerator();
    String id = gen.nextSessionId();
    System.out.println("id = " + id);

    String secret = UUID.randomUUID().toString();
    System.out.println("uuid = " + secret);

    System.out.println("\nHEX:");
    System.out.println(toHex(id));
    System.out.println(toHex(secret));
  }

  public static String toHex(String arg) {
    return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
  }
}

