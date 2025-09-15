package daun;

class Solution_181856 {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length){
            return 1;
        } else if (arr1.length < arr2.length){
            return -1;
        }

        int diff = 0;
        for(int i = 0; i < arr1.length; i++){
            diff += arr1[i] - arr2[i];
        }

        return Integer.compare(diff, 0);
    }
}
