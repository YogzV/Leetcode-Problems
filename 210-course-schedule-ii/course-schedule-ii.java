class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        int ind = -1;

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] course : prerequisites){
            adjList.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){

            int course = queue.poll();
            ans[++ind] = course;

            for(int val : adjList.get(course)){
                indegree[val]--;
                if(indegree[val] == 0){
                    queue.add(val);
                }
            }
        }
        if(ind == -1 || ind!= numCourses-1)
         return new int[]{};

        return ans;
    }
}