class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	for(int i = 0; i < nums.length ; i++){
    		if( i > 0 && nums[ i - 1] == nums[i])
    			continue;
    		int first = i + 1;
    		int last = nums.length - 1;
    		while(first < last){
    			int sum = nums[i] + nums[first] + nums[last];
    			if(sum > 0)
    				last--;
    			else if(sum < 0)
    				first++;
    			else{
    				List<Integer> t = new ArrayList<Integer>();
    				t.add(nums[i]);
    				t.add(nums[first]);
    				t.add(nums[last]);
    				ans.add(t);
    				do{
    					first++;
    				}while(first < last && nums[first] == nums[first - 1]);
    				do{
    					last--;
    				}while(last > first && nums[last] == nums[last + 1]);
    			} 
    		}
    	}
    	return ans;
    }
}