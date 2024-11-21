package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class SumTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strnum1, strnum2;
		strnum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", 
				"Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strnum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", 
				"Input the first number", JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strnum1);
		double num2 = Double.parseDouble(strnum2);
		double result = num1 + num2;
		JOptionPane.showMessageDialog(null, "The sum of two numbers: " + result);
	}

}
