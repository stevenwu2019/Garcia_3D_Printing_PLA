import java.util.*;
import java.io.*;
import java.lang.*;


/**
 * @author Derek Zheng
 * @version 7/20/2018
 * >> reads in a file with doubles separated by commas,
 */

public class reader{
    
    Scanner keyboard;
    public static snap[] video;
    public static int rows, cols, time;
    
    
    public reader() {
        keyboard = openToRead("reader.input");
        //keyboard.useDelimiter(",");
        
        //System.out.println("rows, column, time");
        
        rows = keyboard.nextInt();
        //System.out.println("ONEONE " + rows);

        cols = keyboard.nextInt();
        //System.out.println("TWOTWO " + cols);

        time = keyboard.nextInt();
        //System.out.println("THREETHREE " + time);

        video = new snap[time];
        //System.out.println("aiya");

        for(int t = 0; t < time; t++) {
            //System.out.println("new time");

            double [][] temp = new double [rows][cols];
            for(int i = 0; i < rows; i++) {
                //System.out.println("new row");

                for(int n = 0; n < cols; n++) {
                    //System.out.println("new column");

                    temp[i][n] = (double) keyboard.nextDouble();
                }
            }
            video[t] = new snap(temp);
        }
    }
    
    public static void main (String[] args) {
        reader r = new reader();
        //System.out.println("onto printing");
        r.pixelPrinter();
    }
    
    public static void pixelPrinter() {                                     //prints all pixels from top left to bottom right, over time
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                for(int t = 0; t < time; t++) {
                    System.out.print(video[t].getPixel(row,col) + " ");         //prints in a vertical column
                }
                System.out.println();                                  //will separate the indiv pixels over time
            }
        }
    }
    
    public static Scanner openToRead(String fileName) {
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.err.println("ERROR: Cannot Open" + fileName
                               + "for reading.");
            System.exit(32);
        }
        return input;
    }
}

class snap {                                                                //represents a single csv, a snap over time.
    public double[][] pixels;
    
    public snap(double[][] arr) {
        pixels = new double[arr.length][arr[0].length];
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                pixels[i][j] = arr[i][j];
            }
        }
    }
    
    public double getPixel(int row, int col) {
        return pixels[row][col];
    }
}

