package miniMathematica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		MiniMathematica calculator = new MiniMathematica();

		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String expression = line;
				Double result = calculator.calculate(expression);
				bw.write(String.valueOf(result));
				bw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				String expression = scanner.nextLine();
				if (expression.equals("quit")) {
					break;
				}
				Double result = calculator.calculate(expression);
				System.out.println("Result:" + result);
			}
		}
	}
}
