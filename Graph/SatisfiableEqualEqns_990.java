class SatisfiableEqualEqns_990 {

    private int[] parent, rank;

    private void union(int u, int v){

        int pU = find(u);
        int pV = find(v);

        if(pU == pV)
            return;

        if(rank[pU] > rank[pV])
            parent[pV] = pU;

        else if(rank[pU] < rank[pV])
            parent[pU] = pV;

        else{
            parent[pV] = pU;
            rank[pU]++;
        }
    }

    private int find(int u){

        if(u == parent[u])
            return u;

        return parent[u] = find(parent[u]);
    }

    public boolean equationsPossible(String[] equations) {
        
        rank = new int[26];
        parent = new int[26];

        for(int i = 0; i < 26; ++i)
            parent[i] = i;

        for(String s : equations){

            if(s.charAt(1) == '=')
                union(s.charAt(0)-'a', s.charAt(3)-'a');
        }

        for(String s : equations){

            if(s.charAt(1) == '!'){
                int pU = find(s.charAt(0)-'a');
                int pV = find(s.charAt(3)-'a');

                if(pU == pV)
                    return false;
            }
        }

        return true;
    }
}
