class InsertionSort {

    public static void main(String[] args) {
        int[] list = {23, 1231, 231, 332, 432, 42342, 1};
        insertSort(list);
        print(list);
    }

    public static void insertSort(int[] list) {
        
        for (int i = 1; i < list.length; i++) {

            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = key;

        }
    }

    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
