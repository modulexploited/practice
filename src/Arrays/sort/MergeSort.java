package Arrays.sort;

public class MergeSort {
	static int[] ar,tmp;
	
	public MergeSort(int[] array){
		ar = array;
		tmp = new int[ar.length];
	}
	
	public int[] sort(int low, int high){
		if(low<high){
			int middle = low+(high-low)/2;
			
			sort(low, middle);
			sort(middle+1, high);
			return merge(low, middle, high);
		}
		return null;
	}
	
	private int[] merge(int low, int middle, int high){
		for (int i = low; i <= high; i++) {
			tmp[i] = ar[i];
		    }
		
		int i=low, j=middle+1;
		int k =low;
		while(i<=middle && j<=high){
			if(tmp[i]<=tmp[j]){
				ar[k] = tmp[i];
				i++;
			}else{
				ar[k] = tmp[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
		      ar[k] = tmp[i];
		      k++; i++;
		}
		
		return ar;
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort(new int[]{31, 41, 59, 26, 41, 20, 58});
		ms.sort(0, 5);
		for(int x	:	MergeSort.ar){
			System.out.print(x+" ");
		}
	}

}
