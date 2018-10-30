package com.revature.simple;

import java.util.Stack;

public class Assignment1 implements JavaSimple {
	
	public static void main(String args[]) {
		new Assignment1();
	}
	
	public Assignment1() {
		int[] array = {1,2,3,4,5};
		System.out.println(isPrime(0));
		//System.out.println(rotateLeft(array,2));
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
		double num = (double)n/2.0;
		return num==Math.floor(num);
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
		
		int[] tempArray = new int[n];
		for (int i=0;i<array.length;i++) {
			if (i<n) {
				System.out.println(i + "  " + n + "  " + tempArray.length);
				tempArray[i]=array[i];
				array[i]=array[(i+n)%array.length];
			}
			else {
				array[i]=tempArray[i-n];
			}
			
		
		}
		return array;
	}

	@Override
	public String isPrime(int n) throws IllegalArgumentException {
		if (n<0)
			throw new IllegalArgumentException("n cannot be less than 0");
		
		int m;
		for (m=2;!isDivisible(n,m) && n>1;m++);
		
		return (m==n || n==1 || n==0) ? "Is Prime" : "Is Not Prime";
	}
	
	//checks whether n is evenly divisible by m
	public boolean isDivisible(int n,int m) {
		return n%m==0;
	
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
			else if (brackets.charAt(n)==')' || brackets.charAt(n)=='}' || brackets.charAt(n)==']') {
				if ((char)stack.pop()!=brackets.charAt(n))
					return false;
			}
		}
		
		return true;
	}
}