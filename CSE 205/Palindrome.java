class Palindrome{
    public static void main(String[]args){
        String a = "tenet";
        System.out.println(findPal(a));
    }
    public static boolean findPal(String str){
        if (str.length() <= 1){
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length()-1)){
            return findPal(str.substring(1, str.length()-1));
        }
        return false;
    }
}