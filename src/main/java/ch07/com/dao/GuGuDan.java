package ch07.com.dao;

public class GuGuDan {
	public int[] process(int num) {
		int arr[]=new int[9];
		for(int i=1; i<=9; i++) {
			arr[i-1]=num*i;
		}
		return arr;
	}
}
