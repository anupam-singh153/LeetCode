class MedianFinder {

    private PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }

    public void addNum(int num) {

        minHeap.add(num);

        while (!maxHeap.isEmpty() && maxHeap.peek() < minHeap.peek()) {
            int val = maxHeap.poll();
            maxHeap.offer(minHeap.poll());
            minHeap.offer(val);
        }

        while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {

            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();

        double result = minHeap.peek() + maxHeap.peek();

        return result / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
