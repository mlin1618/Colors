/**
 * Created by ml996 on 1/23/17.
 */
import java.util.*;
import java.io.*;
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
                if(x>=65 && x <=70)
                    a[i] += (x - 55) * (int)(Math.pow(16, 1-j));
                else
                    a[i] += (x - 48) * (int)(Math.pow(16,1-j));
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
    public static void main(String[] args) throws IOException{
        File f = new File("HTML_colors.csv");
        Scanner scan = new Scanner(f);
        String[][] htmlcolors = new String[140][3];
        for(int i = 0; i < htmlcolors.length; i++){
            for(int j = 0; j < htmlcolors[0].length; j++){
                htmlcolors[i][j] = scan.next();
            }
        }
        System.out.println("Welcome to the Color Converter!\n What would you like to convert from? Please enter 1, 2, or 3 \n (1) RGB\n(2) HEX\n (3) HTML Name");
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        System.out.println("What would you like to convert to? Please enter 1, 2, or 3 \n" + " (1) RGB\n" + "(2) HEX\n" + " (3) HTML Name");
        String n2 = sc.nextLine();
        switch(n1+n2){
            case "12":
                break;
            case "13":
                break;
            case "21":
                break;
            case "23":
                break;
            case "31":
                break;
            case "32":
                break;
        }
    }
}
