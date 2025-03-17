class BinarySearch{
    public static void main(String[] args) {
        int[] list = {1, 23, 231, 332, 432, 1231, 42342};
        int index = search(list,332);
        System.out.println(index);
    }
    public static int search(int [] list, int value){
        int start=0;
        int end = list.length-1;
        int mid=0;
        while(start<=end){
            mid = (start+end)/2;
            if(value < list[mid]){
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        
            if (list[mid] == value) {
                return mid;
            }
        }
        return -1;
    }
}