class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {

            map.put(arr[i], i);
        }

        int N = arr.length;

        for (int[] p : pieces) {
            int idx = map.getOrDefault(p[0], -1);

            if (idx == -1)
                return false;

            for (int x : p) {

                if (idx < N && x == arr[idx++])
                    continue;
                else
                    return false;
            }
        }

        return true;
    }
}
