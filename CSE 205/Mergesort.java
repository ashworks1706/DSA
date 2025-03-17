class MergeSort{
    public static void main(String [] args){
        int [] list = {2,9,4,1,8,12,3};
        int [] final_list = mergeSort(list, 0, list.length-1);
        print(final_list);
    }
    public static int [] mergeSort(int [] list, int left, int right){
        int [] final_list={0};
        if(left<right){
            int mid = (left+right)/2;

            mergeSort(list, left, mid);
            mergeSort(list, mid+1,right);
            
            final_list = merge(list, left, mid, right);
            
        }
        return final_list;
    }
    public static int[] merge(int [] list, int left, int mid, int right){
        int [] left_part = new int[mid - left+ 1];
        int [] right_part = new int[right-mid];

        for (int i =0; i < left_part.length; i ++){
            left_part[i] = list[left+i];
        }
        for (int i =0; i < right_part.length; i ++){
            right_part[i] = list[mid+1+i];
        }
        int i=0;
        int j =0;
        int k = left;
        while(i<left_part.length && j< right_part.length){
            if(left_part[i]<right_part[j]){
                list[k++] = left_part[i++];
            }
            else{
                list[k++] = right_part[j++];
            }
        }

        while(i<left_part.length){
            list[k++] = left_part[i++];
        }
        while(j<right_part.length){
            list[k++] = right_part[j++];
        }

        return list;


    }
    public static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}