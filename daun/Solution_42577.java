package daun;

import java.util.HashMap;

class Solution_42577 {
    public boolean solution(String[] phone_book) {
        // 모든 번호를 맵에 저장
        HashMap<String, Boolean> map = new HashMap<>(phone_book.length * 2);
        for(String number : phone_book){
            map.put(number, true);
        }

        // 접두어가 맵에 있는지
        for(String number : phone_book){
            // 접두어는 자기 자신을 제외해야 함
            for(int cut = 1; cut < number.length(); cut++){
                String prefix = number.substring(0, cut);
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }
        return true;
    }
}
