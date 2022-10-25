package com.problems.java.recursions;

public class TowerOfHanoi {

	public static void main(String[] args) {

		int n = 5;
//		towerOf3(n, "S", "H", "D");
//		System.out.println("\n\n\n\n------------------XX-----------------\n\n\n");
//		towerOf4(n, "A", "B", "C", "D");

		towerOf5(n, "A", "B", "C", "D", "E");
	}

	/*
	 * O(2^n)
	 */
	private static void towerOf3(int n, String src, String helper, String dest) {
		if (n == 0)
			return;
		if (n == 1) {
			System.out.println("transfering disk " + n + " from " + src + " to " + dest);
			return;
		}
		towerOf3(n - 1, src, dest, helper);
		System.out.println("transfering disk " + n + " from " + src + " to " + dest);
		towerOf3(n - 1, helper, src, dest);
	}

	/*
	 * O(2^(n/2))
	 */
	private static void towerOf4(int n, String src, String h1, String h2, String dest) {

		if (n == 0)
			return;
		if (n == 1) {
			System.out.println(n + " : " + src + " ---> " + dest);
		}

		towerOf4(n - 2, src, dest, h2, h1);
		System.out.println((n - 1) + " : " + src + " ---> " + h2);
		System.out.println(n + " : " + src + " ---> " + dest);
		System.out.println((n - 1) + " : " + h2 + " ---> " + dest);
		towerOf4(n - 2, h1, src, h2, dest);
	}

	private static void towerOf5(int n, String src, String aux1, String aux2, String aux3, String dest) {
		if (n == 0)
			return;
		if (n == 1) {
			System.out.println(n + " : " + src + " --> " + dest);
			return;
		}
		towerOf5(n - 2, src, aux2, aux3, dest, aux1);
		System.out.println((n - 1) + " : " + src + " --> " + aux3);
		System.out.println(n + " : " + src + " --> " + dest);
		System.out.println((n - 1) + " : " + aux3 + " --> " + dest);
		towerOf5(n - 2, aux1, src, aux2, aux3, dest);
	}

	/*
	 * private static void generalizedTower(int n, String... rods) { if (rods !=
	 * null && rods.length >= 3) { String src = rods[0]; String dest =
	 * rods[rods.length - 1]; if (n == 0) return; if (n == 1) { System.out.println(n
	 * + " : " + src + " --> " + dest); return; }
	 * 
	 * } }
	 */
}
