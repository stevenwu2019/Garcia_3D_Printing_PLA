import java.util.*;
import java.io.*;
import java.lang.*;
public class DataCompiler {
	static Scanner input = null;
	static String file = null;
	static PrintWriter writer = null;
	static int numFiles = 25;
	public static void main(String[] args)
	{
		try {
			writer = new PrintWriter(System.currentTimeMillis() + "0.4x230Cinput.csv", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < numFiles; i++) //set num of files
		{
			file = "0.4x230C_" + i + ".csv";
			try {
				input = new Scanner(new FileInputStream(file));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			input.useDelimiter(",");
			
			while(input.hasNextLine())
			{
				writer.print(input.nextLine());
				writer.println(",");
			}
			if(i != numFiles - 1) writer.println("0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00");
			
		}
		writer.close();
		System.exit(0);
			
		
	}
}
