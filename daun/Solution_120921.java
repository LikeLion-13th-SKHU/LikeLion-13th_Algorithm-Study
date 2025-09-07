package daun;

class solution_120921 {
    public int solution(String A, String B) {
        int len = A.length();

        for(int i = 0; i < len; i++){
            if(A.equals(B)){
                return i;
            }

            String first = A.substring(0, len - 1);
            String last = A.substring(len - 1);
            A = last + first;
        }

        return -1;
    }
}