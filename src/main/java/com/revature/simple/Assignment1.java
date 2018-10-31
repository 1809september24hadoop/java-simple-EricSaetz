package com.revature.simple;

import org.apache.log4j.Logger;

import com.revature.simple.Assignment1;

import java.util.Stack;

public class Assignment1 implements JavaSimple {
	
	private static final Logger LOGGER = Logger.getLogger(Assignment1.class);
	
	public static void main(String args[]) {
		new Assignment1();
	}
	
	public Assignment1() {
		//check if isPrime is working
		LOGGER.info(isPrime(0));
		
		//check if rotateLeft is working
		int[] array = {1,2,3,4,5};
		array = rotateLeft(array,2);
		for (int n:array) {
			LOGGER.info(n);
		}
		
		//check if balancedBrackets works
		LOGGER.info(balancedBrackets("[({{}})]"));
		
		//check if isEven works
		LOGGER.info(isEven(6));
		LOGGER.info(isEven(7));
		
		//check if sort works
		sort(array);
		for (int n:array) {
			LOGGER.info(n+" ");
		}
		
		//check if max works
		LOGGER.info(max(array));
		
		//check if fibbonaci works
		LOGGER.info(fibonacci(5));
		
		//check if factorial works
		LOGGER.info(factorial(5));
		
	}

	@Override
	public int castToInt(double n) {
		return (int)n;
	}

	@Override
	public byte castToByte(short n) {
		return (byte)n;
	}

	@Override
	public double divide(double operandOne, double operandTwo) throws IllegalArgumentException {
		if (operandTwo==0)
			throw new IllegalArgumentException("Cannot Divide by 0");
		return (operandOne/operandTwo);
	}

	@Override
	public boolean isEven(int n) {
		return (double)n/2.0==Math.floor((double)n/2.0);
	}

	@Override
	public boolean isAllEven(int[] array) {
		for (int n=0;n<array.length;n++) {
			if (!isEven(array[n]))
				return false;
		}
		
		return true;
	}

	@Override
	public double average(int[] array) throws IllegalArgumentException {
		
		if (array==null)
			throw new IllegalArgumentException("array is null)");
		else if (array.length==0)
			return 0;
		
		double average=0;
		
		for (int n=0;n<array.length;n++) {
			average+=array[n];
		}
		
		average=average/array.length;
		
		return average;
	}

	@Override
	public int max(int[] array) throws IllegalArgumentException {
		int max = array[0];
		for (int n=0;n<array.length;n++) {
			if (max<array[n])
				max=array[n];
		}
		
		return max;
	}

	@Override
	public int fibonacci(int n) throws IllegalArgumentException {
		if (n<0)
			throw new IllegalArgumentException("Value cannot be < 0");
		else if (n==0)
			return 0;
		else if (n<=2)
			return 1;
		else
			return fibonacci(n-1)+fibonacci(n-2);
	}

	@Override
	public int[] sort(int[] array) throws IllegalArgumentException {
		int temp;
		int min = 0;
		for (int currentNum=0;currentNum<array.length;currentNum++) {
			min = currentNum;
			for (int n=currentNum;n<array.length;n++) {
				if (array[n]<array[min])
					min=n;
			}
			temp=array[currentNum];
			array[currentNum] = array[min];
			array[min]=temp;
		}
		
		return array;
	}

	@Override
	public int factorial(int n) throws IllegalArgumentException {
		if (n<0)
			throw new IllegalArgumentException("n cannot be less than 0");
		
		if (n==1)
			return 1;
		else
			return factorial(n-1)*n;
	}

	@Override
	public int[] rotateLeft(int[] array, int n) throws IllegalArgumentException {
		if (n<0 || array==null)
			throw new IllegalArgumentException("Invalid Parameters");
		
		int[] newArray = new int[array.length];
		
		for (int m=0;m<array.length;m++) {
			newArray[m] = array[(m+n)%array.length];
		}
		
		return newArray;
	}

	@Override
	public String isPrime(int n) throws IllegalArgumentException {
		if (n<0)
			throw new IllegalArgumentException("n cannot be less than 0");
		
		int m;
		for (m=2;n%m!=0 && n>1;m++);
		return (m==n || n==1 || n==0) ? "Is Prime" : "Is Not Prime";
	}

	@Override
	public boolean balancedBrackets(String brackets) throws IllegalArgumentException {
		if (brackets==null)
			throw new IllegalArgumentException("String cannot be null");
		
		Stack stack = new Stack();
		
		for (int n=0;n<brackets.length();n++) {
			if (brackets.charAt(n)=='(' || brackets.charAt(n)=='{' || brackets.charAt(n)=='[') {
				stack.push(brackets.charAt(n));
			}
			else if (brackets.charAt(n)==')' && (char)stack.pop()!='(') {
				return false;
			}
			else if (brackets.charAt(n)=='}' && (char)stack.pop()!='{') {
				return false;
			}
			else if (brackets.charAt(n)==']' && (char)stack.pop()!='[') {
				return false;
			}
		}
		
		return true;
	}
}