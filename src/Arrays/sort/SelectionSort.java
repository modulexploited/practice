package Arrays.sort;

public class SelectionSort {
	
	private static int[] arr;
	public SelectionSort(int[] ar){
		arr = ar;
	}
	
	public int[] sort(){
		for(int i=0;i<arr.length-1;i++){
			int j = i+1;
			while(j<arr.length){
				if(arr[j]<arr[i]){
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
				j++;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort(new int[]{31, 41, 59, 26, 41, 58});
		for(int x	:	ss.sort()){
			System.out.print(x+" ");
		}
	}

}
