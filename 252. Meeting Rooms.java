class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
    	Arrays.sort(intervals , (a , b) -> (a[0] - b[0]));
    	int end = 0;
    	for(int [] interval : intervals){
    		if(end > interval[0])
    			return false;
    		end = interval[1];
    	}
    	return true;
    }
}