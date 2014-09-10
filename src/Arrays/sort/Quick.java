/**
 * 
 */
package Arrays.sort;

public class Quick {
	public static int[] unSortedList = unsortedArray(10);

	
	public static int[] unsortedArray(int size){
		int[] list = new int[size];
	    for (int i=0; i<size; i++){
	        int n = (int)(Math.random()*9 + 1);
	        list[i] = n;
	    }
		return list;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
