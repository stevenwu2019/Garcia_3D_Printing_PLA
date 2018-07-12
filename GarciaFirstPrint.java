import java.util.*;
import java.io.*;
import java.lang.*;
public class GarciaFirstPrint {
	
	public static void main(String[] args)
	{
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(System.currentTimeMillis() + "GarciaFirstPrint.gcode", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set initial parameters
		double gap = 0.1;
		double heightGap = 0.6;
		double height = 1.8;
		double X = 2.0;
		double Y = 90.0;
		double Z = 0.0;
		double E = 0.0;
		double width = 50.0;
		double length = 20.0;
		double diam = 0.5;
		double transitionHeight = 5.0;
		boolean toggle = true;
		
		writer.println("M106");
		writer.println("G0 X" + X + " Y" + Y + " Z" + Z);
		writer.println("G0 F1500");
		for(Z = 0.3; Z <= height + 0.3; Z += heightGap)
		{
			Z += transitionHeight;
			writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Y = 90;
			writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Z -= transitionHeight;
			writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			for(Y = 90; Y <= width + 90; Y += gap + diam)
			{
				E += 0.1 * (gap + diam);
				writer.println("G1 F1500 X" + X + " Y" + Y + " Z" + Z + " E" + E);
				if(toggle)
				{
					X += length;
				}
				else
				{
					X -= length;
				}
				E += 0.1 * length;
				writer.println("G1 F1500 X" + X + " Y" + Y + " Z" + Z + " E" + E);
				toggle = !toggle;
			}
		}
		writer.println();
		writer.close();
		System.exit(0);
	}
}
