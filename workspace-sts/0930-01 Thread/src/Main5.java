class IntHolder {
	private int number;
	
	public void increase() {
		number++;
	}
	
	public int getNumber() {
		return number;
	}
}

public class Main5 {
	public static void main(String[] args) throws InterruptedException {
		// 각각 사용할 객체가 있는것이 아니라, 쓰레드 둘이서 공유할 객체를 만들어서 사용해보기.
		IntHolder mySharedObject = new IntHolder();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
//				int a = 0;
				for (int i = 0; i < 10000; i++) {
//					a++;
					mySharedObject.increase();
				}
//				System.out.println("t 작업 완료, a값: " + a);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
//				int a = 0;
				for (int i = 0; i < 10000; i++) {
//					a++;
					mySharedObject.increase();
				}
//				System.out.println("t2 작업 완료, a값: " + a);
			}
		});
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(mySharedObject.getNumber()); // 결과값이 실행할 때마다 바뀐다.
		// 참조 객체는 Ram 공간에 하나의 객체로써 값을 가지고 있음.
		// 값을 변경할 때, ram 공간을 찾아와서 작업 하는것이 아님.
		// ram의 값을 자기(Thread)가 사용할 수 있는 공간에 복사를하여 연산을 하고, 그 공간에 있던 값을 원래의 위치로 집어넣어준다.
		// 작업자가 한명이면 상관없는데, 두명 이상이 된다면 값을 변경하는 사이에 다른 작업자가 하던 값을 들고와 복사하여 사용할 수 있기 때문.
		// 거의 동시에 작업이 일어나서, 결과가 20000이 될 수 없음.
		// '동기화(Synchronization) 문제'라고 말한다.
		// 해결 방법; 1. 기다려주기 - 공유되는 값인 원인 자체를 제거(*속도가 느려질 수 있다), 2. 공유되는 	자원에 대해서 서로 영향을 받지 않게끔 설정.
		// 2번 방법은 접점이 있을 수 밖에 없다. => 공유되는 값을 절대 바꿀 수 없게 설정하기. 읽기전용. (모든 상황에 적용은 불가능 - 순서지켜서 사용하기로 해결...)
		
		// 공유되는 자원에 대해 여러개의 쓰레드가 접근해도 잘 돌아가는 프로그램
		// => 'Thread Safe'쓰레드 안전 이라 함. MultiThread에서 정확하게 동작하는 것. 
		
		// MultiThread => 동시에 여러가지 일을 하려고 작업 흐름을 효율적으로 사용하기 위해서!.
		// 공유되는 자원에 대한 동기화, 정확도를 지키는것이 매우 중요하다.
	}
}
