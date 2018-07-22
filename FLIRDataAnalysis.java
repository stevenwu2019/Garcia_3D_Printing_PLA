import java.util.*;
import java.io.*;
import java.lang.*;

public class FLIRDataAnalysis {
	static Scanner input = null;
	static String file = "0.4x230Cinput.csv";
	public static void main(String[] args)
	{
		try {
			input = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		input.useDelimiter(",");
		
		int rows = 0;
		int cols = 0;
		String dummy = input.nextLine();
		Scanner incScan = new Scanner(dummy);
		incScan.useDelimiter(",");
		String increment = "";
		while(incScan.hasNext())
		{
			increment = incScan.next();
			cols++;
		}
		System.out.println(cols);
		try {
			input = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		input.useDelimiter(",");
		
		dummy = input.nextLine();
		incScan = new Scanner(dummy);
		incScan.useDelimiter(",");
		increment = incScan.next();
		increment = incScan.next();
		int inc = Integer.valueOf(increment.substring(0, 1));
		while(inc != 0)
		{
			dummy = input.nextLine();
			incScan = new Scanner(dummy);
			incScan.useDelimiter(",");
			increment = incScan.next();
			increment = incScan.next();
			inc = Integer.valueOf(increment.substring(0, 1));
			rows++;
		}
		
		int frames = 1;
		try {
			input = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		input.useDelimiter(",");
		
		dummy = input.nextLine();
		incScan = new Scanner(dummy);
		incScan.useDelimiter(",");
		increment = incScan.next();
		increment = incScan.next();
		inc = Integer.valueOf(increment.substring(0, 1));
		while(input.hasNextLine())
		{
			if(inc == 0) frames++;
			dummy = input.nextLine();
			incScan = new Scanner(dummy);
			incScan.useDelimiter(",");
			increment = incScan.next();
			increment = incScan.next();
			inc = Integer.valueOf(increment.substring(0, 1));
		}

		try {
			input = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		input.useDelimiter(",");
		
		String[][][] data = new String[frames][rows][cols]; 
		for(int i = 0; i < frames; i++)
		{
			for(int x = 0; x < rows; x++)
			{
				for(int y = 0; y < cols; y++)
				{
					if(input.hasNext()) data[i][x][y] = input.next();
					//System.out.println(y + " " + data[i][x][y]);
					//DON'T FORGET TO ADD COMMAS TO THE END OF EVERY LINE
				}
				//if(input.hasNextLine()) input.nextLine();
			}
			if(input.hasNextLine()) input.nextLine();
			if(input.hasNextLine()) input.nextLine();
		}
		
		System.out.println(rows + " " + cols + " " + frames);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(System.currentTimeMillis() + "0.4x230Coutput.csv", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int a = 0; a < rows; a++)
		{
			for(int b = 0; b < cols; b++)
			{
				for(int c = 0; c < frames; c++)
				{
					writer.print(data[c][a][b] + ",");
				}
				writer.println();
			}
		}
		writer.close();
		System.exit(0);
	}
}
