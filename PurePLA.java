import java.util.*;
import java.io.*;
import java.lang.*;
public class PurePLA {
	
	public static void main(String[] args)
	{
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(System.currentTimeMillis() + " PurePLA.gcode", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		for(int i = 0; i < 2; i++)
		{
			//set initial parameters
			double gap = 0.1;
			double heightGap = 0.3;
			double height = 1.5;
			double X = 10.0;
			double Y = 90.0;
			double Z = 0.0;
			double E = 0.0;
			double width = 50.0;
			double length = 20.0;
			double diam = 0.3;
			double transitionHeight = 5.0;
			double startingHeight = 0.3;
			boolean toggle = true;
			Z = startingHeight;
			if(i == 1)
			{
				X = 60.0;
				diam = 0.2;
			}
			if(i == 2)
			{
				X = 110.0;
				diam = 1.0;
			}
			
			writer.println("M107");
			//writer.println("G0 X" + X + " Y" + Y + " Z" + Z);
			
			Z += transitionHeight;
			writer.println("G10");
			writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Y = 90;
			writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Z -= transitionHeight;
			writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			writer.println("G11");
			
			for(Z = startingHeight; Z <= height + startingHeight; Z += heightGap)
			{
				Z += transitionHeight;
				writer.println("G10");
				writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
				Y = 90;
				writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
				Z -= transitionHeight;
				writer.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
				writer.println("G11");
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
		}
		
		writer.close();
		System.exit(0);
	}
}
