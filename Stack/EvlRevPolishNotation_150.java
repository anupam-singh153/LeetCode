class Solution {
    public int evalRPN(String[] tokens) {
     
        Stack<Integer> st = new Stack<>();

        List<String> list = List.of("+","-","/","*");
                
        for(String s : tokens){

            if(list.contains(s)){    
                int val = calculate(st.pop(),st.pop(),s);        
                st.push(val);
            }      
            else{ 
                st.push(Integer.valueOf(s)); 
            }
        }
        return st.peek();
    }   

    // calculate function in stack 
    private int calculate(int val2, int val1,String op){
        
        if(op.equals("+"))
            return val1 + val2;
        
        else if(op.equals("-"))
            return val1 - val2;
        
        else if(op.equals("*"))
            return val1 * val2;
        
        else
            return val1 / val2;
    } 
}
