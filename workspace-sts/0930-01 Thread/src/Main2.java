public class Main2 {
	public static void printNumbers() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
		
//		Thread t1 = new Thread(); // Thread를 제어할 수 있는 객체! 아직 흐름이 만들어 진 것 아님.
		// Thread가 할 일을 인터페이스(Runnable)로 정의하기!
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
				for (int i = 0; i > -100; i--) {
					System.out.println(i);
				}
			}
		});
		t1.start(); // start로 새로운 흐름이 생성된다. 실행 할 때마다 결과가 달라진다. (콘솔의 특징 때문에 더 달라보이긴 함)
		// 일을 동시에 시켰더라도, 확실하게 동시에 일을 한다는 보장을 받지 못한다. 
		// => 코어(일꾼)가 8개 밖에 되지 않기때문에. (다른 작업도 항상 하고 있음, 어떤 코어는 작업이 빨리 끝날수도 느릴수도 있다.) 
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
