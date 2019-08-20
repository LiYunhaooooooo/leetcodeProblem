class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Map<Integer , List<Integer>> mapf = new HashMap<Integer , List<Integer>>();
    	Map<Integer , List<Integer>> mapt = new HashMap<Integer , List<Integer>>();
    	for(int [] prerequisite : prerequisites){
    		int from = prerequisite[0];
    		int to = prerequisite[1];
    		if(!mapf.containsKey(from))
    			mapf.put(from , new ArrayList<Integer>());
    		mapf.get(from).add(to);
    		if(!mapt.containsKey(to))
    			mapt.put(to ,new ArrayList<Integer>());
    		mapt.get(to).add(from);
    	}
    	Set<Integer> order = new HashSet<Integer>();
    	int curSize = 0;
    	do{
    		curSize = order.size();
    		for(int i = 0; i < numCourses ; i++){
    			if(!order.contains(i) && !mapt.containsKey(i)){
    				order.add(i);
    				if(!mapf.containsKey(i))
                        continue;
    				for(int to : mapf.get(i)){
    					mapt.get(to).remove(new Integer(i));
    					if(mapt.get(to).size() == 0)
    						mapt.remove(to);
    				}
    			}
    		}
    	}while(curSize != order.size());
    	return order.size() == numCourses;
    }
}