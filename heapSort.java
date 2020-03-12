package practise;

public class heapSort {
	
	public void sort( int[] arr ) {
		int N = arr.length;
		for( int k = N / 2; k >= 1; k--) sink( arr, k, N);
		
		while( N > 1 ) {
			exch( arr, 1, N);
			sink( arr, 1, --N);
		}
	}
	
	public void spacePrinter( int nTimes ) {
		for( int i = 0; i < nTimes; i++ ) {
			System.out.print(" ");
		}
	}
	
	public void printArr( int[] arr ) {
		int constant = 1;
		int twoP = 0;
		for( int i = 1 ; i < arr.length + 1 ; i ++ ) {
			if( i < constant ){
				spacePrinter( (int)( 2 * arr.length / ( Math.pow( 2 , twoP ) + 1 ) ) );
				System.out.print( arr[ i - 1] );
			}
			else if( i == constant ) {
				spacePrinter( (int)( 2 * arr.length / ( Math.pow( 2 , twoP ) + 1 ) ) );
				System.out.println( arr[ i - 1] );
				constant = 2 * constant + 1;
				twoP ++;
			}
		}
		System.out.println();
	}
	
	public void sink( int[] arr, int index, int N) {//HEAPIFY THE ARRAY
		while( 2 * index <= N ) {
			int childIndex = 2 * index;
			if( childIndex < N && arr[ childIndex - 1] < arr[ childIndex] ) childIndex ++;// nodeLeft < nodeRight we have to go right
			if( arr[ index - 1] > arr[ childIndex - 1] ) break;//  if parent is bigger than right child no sink
			exch( arr, index, childIndex);
			index = childIndex;
		}
	}
	
	public void exch( int[] arr , int in0 , int in1 ) {
		int temp = arr[ in0 - 1];
		arr[ in0 - 1] = arr[ in1 - 1];
		arr[ in1 - 1] = temp;
	}
	
	public static void main(String[] args) {
		heapSort hS = new heapSort();
		int[] arr1 = { 1 , 2 , 3 , 1 , 4 , 4 , 5 , 9 , 6 , 6 , 5 , 10 , 2 , 0 , 0 , 4 , 9 };
		System.out.println("unsorted");
		hS.printArr( arr1);
		hS.sort( arr1);
		System.out.println("sorted");
		hS.printArr( arr1);
	}
}
