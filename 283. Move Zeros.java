class Solution {
    public void moveZeroes(int[] nums) {
    	int count = 0;
    	int nonZero = 0;
    	for(int i = 0; i < nums.length ; i++){
    		if(nums[i] == 0)
    			count++;
    		else{
    			nums[nonZero] = nums[i];
    			nonZero++;
    		}
    	}   
    	for(int i = nums.length - count ; i < nums.length ; i++){
    		nums[i] = 0;
    	}
    }
}	

/*count all zeros and move non-zero value to correct place
place all zeros at end
*/