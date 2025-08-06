class Solution {

    private static class Pair implements Comparable<Pair>{
        int val, index;

        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair that){
            return that.val - this.val;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        
        if(score.length == 0)
            return new String[0];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < score.length; ++i)
            pq.add(new Pair(score[i], i));

        String[] result = new String[score.length];

        
        result[pq.poll().index] = "Gold Medal";

        if(score.length > 1)
            result[pq.poll().index] = "Silver Medal";

        if(score.length > 2)
            result[pq.poll().index] = "Bronze Medal";

        int rank = 4;

        while(!pq.isEmpty()){

            result[pq.poll().index] = ""+ rank;
            rank++;
        }

        return result;
    }
}
