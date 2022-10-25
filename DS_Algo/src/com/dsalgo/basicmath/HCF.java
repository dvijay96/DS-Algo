package com.dsalgo.basicmath;

public class HCF {

	public static void main(String[] args) {

		System.out.println(findHcf(50, 25));
	}

	static int findHcf(int a, int b) {
		if (b == 0)
			return a;
		return findHcf(b, a % b);
	}
}
