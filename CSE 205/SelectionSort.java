class SelectionSort {

    public static void main(String[] args) {
        int[] list = {23, 1231, 231, 332, 432, 42342, 1};
        selectSort(list);
        print(list);
    }

    public static void selectSort(int[] list) {
        //  we loop through array by picking one element each time and running for loop for rest of the array to find the local minimum value
        // then add it to first part 

        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
        
    }

    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

