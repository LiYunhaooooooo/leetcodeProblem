class Solution {
    public int minMeetingRooms(int[][] intervals) {
    	Arrays.sort(intervals , (a , b) -> (a[0] - b[0]));
    	Queue<Integer> q = new PriorityQueue<Integer>();
    	for(int [] interval : intervals){
    		if(q.isEmpty())
    			q.offer(interval[1]);
    		else if(q.peek() <= interval[0]){
    			q.poll();
    			q.offer(interval[1]);
    		}
    		else
    			q.offer(interval[1]);
    	}
    	int count = 0;
    	while(!q.isEmpty()){
    		count++;
    		q.poll();
    	}
    	return count;
    }
}