class Solution {

    public boolean isValid(String s) {
        Stack<Character> str = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                str.push(s.charAt(i));
            } else {
                if (str.isEmpty()) {
                    return false;
                } else {
                    char top = str.pop();

                    if ((top != '(' && s.charAt(i) == ')') || (top != '{' && s.charAt(i) == '}') || (top != '[' && s.charAt(i) == ']')) {
                        return false;
                    }
                }
            }
        }
        if (str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
