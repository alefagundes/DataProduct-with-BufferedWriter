package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import entities.dataProduct;

public class Program {

	public static void main(String[] args) {
		
		List<dataProduct> list = new ArrayList<>();
		
		String pathSource = "C:\\temp\\prod.txt";
		
		File file = new File(pathSource);
		
		String folderPath = file.getParent();
		
		Boolean sucess = new File(folderPath + "\\out").mkdir();
		
		String targetFile = folderPath + "\\out\\Sumarry.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathSource))){
			String line = br.readLine();
			while(line!=null) {
				String[] filds = line.split(",");
				String name = filds[0];
				Integer quantity = Integer.parseInt(filds[1]);
				Double price = Double.parseDouble(filds[2]);
				list.add(new dataProduct(name, price, quantity));
				line = br.readLine();
				
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))){
				for(dataProduct prod : list) {
					bw.write(prod.getName() + "- total produtos: " + prod.getQuantity() + "- total Value: " + prod.total());
					bw.newLine();
				}
				
			}
			
			System.out.println("Created file sucess!");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
