class QuickSort{
    public static void main (String [] args){
        int [] list = {5,1,12,3,5,2};
        sort(list, 0, list.length - 1);
        // we start off from start to end of the list
        print(list);
    }
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // we create partitions by this for passed left and right index
            sort(arr, low, pivot-1); // we do this for sorting left part of array
            sort(arr, pivot+1, high); // we do this for sorting right part of array
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        // making the end point of the array as pivot
        int i = low - 1;
        // starting the ith pointer before start of array 
        
        for (int j = low; j < high; j++) {
            // starting pointer from start of array
            if (arr[j] < pivot) {
                // comparing if the element normally is less than the pivot 
                i++;
                // increasing the i counter
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // swapping Jth value with the Ith value
            }
        }
        // swapping ith+1 pointered element with end element of array
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        //  we return i+1
        return i+1;
    }

    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}