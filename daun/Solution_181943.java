package daun;

class Solution_181943 {
    public String solution(String my_string, String overwrite_string, int s) {
        String a = my_string.substring(0,s);
        String b = overwrite_string;
        String c = my_string.substring(s + overwrite_string.length());

        String answer = a + b + c;
        return answer;
    }
}
