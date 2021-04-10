public class Palindrome {
    
    public static void main(String[] args) {
        String s1, s2, s3; 
        s1 = "nodevillivedon";
        s2 = "livenoevil!liveonevil";
        s3 = "beliveivileb";

        boolean r1, r2, r3;
        r1 = pal(s1, 0);
        r2 = palindromeRecursive(s2, 0);
        r3 = palindromeRecursive(s3, 0);

        System.out.printf("s1 is %s\n", r1); // Should be True
        System.out.printf("s2 is %s\n", r2); // Should be True
        System.out.printf("s3 is %s\n", r3); // Should be False
    }

    /**
     * Complete the palindrome algorithm --- with recursion
     * Think about how to break a large problem into smaller sub problems.
     * 
     * What is our base case in this problem?
     * 
     * Another way to ask: what is our smallest problem?
     * 
     * How to get to this smallest problem?
     * 
     * @param string the string to check whether it is a palindrome
     * @param index additional parameter for recursion tracking
     * @return True if @string is palindrome, False otherwise
     */
    public static boolean palindromeRecursive(String string, int index) {
        // TODO
        if((string.length()%2==0 && index==string.length()-index )||(string.length()%2==1 && index==string.length()-index-1))
        {return true;} 

        if(string.charAt(index)==string.charAt(string.length()-index-1))
        {return palindromeRecursive(string,index+1); }
        else
        {return false;}
    }

    public static boolean pal(String string, int index) {
        // TODO
        if(index*2>=string.length())
        {return true;}

        if(string.charAt(index)!=string.charAt(string.length()-index-1))
        {return false;}

        return pal(string,index+1);
    }
}
