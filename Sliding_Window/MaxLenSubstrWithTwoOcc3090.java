class Solution {
    public int maximumLengthSubstring(String s) {
        
        int n = s.length();
        int l = 0, result = 0;

        int[] freq = new int[26];

        for(int r = 0; r < n; ++r){

            freq[s.charAt(r)-'a']++;

            while(freq[s.charAt(r)-'a'] > 2){
                freq[s.charAt(l)-'a']--;
                l++;
            }

            result = Math.max(result, r-l+1);
        }

        return result;
    }
}
