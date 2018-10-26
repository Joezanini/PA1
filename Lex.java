
import java.util.*;
import java.io.File;
import java.io.*;

public class Lex {
	public static void main(String[] args) throws IOException {
		int n = 0;
		int i, j;
		Scanner input = null;
		PrintWriter output = null;
		String temp, f, b = null;
		
		//checks for correct argument 
		if (args.length != 2) { 
			System.err.println("EXIT");
			System.exit(1);
		} 
		
		//scans input file
		input = new Scanner(new File(args[0])); 
		
		//counts line for string conversion
		while(input.hasNextLine()) {
			n++;
			input.nextLine(); 
		}
		
		String[] read = new String[n];
		
		input = new Scanner(new File(args[0]));
		output = new PrintWriter(new File(args[1]));
		n = 0;
		
		//string array
		while(input.hasNextLine()) {
			read[n] = input.nextLine(); 
			n++;
		}
		
		List l = new List();
		
		l.append(0);
		
		
		for (i = 0; i < n; i++) {
			temp = read[i];
			f = read[l.front()];
			b = read[l.back()];
			if (temp.compareTo(f) < 0) {
				l.prepend(i);
			} else if (temp.compareTo(b) > 0) {
				l.append(i);
			} else {
				l.moveFront();
				j = l.length();
				while (j > 0) {
					if (temp.compareTo(read[l.get()]) < 0) {
						l.insertBefore(i);
						j = 0;
					} else {
						l.moveNext();
						j--;
					}
				}
			}
		}
		
		//now read to a output.txt
		l.moveFront();
		for (i = 0; i < n; i++) {
			output.println(read[l.get()]);
			l.moveNext();
		}
		output.close();
	}
}
