class BubbleSort{
    public static void main(String[] args) {
        int[] list = {23, 1231, 231, 332, 432, 42342, 1};
        bubbleSort(list);
        print(list);
    }
    public static void bubbleSort(int [] list){
        for(int i = 0; i < list.length - 1; i++){
            for(int j = 0; j < list.length - 1 - i; j++){
                if(list[j]>list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }
    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}