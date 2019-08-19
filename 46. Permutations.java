class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> postion = new ArrayList<Integer>();
    	List<Integer> permute = new ArrayList<Integer>();
    	for(int i = 0; i < nums.length ; i++){
    		postion.add(i);
    		permute.add(0);
    	}
    	assign(ans , permute, postion , 0 , nums);
    	return ans;
    }

    public void assign(List<List<Integer>> ans , List<Integer> permute, List<Integer> position , int index , int [] nums){
    	if(index == nums.length){
    		ans.add(new ArrayList<Integer>(permute));
    		return;
    	}

    	List<Integer> temp =  new ArrayList<Integer>(position);
    	for(int p : temp){
    		position.remove(new Integer(p));
    		permute.set(p , nums[index]);
    		assign(ans , permute , position , index + 1 , nums);
    		position.add(new Integer(p));
    	}
    }
}

/*
Try to assign every int value in nums to different position 
when all values are assigned a proper positon , add the list to ans
*/