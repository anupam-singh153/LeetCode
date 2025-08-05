import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int[] result = new int[k];

        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);

            if (pq.size() > k)
                pq.poll();
        }

        for (int i = 0; i < k; ++i)
            result[i] = pq.poll().getKey();

        return result;
    }
}
