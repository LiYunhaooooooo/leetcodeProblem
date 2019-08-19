class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> postion = new ArrayList<Integer>();
    	List<Integer> permute = new ArrayList<Integer>();
    	for(int i = 0; i < nums.length ; i++){
    		postion.add(i);
    		permute.add(0);
    	}
    	assign(ans , permute, postion , 0 , nums , -1);
    	return ans;
    }

    public void assign(List<List<Integer>> ans , List<Integer> permute, List<Integer> position , int index , int [] nums , int lastP){
    	if(index == nums.length){
    		ans.add(new ArrayList<Integer>(permute));
    		return;
    	}

    	List<Integer> temp =  new ArrayList<Integer>(position);
    	for(int p : temp){
    		if(index != 0 && nums[index - 1] == nums[index] && p <= lastP)
    			continue;
    		permute.set(p , nums[index]);
    		position.remove(new Integer(p)); 
    		assign(ans , permute , position , index + 1 , nums , p);
    		position.add(new Integer(p));
    	}
    }
}

/*
Key point here is how to avoid duplicate
firstly sort array
for duplicate numbers(nums[index - 1] == nums[index])
	their position index must be larger (p > lastP) to avoid duplicate
for non- duplicate ones 
	their can be assigned any positons left
*/