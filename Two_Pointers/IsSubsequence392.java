class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int m = s.length(), n = t.length();
        int i,j;

        for(i=0, j=0 ; i < m && j < n; ++j){
            
            if(s.charAt(i) == t.charAt(j))
                i++;
        }

        return i == m;
    }
}
