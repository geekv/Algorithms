import java.util.Stack;

public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack =new Stack<>();
        for(int i = 0;i <s.length();i++){
            if('{'==s.charAt(i) ||'['==s.charAt(i)||'('==s.charAt(i)){
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty())
                    return false;

                Character toChar = stack.pop();
                if('('==toChar && s.charAt(i)!=')')    //如何匹配？
                    return false;
                if('['==toChar && s.charAt(i)!=']')
                    return false;
                if('{'==toChar && s.charAt(i)!='}')
                    return false;
            }
        }
        return stack.isEmpty();   //当为空时，返回true
    }
}
