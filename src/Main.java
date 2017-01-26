/**
 * Created by ml996 on 1/23/17.
 */
import java.util.*;
import java.io.*;
public class Main {
    public static int arraySearch(String[][] a, int b, String t){
        for(int i = 0; i < a.length; i++){
            if(a[i][b].equalsIgnoreCase(t))
                return i;
        }
        return -1;
    }
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
                x = a[i]%(int)(Math.pow(16,j));
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
    public static String HTMLColors(boolean a, boolean b, String s, int[] m) throws IOException{ //false a=from HTML, true a = to HTML; false b = RGB, true b = HEX
        File f = new File("HTML_colors.txt");
        Scanner scan = new Scanner(f);
        scan.useDelimiter("\\s+");
        String[][] htmlcolors = new String[140][3];
        for(int i = 0; i < htmlcolors.length; i++){
            for(int j = 0; j < htmlcolors[0].length; j++){
                htmlcolors[i][j] = scan.next().replace("#","");
            }
        }
        if(a){
            if(b){
                int n = arraySearch(htmlcolors, 1, s);
                if(n == -1)
                    return "-1";
                return htmlcolors[n][0];
            }
            else{
                String rgb = m[0] + "," + m[1] + "," + m[2];
                int n = arraySearch(htmlcolors, 2, rgb);
                if(n == -1)
                    return "-1";
                return htmlcolors[n][0];
            }
        }
        else{
            if(b){
                int n = arraySearch(htmlcolors, 0, s);
                if(n == -1)
                    return "-1";
                return htmlcolors[n][1];
            }
            else{
                int n = arraySearch(htmlcolors, 0, s);
                if(n == -1)
                    return "-1";
                return "(" + htmlcolors[n][2] + ")";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Color Converter!");
        loop1:while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("What would you like to convert from? Please enter 1, 2, or 3 \n (1) RGB\n (2) HEX\n (3) HTML Name");
            String n1 = sc.nextLine();
            System.out.println("What would you like to convert to? Please enter 1, 2, or 3 \n" + " (1) RGB\n" + " (2) HEX\n" + " (3) HTML Name");
            String n2 = sc.nextLine();
            switch (n1 + n2) {
                case "12":
                    System.out.println("Enter the RGB triplet.");
                    int[] rgb = new int[3];
                    sc.useDelimiter("\\D+");
                    for (int i = 0; i < 3; i++) {
                        rgb[i] = sc.nextInt();
                    }
                    System.out.println("Color in hex: " + rgbToHex(rgb));
                    break;
                case "13":
                    System.out.println("Enter the RGB triplet.");
                    int[] rgb2 = new int[3];
                    sc.useDelimiter("\\D+");
                    for (int i = 0; i < 3; i++) {
                        rgb2[i] = sc.nextInt();
                    }
                    String htmlC = HTMLColors(true, false, "", rgb2);
                    if (htmlC.substring(0, 1).equals("-")) {
                        System.out.println("This color does not have an HTML name.");
                    } else {
                        System.out.println("Color in HTML: " + htmlC);
                    }
                    break;
                case "21":
                    System.out.println("Enter the 6 digit HEX number.");
                    String h = sc.nextLine();
                    h.replace("#", "");
                    int[] r = hexToRgb(h);
                    System.out.println("Color in rgb: " + "(" + r[0] + ", " + r[1] + ", " + r[2] + ")");
                    break;
                case "23":
                    System.out.println("Enter the 6 digit HEX number.");
                    String hex2 = sc.nextLine();
                    hex2.replace("#", "");
                    String htmlC2 = HTMLColors(true, true, hex2, new int[]{0});
                    if (htmlC2.substring(0, 1).equals("-")) {
                        System.out.println("This color does not have an HTML name.");
                    } else {
                        System.out.println("Color in HTML: " + htmlC2);
                    }
                    break;
                case "31":
                    while (true) {
                        System.out.println("Enter the HTML name of the color.");
                        String name = sc.nextLine().replace("\\s+", "").toLowerCase();
                        String rgb3 = HTMLColors(false, false, name, new int[]{});
                        if (rgb3.substring(0, 1).equals("-"))
                            System.out.println("Invalid name. Try again.");
                        else {
                            System.out.println("Color in rgb: " + rgb3 );
                            break;
                        }
                    }
                    break;
                case "32":
                    while (true) {
                        System.out.println("Enter the HTML name of the color.");
                        String name2 = sc.nextLine().replace("\\s+", "").toLowerCase();
                        String hex3 = HTMLColors(false, true, name2, new int[]{});
                        if (hex3.substring(0, 1).equals("-"))
                            System.out.println("Invalid name. Try again.");
                        else {
                            System.out.println("Color in HEX: " + hex3);
                            break;
                        }
                    }
                    break;
                case "11":
                case "22":
                case "33":
                    System.out.println("You are already in that color system.");
                    break;
                default:
                    System.out.println("Invalid response. 1, 2, or 3. Try again.");
                    sc.nextLine();
            }
            Scanner sc2 = new Scanner(System.in);
            System.out.println("\nWould you like to do another? (Type Y to continue, type anything else to stop)");
            String yn = sc2.nextLine();
            if(!yn.substring(0,1).equalsIgnoreCase("Y")){
                break loop1;
            }
        }
    }
}
