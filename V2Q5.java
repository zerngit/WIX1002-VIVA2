/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2;
import java.util.Scanner;
/**
 *
 * @author Hong Han
 */
public class V2Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        char mode;
        do{
            System.out.print("Mode (C/D): "); //read mode of operation ('C' for Compress, 'D' for Decompress
            mode = sc.next().charAt(0);
            sc.nextLine();
        } while(mode != 'C' && mode!='D');
        
        System.out.print("Text: "); //read text
        String text = sc.nextLine();
        
        if (mode == 'C'){
            System.out.println("Result: " + compress(text));
        }
        else{
            System.out.println("Result: " + decompress(text));
        }

    }
    
    public static String compress(String s){
        int count = 1; //by default a character occurs once
        String compressed = "";
        for (int i = 0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){ 
                count ++; //increase count if consecutive characters are the same
            }
            else{
                compressed = compressed + count + s.charAt(i); //append count and the character to the compressed string once a different character is detected
                count = 1; // reset count for new character
            } 
        }
        compressed = compressed + count + s.charAt(s.length()-1); //append final count and final character to the compressed string 
        return compressed;
    }
    
    public static String decompress(String s){
        for (int i = 0; i<s.length()-1; i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'
                &&    
                s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){ //check validity (2 numbers can't be next to each other)
                return "Invalid encoding";
            }    
        }
        
        int count;
        String decompressed = "";
        String repeated;
        for (int i = 0; i<s.length()-1; i+=2){
            count = s.charAt(i) - '0';
            repeated = String.valueOf(s.charAt(i+1)).repeat(count);//repeat character based on count
            decompressed = decompressed + repeated; //append repeated characters to the decompressed string
        }
        return decompressed;
    }
    
}
