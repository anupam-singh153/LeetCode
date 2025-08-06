class Solution {

    private static class Task {
        char label;
        int freq;
        int nextAvailableTime;

        public Task(char label, int freq, int nextAvailableTime){
            this.label = label;
            this.freq = freq;
            this.nextAvailableTime = nextAvailableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        // Frequency count
        int[] alpha = new int[26];
        for(char t : tasks)
            alpha[t - 'A']++;

        // Max Heap: sort by freq (descending)
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        // Add tasks to max heap
        for(char c = 'A'; c <= 'Z'; ++c){
            if(alpha[c - 'A'] > 0)
                maxHeap.add(new Task(c, alpha[c - 'A'], 0));
        }

        // Cooldown queue: sorted by nextAvailableTime
        Queue<Task> cooldownQueue = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {

            // First check if a task in cooldown is now available
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().nextAvailableTime <= time) {
                maxHeap.add(cooldownQueue.poll());
            }

            if (!maxHeap.isEmpty()) {
                Task t = maxHeap.poll();
                t.freq--;
                if (t.freq > 0) {
                    t.nextAvailableTime = time + n + 1;
                    cooldownQueue.add(t);
                }
            }

            time++;
        }

        return time;
    }
}
