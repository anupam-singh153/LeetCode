class Solution {
    public String reverseWords(String s) {
      
      s = s.trim();
      String [] arr = s.split("\\s+");
      StringBuilder sb = new StringBuilder();

      for(String str : arr)
        sb.insert(0,str).insert(0," ");

      return sb.substring(1);     
    }
}
