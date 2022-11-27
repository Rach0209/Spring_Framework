package lv00;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 문자열 정렬하기 (1)

 * 문제 설명
문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

제한사항
1 ≤ my_string의 길이 ≤ 100
my_string에는 숫자가 한 개 이상 포함되어 있습니다.
my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다. - - -
입출력 예
my_string	result
"hi12392"	[1, 2, 2, 3, 9]
"p2o4i8gj2"	[2, 2, 4, 8]
"abcde0"	[0]
입출력 예 설명
입출력 예 #1

"hi12392"에 있는 숫자 1, 2, 3, 9, 2를 오름차순 정렬한 [1, 2, 2, 3, 9]를 return 합니다.
입출력 예 #2

"p2o4i8gj2"에 있는 숫자 2, 4, 8, 2를 오름차순 정렬한 [2, 2, 4, 8]을 return 합니다.
입출력 예 #3

"abcde0"에 있는 숫자 0을 오름차순 정렬한 [0]을 return 합니다.
 * */
public class Test_48 {
	public int[] solution(String my_string) {
        my_string = my_string.replaceAll("\\D", "");
        my_string = Stream.of(my_string.split("")).sorted().collect(Collectors.joining());
        String[] temp = my_string.split("");
        int[] answer = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            answer[i] = Integer.valueOf(temp[i]);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String my_string = "hi12392";
		my_string = my_string.replaceAll("\\D", "");
        System.out.println("숫자만 뽑히나? " + my_string);
        my_string = Stream.of(my_string.split("")).sorted().collect(Collectors.joining());
        String[] temp = my_string.split("");
        for (String e : temp) {
        	System.out.println(e);
        }
        System.out.println("구분선");
        int[] answer = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
        	answer[i] = Integer.valueOf(temp[i]);
        	System.out.println(answer[i]);
        }
	}
}
