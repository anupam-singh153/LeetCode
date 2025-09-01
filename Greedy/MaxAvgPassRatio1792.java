class Solution {

    private double calculateGain(double pass, double total){

        return (pass+1)/(total+1) - pass/total;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double []> maxHeap = new PriorityQueue<>(
            (a,b)-> Double.compare(b[0], a[0])
        );

        for(int[] classData : classes){
            int pass = classData[0];
            int total = classData[1];

            double gain = calculateGain(pass, total);
            maxHeap.add(new double[]{gain, pass, total});
        }

        while(extraStudents-- > 0){
            double[] classData = maxHeap.poll();
            int pass = (int)classData[1];
            int total = (int)classData[2];

            maxHeap.add(new double[]{
                calculateGain(pass+1, total+1),
                pass+1, total+1
            });
        }

        double total = 0;
        while(!maxHeap.isEmpty()){
            double[] classData = maxHeap.poll();
            total += classData[1]/classData[2];
        }

        return total/classes.length;
    }
}
