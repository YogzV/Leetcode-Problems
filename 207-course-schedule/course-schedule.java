class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] courses : prerequisites){
            adjList.get(courses[1]).add(courses[0]);
            indegree[courses[0]]++;
        }
         
         Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int finish = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            finish++;
            for(int c : adjList.get(course)){
                indegree[c]--;
                if(indegree[c] == 0)
                  queue.add(c);
            }
        }

        return finish == numCourses;
    }
}