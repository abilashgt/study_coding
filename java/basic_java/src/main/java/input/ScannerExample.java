package input;

import java.util.Scanner;


class ScannerExample {
    public static void main(String args[]){
        System.out.println("Enter an Integer:");
        int num = inputInt();

        System.out.println("Enter a String:");
        String line = inputString();

        System.out.println("Int: "+num + " - " + "String: "+line);
    }

    public static int inputInt(){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return num;
    }

    public static String inputString(){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        return line;
    }
}