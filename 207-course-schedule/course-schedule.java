class Solution {

    HashMap<Integer,List<Integer>> adjList;
    Set<Integer> set;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        adjList = new HashMap<>();
        set = new HashSet<>();

        for(int i=0;i<numCourses;i++){
            adjList.put(i,new ArrayList<>());
        }

        for(int[] courses : prerequisites){
            adjList.get(courses[0]).add(courses[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i))
             return false;
        }

        return true;
    }

    
    public boolean dfs(int course){
 
        if(set.contains(course))
         return false;

        if(adjList.get(course).size() == 0)
         return true;

        set.add(course);
        for(Integer c : adjList.get(course)){
            if(!(dfs(c)))
             return false;
        }
        set.remove(course);
        adjList.put(course,new ArrayList<>());
        return true;
    }

}