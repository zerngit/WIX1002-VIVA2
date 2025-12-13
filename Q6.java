package WIX1002_VIVA_2;

import java.util.Scanner;

public class Q6 {

    
    public static boolean isMirror(int[] a, int[] b) {

        int[] aRev = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            aRev[i] = a[a.length-1-i];
        }

        if (aRev.length != b.length) {
            return false;
        }

        for (int i = 0; i < aRev.length; i++) {
            if (aRev[i] != b[i]) {
                return false;
            }
        }

        return true;
        
    }
    
    /*public static boolean isMirror(int[] a, int[] b) {

        // Convert arrays A and array B to strings
        String aStr = "";
        String bStr = "";

        for (int i = 0; i < a.length;i++) {
            aStr += a[i];
            bStr += b[i];
        }
        
        // Reverse string aStr and compare with bStr
        // Introducing StringBuilder for reversing the string
        // since String is immutable in Java
        // so we cannot reverse it directly
        // StringBuilder provides a mutable sequence of characters
        // and has a reverse() method to reverse the sequence
        // Finally convert it back to String using toString() method

        String aRev = new StringBuilder(aStr).reverse().toString();
        return aRev.equals(bStr);
    }
    */
    public static void main(String[]args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Array A: ");

        String lineA = sc.nextLine();
        String [] partsA = lineA.split(",");
        int [] a = new int[partsA.length];
        for (int i = 0; i < partsA.length; i++) {
            a[i] = Integer.parseInt(partsA[i].trim());
        }
        
        System.out.print("Array B: ");
        String lineB = sc.nextLine();
        String [] partsB = lineB.split(",");
        int [] b = new int[partsB.length];
        for (int i = 0; i < partsB.length; i++) {
            b[i] = Integer.parseInt(partsB[i].trim());
        }

        System.out.println("Mirror Pattern: " + isMirror(a,b));
    }
}