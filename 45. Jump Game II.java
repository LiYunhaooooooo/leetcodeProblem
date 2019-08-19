class Solution {
    public int jump(int[] nums) {
    	int start = 0;
    	int end = start;
    	int jump = 0;
    	while(end < nums.length - 1){
    		int nextEnd = 0;
    		for(int i = start ; i <= end ; i++){
    			nextEnd = Math.max(nextEnd , i + nums[i]);
    		}
    		start = end + 1;
    		end = nextEnd;
    		jump++;
    	}
    	return jump;
    }
}

/*
In each round, our possible start point is [start , end]
find maximal distance we can reach from these start points , say it is nextEnd.
Then in next round our possible start point is [end + 1 , nextEnd]
When we can readch end of the array , algorithem terminate
*/