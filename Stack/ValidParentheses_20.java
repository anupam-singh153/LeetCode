class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        Map<Character,Character> mp = new HashMap<>();

        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');

        for(char c : s.toCharArray()){

            if(c == '(' || c == '{' || c == '[')
                st.push(c);

            else{

                if(st.isEmpty())
                    return false;

                char ch = st.pop();

                if(mp.get(c) != ch)
                    return false;
            }
        }

        return st.isEmpty();
    }
}
