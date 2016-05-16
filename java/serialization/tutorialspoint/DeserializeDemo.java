import java.io.*;
public class DeserializeDemo
{
    public static void main(String [] args)
    {
        SerialObject e = null;

        try {
            FileInputStream fileIn = new FileInputStream("/tmp/serialobject.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (SerialObject) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i) {
            i.printStackTrace();
            return;
        }
        catch(ClassNotFoundException c) {
            System.out.println("SerialObject class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized SerialObject...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}