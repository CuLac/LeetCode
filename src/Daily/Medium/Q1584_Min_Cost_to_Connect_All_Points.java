package Daily.Medium;

/*

1584. Min Cost to Connect All Points
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.



Example 1:

Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.



Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

 */


/*

       Solution
       --> sử dụng các thuật toán prim hoặc thuật toán KRUSCALS

 */

import java.util.PriorityQueue;

public class Q1584_Min_Cost_to_Connect_All_Points {

    //Using Prim's algorithm
    //This edge will tell from which node to which node i am connected and what's its cost
    class Edge{
        int point1;
        int point2;
        int cost;

        public Edge(int point1, int point2, int cost){
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }


    class Solution {

        public int minCostConnectPoints(int[][] points) {

            if(points==null || points.length==0)
                return 0;

            int n = points.length;
            boolean[] visited = new boolean[n];

            //we only want n-1 edges if there are n points as we dont want a cycle
            int requiredEdges = n-1;
            int minCost=0;

            //we always want min cost to choose 1st, so lets use minheap based on cost
            PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b)->a.cost-b.cost);
            int[] coordinate1 = points[0];

            //find all possible paths from 0 to n and add its cost to minHeap
            //here indexes are considered as nodes
            for(int i=1;i<points.length;i++){
                int[] coordinate2 = points[i];
                int cost = Math.abs(coordinate2[0]-coordinate1[0])
                        + Math.abs(coordinate2[1]-coordinate1[1]);
                Edge e = new Edge(0,i,cost);
                minHeap.add(e);
            }

            //lets mark 0 as visited bcz we are gonna start from 0 -> finding minCost to another node
            visited[0]=true;

            //we will check till requiredEdges become 0, as we need know initial value was set to n-1
            while(!minHeap.isEmpty() && requiredEdges>0){
                Edge e = minHeap.poll();
                int point1 = e.point1;
                int point2 = e.point2;
                int cost = e.cost;

                //we took the shortest point and see if its already visited, if not lets explore
                if(!visited[point2]){

                    //add the cost and mark as visited
                    minCost += cost;
                    visited[point2]=true;

                    //now lets explore from point 2 to all other possible nodes
                    for(int i=0;i<n;i++){
                        if(!visited[i]){
                            int distance = Math.abs(points[point2][0]-points[i][0])
                                    + Math.abs(points[point2][1]-points[i][1]);

                            minHeap.add(new Edge(point2, i, distance));
                        }
                    }

                    //after this if loop is executed successfully we know we considered a edges, lets decrement it
                    requiredEdges--;
                }
            }

            return minCost;
        }
    }


    // Kruscals Algorithm
    //
// - sort all edges by weight
// - add edge if it does not create a cycle
// - continue until you added n-1 edges
    public int minCostConnectPoints(int[][] points) {
        // edge cases
        if(points == null || points.length == 0){
            return -1;
        }

        // init
        int edges = 0;
        int n = points.length;
        int totalWeight = 0;
        UnionFind uf = new UnionFind(n);

        // use a PQ to sort min weighted edge first
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> a[2] - b[2]);

        // we need a nested look to calculate all the weights
        for(int i=0;i<points.length;i++){
            int[] coords = points[i];
            int x1 = coords[0];
            int y1 = coords[1];
            for(int j=i+1;j<points.length;j++){
                int[] coords2 = points[j];
                int x2 = coords2[0];
                int y2 = coords2[1];

                // calc weight and add it to queue
                int weight = Math.abs(x1 - x2) + Math.abs(y1-y2);
                queue.offer(new int[]{i, j, weight});
            }
        }

        // iterate over each edge until we are done
        while(!queue.isEmpty() && edges < n-1){
            int[] edge = queue.poll();

            // if the two nodes are already connected in the graph
            // we should not add this edge
            if(uf.isConnected(edge[0], edge[1])){
                continue;
            }

            // else union the two edges to build the graph
            uf.union(edge[0], edge[1]);

            // incrememnt counters
            totalWeight += edge[2];
            edges++;
        }
        return totalWeight;
    }
    public class UnionFind{
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;

        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n]; // each rank is init to 1 since it points to itself

            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootY == rootX){
                return;
            }

            if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootY]++;
            }
        }
        private int find(int x){
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }


    //cach giai thứ 3
    public int minCostConnectPoints_v2(int[][] points) {
        // edge cases
        if(points == null || points.length == 0){
            return -1;
        }

        // init
        int edges = 0;
        int n = points.length;
        int totalWeight = 0;
        UnionFind_v2 uf = new UnionFind_v2(n);

        // use a PQ to sort min weighted edge first
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> a[2] - b[2]);

        // we need a nested look to calculate all the weights
        for(int i=0;i<points.length;i++){
            int[] coords = points[i];
            int x1 = coords[0];
            int y1 = coords[1];
            for(int j=i+1;j<points.length;j++){
                int[] coords2 = points[j];
                int x2 = coords2[0];
                int y2 = coords2[1];

                // calc weight and add it to queue
                int weight = Math.abs(x1 - x2) + Math.abs(y1-y2);
                queue.offer(new int[]{i, j, weight});
            }
        }

        // iterate over each edge until we are done
        while(!queue.isEmpty() && edges < n-1){
            int[] edge = queue.poll();

            // if the two nodes are already connected in the graph
            // we should not add this edge
            if(uf.isConnected(edge[0], edge[1])){
                continue;
            }

            // else union the two edges to build the graph
            uf.union(edge[0], edge[1]);

            // incrememnt counters
            totalWeight += edge[2];
            edges++;
        }
        return totalWeight;
    }
    public class UnionFind_v2{
        // data
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;

        public UnionFind_v2(int n){
            this.root = new int[n];
            this.rank = new int[n]; // each rank is init to 1 since it points to itself

            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootY == rootX){
                return;
            }

            if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootY]++;
            }
        }
        private int find(int x){
            if(root[x] == x){ // root
                return x;
            }
            return root[x] = find(root[x]);
        }
        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}
