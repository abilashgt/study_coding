import java.io.*;

public class SerializeDemo
{
    public static void main(String [] args)
    {
        SerialObject e = new SerialObject();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        try {
          FileOutputStream fileOut = new FileOutputStream("/tmp/serialobject.ser");
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(e);
          out.close();
          fileOut.close();
          System.out.printf("Serialized data is saved in /tmp/serialobject.ser");
        }
        catch(IOException i) {
           i.printStackTrace();
        }
    }
}