package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Product> products = new ArrayList<>();
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(strPath));
			
			String line = br.readLine();
			while(line != null) {
				String[] s = line.split(",");
				line = br.readLine();
				String name = s[0];
				double price = Double.parseDouble(s[1]);
				int amount = Integer.parseInt(s[2]); 
				products.add(new Product(name, price, amount));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		}

		
		File file = new File(strPath);
		String directory = file.getParent();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(directory +"\\summary.csv"));
			for (Product product : products) {
				bw.write(product.toString());
				bw.newLine();
			}
			
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Finish");
		
		
		
		sc.close();
	}
	
}
