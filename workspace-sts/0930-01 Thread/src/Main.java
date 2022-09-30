// Spring_doc의 Thread.md파일 확인하고 읽어 보기~

public class Main {
	public static void printNumbers() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
		
		System.out.println("작업 1 시작");
		printNumbers();
		System.out.println("작업 1 종료");
		
		System.out.println("작업 2 시작");
		printNumbers();
		System.out.println("작업 2 종료");
		
		System.out.println("작업 3 시작");
		printNumbers();
		System.out.println("작업 3 종료");
	}
}
