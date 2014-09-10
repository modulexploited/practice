package Arrays.sort;

public class InsertionSort{
	int[] array;
	
	public InsertionSort(int[] arr){
		this.array = arr;
	}
	
	public int[] sort(){
		for(int i=0; i<this.array.length;i++){
			int j = i-1;
			while(j>=0 && this.array[j] > this.array[j+1]){
				int tmp = this.array[j];
				this.array[j] = this.array[j+1];
				this.array[j+1] = tmp;
				
				j--;
			}
		}
		return this.array;
	}
	
	public static void main(String args[]){
		InsertionSort is = new InsertionSort(new int[]{31, 41, 59, 26, 41, 58});
		for(int x	:	is.sort()){
			System.out.print(x+" ");
		}
	}
}