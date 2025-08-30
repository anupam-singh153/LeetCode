class Solution {
    private String result = "";

    private boolean isValid(StringBuilder sb) {

        String[] arr = sb.toString().split(":");

        int hr = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        if (hr < 0 || hr > 23 || minute < 0 || minute > 59)
            return false;

        return true;
    }

    private void fuck(int[] arr, int count, StringBuilder sb) {

        if (count == 4) {
            sb.insert(2, ":");
            if (isValid(sb))
                result = result.compareTo(sb.toString()) < 0 ? sb.toString() : result;
            sb.deleteCharAt(2);
        }

        for (int i = 0; i < 4; ++i) {

            if (arr[i] != -1) {
                int val = arr[i];
                arr[i] = -1;
                sb.append(val);
                fuck(arr, count + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                arr[i] = val;
            }
        }
    }

    public String largestTimeFromDigits(int[] arr) {

        fuck(arr, 0, new StringBuilder());
        return result;
    }
}
