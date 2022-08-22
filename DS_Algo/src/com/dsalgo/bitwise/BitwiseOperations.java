package com.dsalgo.bitwise;

public class BitwiseOperations {

	public static void main(String[] args) {

		BitwiseOperations obj = new BitwiseOperations();

		int a = 5;
		int b = 7;

//		obj.bitwiseAND(a, b);
//		obj.bitwiseOR(a, b);
//		obj.bitwiseXOR(a, b);
//		obj.leftShift(a, 1);
//		obj.rightShift(a, 1);
//		obj.bitWiseNOT(a);

		/*
		 * The & operator can be used to quickly check if a number is odd or even. The
		 * value of expression (x & 1) would be non-zero only if x is odd, otherwise the
		 * value would be zero.
		 */
		System.out.println(23 ^ 2);
		
	}

	/**
	 * Takes two numbers as operands and does AND on every bit of two numbers. The
	 * result of AND is 1 only if both bits are 1 </br>
	 * ex:- 5 & 7 </br>
	 * 
	 * binary representation 5 = 101 , 7 = 111 </br>
	 * 5 & 7 --> 101 AND 111 --> 101
	 * 
	 * @param num1
	 * @param num2
	 */
	public void bitwiseAND(int num1, int num2) {
		System.out.println(num1 & num2);
	}

	/**
	 * Takes two numbers as operands and does OR on every bit of two numbers. The
	 * result of OR is 1 if any of the two bits is 1. </br>
	 * ex:- 5 | 7 </br>
	 * 
	 * binary representation 5 = 101 , 7 = 111 </br>
	 * 
	 * 5 | 7 --> 101 OR 111 --> 111
	 * 
	 * @param num1
	 * @param num2
	 */
	public void bitwiseOR(int num1, int num2) {
		System.out.println(num1 | num2);
	}

	/**
	 * Takes two numbers as operands and does XOR on every bit of two numbers. The
	 * result of XOR is 1 if the two bits are different. </br>
	 * ex:- 5 ^ 7 </br>
	 * 
	 * binary representation 5 = 101 , 7 = 111 </br>
	 * 
	 * 5 ^ 7 --> 101 XOR 111 --> 010
	 * 
	 * @param num1
	 * @param num2
	 */
	public void bitwiseXOR(int num1, int num2) {
		System.out.println(num1 ^ num2);
	}

	/**
	 * Takes two numbers, left shifts the bits of the first operand, the second
	 * operand decides the number of places to shift.
	 * 
	 * </br>
	 * 
	 * ex: num = 1 </br>
	 * binary representation 1 = 01 </br>
	 * 1<<4 --> 01 << 4 --> 010000 </br>
	 * 
	 * </br>
	 * 10000 = 16
	 * 
	 * @param num
	 * @param k
	 */
	public void leftShift(int num, int k) {
		System.out.println(num << k);
	}

	/**
	 * Takes two numbers, right shifts the bits of the first operand, the second
	 * operand decides the number of places to shift.
	 * 
	 * </br>
	 * ex: num = 5 </br>
	 * binary representation 5 = 101 </br>
	 * 5 >> 1 --> 101 >> 1 --> 10 </br>
	 * 
	 * </br>
	 * 10 = 2
	 * 
	 * @param num
	 * @param k
	 */
	public void rightShift(int num, int k) {
		System.out.println(num >> k);
	}

	/**
	 * Takes one number and inverts all bits of it.
	 * 
	 * @param num
	 */
	public void bitWiseNOT(int num) {
		System.out.println(~num);
	}
}
