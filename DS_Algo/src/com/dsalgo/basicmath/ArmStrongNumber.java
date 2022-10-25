package com.dsalgo.basicmath;

public class ArmStrongNumber {

	public static void main(String[] args) {

		System.out.println(isArmStrongNumber(1634));
	}

	static boolean isArmStrongNumber(int n) {
		int sum = 0;
		int temp = n;

		int digits = CountDigits.logApproach(n);
		while (temp != 0) {
			int dig = temp % 10;
			sum += ((int) Math.pow(dig, digits));
			temp /= 10;
		}
		return sum == n;
	}
}
