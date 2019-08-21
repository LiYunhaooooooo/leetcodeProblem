class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == i + 1)
                continue;
            int s = nums[i];
            nums[i] = 0;
            int t = dfs(nums , s);
            if(t != -1)
                return t;
        }
        return -1;
    }
    public int dfs(int [] nums , int s){
        int t = nums[s - 1];
        nums[s - 1] = s;
        if(t == s)
            return t;
        else if(t == 0)
            return -1;
        else
            return dfs(nums , t);
    }
}

/* try to do it in-place
put every number to correct position . eg : 1 -> nums[0]
if number is already in correct position , leave if here 
else use dfs to order numbers in the circle
in dfs process, if nums[s - 1] == s , then this is the duplicated one
*/