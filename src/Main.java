/**
 * Created by ml996 on 1/23/17.
 */
import java.util.Scanner;
public class Main {
    public static String rgbToHex(int[] a){
        String hex = "";
        for(int i = 0; i < 3; i++){
            int x = a[i];
            for(int j = 1; j >= 0; j--){
                x = x / ((int)(Math.pow(16,j)));
                if(x > 9)
                    hex += (char)(55+x);
                else
                    hex += x;
                x = x%(int)(Math.pow(16,j));
            }
        }
        return hex;
    }
    public static int[] hexToRgb(String s){
        int[] a = new int[3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                int x = s.charAt(2*i + j);
                if(x>=65)
                    a[i] += (x - 55) * (int)(Math.pow(16, 1-j));
                else
                    a[i] += x * (int)(Math.pow(16,1-j));
            }
        }
        return a;
    }
    /*
    public static String rgbToHTML(int[] a){

    }
    public static String hexToHTML(String s){

    }
    public static int[] HTMLtoRgb(String h){

    }
    public static String HTMLtoHex(String h){

    }*/
    public static void main(String[] args){
        
    }
}
