class Solution {

    private static class Pair implements Comparable<Pair>{
        char data;
        int freq;

        public Pair(char data, int freq){
            this.data = data;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair that){
            return that.freq - this.freq; 
        }
    }

    public String frequencySort(String s) {
        
        int[] alpha = new int[128];

        for(char c : s.toCharArray())
            alpha[c]++;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(char c = '0'; c <= 'z'; ++c){

            if(alpha[c] > 0)
                pq.add(new Pair(c, alpha[c]));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            for(int i = 1; i <= p.freq; ++i)
                sb.append(p.data);
        }

        return sb.toString();
    }
}
