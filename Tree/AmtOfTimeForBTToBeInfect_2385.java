class Solution {
    private List<Integer>[] graph;
    private int number,target;

    private void convertTreeInGraph(TreeNode root,TreeNode par){

        if(root == null)
            return;

        if(par != null){
            graph[root.val].add(par.val);
            graph[par.val].add(root.val);
        }

        convertTreeInGraph(root.left,root);
        convertTreeInGraph(root.right,root);
    }

    private int countNodes(TreeNode root, int start){

        if(root == null)
            return 0;

        if(root.val == start)
            this.target = number;

        root.val = number++;
        return 1 + countNodes(root.left,start) + countNodes(root.right,start);
    }

    private int bfs(int start, int V){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        queue.add(start);
        vis[start] = true;

        int time = -1;
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 1; i <= levelSize; ++i){
                int u = queue.poll();

                for(int v : graph[u]){

                    if(!vis[v]){
                        queue.add(v);
                        vis[v] = true;
                    }
                }
            }
            time += 1;
        }
        return time;
    }
    public int amountOfTime(TreeNode root, int start) {
        
        this.number = 0;
        int V = countNodes(root,start);

        graph = new ArrayList[V];

        for(int i = 0; i < V; ++i)
            graph[i] = new ArrayList<>();

        convertTreeInGraph(root,null);

        return bfs(target,V);
    }
}
