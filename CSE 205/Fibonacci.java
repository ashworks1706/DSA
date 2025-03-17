class Fibonacci{
    public static void main(String[] args){
        int num = 8;
        int result = findfib(num);
        System.out.println("Fibonacci of " + num + " is " + result);
    }
    public static int findfib(int num){
        if(num==0){
            return 0;
        } else if(num==1){
            return 1;
        }
        else{
            return findfib(num-1) + findfib(num-2);
        }
    }
}