package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxSubArray {
	static int[] data = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//	static int[] data = {-13, -3, -25, -20, -3, -16, -23, -18, -20, -7, -12, -5, -22, -15, -4, -7};
	static List<int[]> maxSubArrays = new ArrayList<int[]>();
	
	static List<int[]> bruteForce(){
		for(int i=0; i<data.length;i++){
			int start = i, end = i, max = data[i], sum = 0;
			for(int j=i;j<data.length;j++){
				sum = sum + data[j];
				if(sum > max){ max = sum; end = j; }
			}
			/* add <max, start, end> to maxSubArrays */
			/*if(max>0)*/ maxSubArrays.add(new int[]{max, start, end});
		}
		return maxSubArrays;
	}
	
	static int[] FindMaxCrosingSubArray(int low, int mid, int high){
		int leftSum = -99999999, rightSum = -999999999, tmpMax = 0, leftMax = mid, rightMax = high;

		for(int i=mid;i>=low;i--){
			tmpMax += data[i];
			if(tmpMax>leftSum){ 
				leftSum = tmpMax; 
				leftMax = i; 
			}
		}
		
		tmpMax = 0;
		for(int i=mid+1;i<=high;i++){
			tmpMax += data[i];
			if(tmpMax>rightSum){ rightSum = tmpMax; rightMax = i; }
		}
		return new int[]{leftMax, rightMax, leftSum+rightSum};
	}
	
	static int[] FindMaxSubArray(int low, int high){
		/*	implies only one element array */
		if(low==high)
			return (new int[]{low, high, data[low]});
		else{
			int mid = (high + low) / 2;
			int[] left = FindMaxSubArray(low, mid);
			int[] right = FindMaxSubArray(mid+1, high);
			int[] cross = FindMaxCrosingSubArray(low, mid, high);
			
			if((left[2] >= right[2]) && (left[2]>=cross[2]))
				return left;
			else if((right[2] >= left[2]) && (right[2]>=cross[2]))
				return right;
			else
				return cross;
		}
	}
	
	static void printSubArrays(List<int[]> arrayList){
		Collections.sort(arrayList, new Comparator<int[]>() { 
			@Override public int compare(int[] o1, int[] o2) { return o2[0]-o1[0]; } }
		);
		for(int[] x : arrayList) System.out.println("Max: "+x[0] + "  Start: "+x[1]+" End: "+x[2]);
	}
	
	public static void main(String[] args) {
//		for(int x : FindMaxCrosingSubArray(0, (data.length-1)/2, data.length-1)){
		for(int x : FindMaxSubArray(0, data.length-1)){
			System.out.print(x+" ");
		}
	}

}
