package org.hanjia.leetcode.string;

public class Problem7_ReverseInteger {
	
	public static void main(String[] args){
		int number = -2147483648;
		System.out.println(reverseBetterSolution(number));
	}
	
    public static int reverse(int x) {    	
    	char[] array = String.valueOf(x).toCharArray();
        int left = 0;
        int right = array.length -1;

        if(array.length == 1){
            return x;
        }
        
        if(array[left] == '-'){
            left = 1;
        }
        
        while (left < right) {
            char temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
        
        int result = 0;
        try{
        	result = Integer.valueOf(new String(array));
        }catch(Exception e){
        	System.out.println("Number overflow!");
        }
              
        return result;
    }
    
    public static int reverseBetterSolution(int x){
    	int newN = 0, left = 0;  

    	while(x != 0){  
    		left = x % 10;   		
    		if( newN > Integer.MAX_VALUE / 10 || newN < Integer.MIN_VALUE / 10){
    			return 0;
    		}
    		newN = newN * 10 + left;
    		x = x / 10;  
    	}  
    	
    	return newN;  
    }
}
