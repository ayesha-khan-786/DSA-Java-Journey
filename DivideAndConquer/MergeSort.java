public class MergeSort {

    public static void printArr(int arr[]) {
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si , int ei) {                          // step 2 : divide
       if( si >= ei ) {
        return;
       }
       
        //kaam
        int mid = si + (ei - si)/2;     //(si + ei) / 2
        mergeSort(arr, si , mid);        // left side of mid
        mergeSort(arr, mid+1 , ei);     // right side

        // merge
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {                          // step 3 : create iterator & compare
        //left(0, 3)=4 right(4, 6)=3 -> 6-0+1
        int temp[] = new int[ei-si+1];
        int i = si;     // iterator for left part
        int j = mid+1;  //iterator for right part
        int k = 0;      //iterator for temp arr

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {       //compare
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
              k++;
        }
        // left part me agr quch bacha h                                                // step 4 : after compare if some ele left store in temp
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // right
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original array                                                  // step 5 : copy in original
        for(k=0, i=si ; k<temp.length ;k++, i++ ) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {                            // step 1 : main
        int arr[] = {6, 3, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}