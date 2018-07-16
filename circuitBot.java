import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class circuitBot {
	
	public static void main(String[] args) {

		//set initial parameters
		double X = 5.0;
		double Y = 150.0;
		double Z = 0.3;
		double E = 0.0;
		double length = 50.0;
		double transitionHeight = 5.0;
		
		//System.out.println("M106");
		System.out.println("G0 X" + X + " Y" + Y + " Z" + Z);
		System.out.println("G0 F1500");


		for(double i = 0; i <= 0.3; i+= 0.3) {

			length = 50.0;
			Y= 200.0;
			X = 5;
			Y -= i;
			Z = 0.3;
			length -= i;

			Z += transitionHeight;
			System.out.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Y = 90;
			System.out.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Z -= transitionHeight;
			System.out.println("G0 F0 X" + X + " Y" + (Y-i)+ " Z" + Z);



			///first wing 

			System.out.println("G0 F0 X" + (X-i) + " Y" + (Y+5)+ " Z" + Z);

			E += 0.1 * (5+i);

			//System.out.println("G1 F1500 X" + (X-i) + "Y" + (Y-i) + " Z" + Z + " E" + E);

			E += 0.1 * (i);

			System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-i)+ " Z" + Z + " E" + E);


			///main U
			E += 0.1 * (length);
			System.out.println("G1 F1500 X" + (X+length) + " Y" + (Y-i) + " Z" + Z + " E" + E);

			E += 0.1 * (length);
			System.out.println("G1 F1500 X" + (X+length) + " Y" + (Y-length) + " Z" + Z + " E" + E);

			E += 0.1 * (length);
			System.out.println("G1 F1500 X" + (X) + " Y" + (Y-length) + " Z" + Z + " E" + E);

			//last wing 
			E += 0.1 * (i);

			System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-length)+ " Z" + Z + " E" + E);

			E += 0.1 * (5);

			System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-length-5-i) + " Z" + Z + " E" + E);

		}

		/////////////////////// SECOND COPY /////////////////////// 


		for(double i = 0; i <= 0.3; i+= 0.3) {

			length = 50.0;
			Y= 200.0;
			X = 70;
			Y -= i;
			Z = 0.3;
			length -= i;

						Z += transitionHeight;
			System.out.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Y = 90;
			System.out.println("G0 F0 X" + X + " Y" + Y + " Z" + Z);
			Z -= transitionHeight;
			System.out.println("G0 F0 X" + X + " Y" + (Y-i)+ " Z" + Z);

			//System.out.println("br");


			///first wing thing

			System.out.println("G0 F0 X" + (X-i) + " Y" + (Y+5)+ " Z" + Z);

			E += 0.1 * (5+i);

			//System.out.println("G1 F1500 X" + (X-i) + "Y" + (Y-i) + " Z" + Z + " E" + E);

			//System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-i)+ " Z" + Z + " E" + E);

			E += 0.1 * (i);

			System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-i)+ " Z" + Z + " E" + E);

			//System.out.println("br1");

			///main U
			E += 0.1 * (length);
			System.out.println("G1 F1500 X" + (X+length) + " Y" + (Y-i) + " Z" + Z + " E" + E);

			E += 0.1 * (length);
			System.out.println("G1 F1500 X" + (X+length) + " Y" + (Y-length) + " Z" + Z + " E" + E);

			E += 0.1 * (length);
			System.out.println("G1 F1500 X" + (X) + " Y" + (Y-length) + " Z" + Z + " E" + E);

			//System.out.println("br2");

			//last wing thing
			E += 0.1 * (i);

			System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-length)+ " Z" + Z + " E" + E);

			E += 0.1 * (5);

			System.out.println("G1 F1500 X" + (X-i) + " Y" + (Y-length-5-i) + " Z" + Z + " E" + E);

		}

	}
}