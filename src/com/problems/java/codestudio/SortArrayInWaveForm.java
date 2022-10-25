package com.problems.java.codestudio;

/**
 * 
 * <pre>
 *You have been given an unsorted array ‘ARR’.
Your task is to sort the array in such a way that the array looks like a wave array.
Example:
If the given sequence ‘ARR’ has ‘N’ elements then the sorted wave array looks like - 
‘ARR[0] >= ARR[1]’ and ‘ARR[1] <= ARR[2]’
‘ARR[2] >= ARR[3]’ and ‘ARR[3] <= ARR[4]’
‘ARR[4] >= ARR[5]’ and ‘ARR[5] <= ARR[6]’  And so on.
Note:
1. ‘ARR[0]’ must be greater than or equal to ‘ARR[1]’.

2. There can be multiple arrays that look like a wave array but you have to return only one.

3. We have an internal function that will check your solution and return 'True' in case your array is one of the solutions otherwise return 'False'.


Explanation
The given array ‘ ARR = { 4, 3, 5, 2, 3, 1, 2 } ’
The below figure is a visual representation of the given ‘ARR’ and you can see we can express ‘ARR’ in a waveform array because 
4>3 and 3<5 
5>2 and 2<3
3>1 and 1<2
 * 
 * </pre>
 *
 */
public class SortArrayInWaveForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] waveFormArray(int[] arr, int n) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (i % 2 == 0) {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		return arr;
	}
}
