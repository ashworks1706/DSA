
// elements are divided into buckets basically groups of range, whoever element is within that range falls into that bucket
// then we sort each bucket and gather all buckets together

class BucketSort{
    public static void main(String[] args) {
        int[] list = {23, 1231, 231, 332, 432, 42342, 1};
        bucketSort(list);
        print(list);
    }
    public static void bucketSort(int[] list){

    }
    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
