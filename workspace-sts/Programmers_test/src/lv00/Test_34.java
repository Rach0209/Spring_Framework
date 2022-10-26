package lv00;

import java.util.ArrayList;

/* n의 배수 고르기
 * 
n	numlist	result
3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
5	[1, 9, 3, 10, 13, 5]	[10, 5]
12	[2, 100, 120, 600, 12, 12]	[120, 600, 12, 12]
입출력 예 설명
입출력 예 #1

numlist에서 3의 배수만을 남긴 [6, 9, 12]를 return합니다.
입출력 예 #2

numlist에서 5의 배수만을 남긴 [10, 5]를 return합니다.
입출력 예 #3

numlist에서 12의 배수만을 남긴 [120, 600, 12, 12]를 return합니다.
 * */
public class Test_34 {
	public int[] solution(int n, int[] numlist) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0) {
				arr.add(numlist[i]);
			}
		}
		int[] answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
	// return Arrays.stream(numList).filter(value -> value % n == 0).toArray();
}
