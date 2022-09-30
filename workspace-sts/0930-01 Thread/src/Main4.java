public class Main4 {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("잘게요");
				try {
					Thread.sleep(4000); // 특정한 시간동안 재울 수 있다.(Block 상태) 4초 뒤에 밑의 작업이 실행.
				} catch (InterruptedException e) { 
					// 블럭 상태를 깨울 때 Interrupt를 사용하는데 Java에서는 예외로 구현
					// 예외가 발생하면 흐름이 깨지기 때문.
					e.printStackTrace();
				}
				System.out.println("작업 종료~");
			}
		});
//		t.setDaemon(true);
		// Daemon설정을 해서 MainThread가 죽으면 같이죽는다.
		// =>System.out.println("작업 종료");가 실행되지 않고 자다가 죽어버림.
		
		System.out.println("프로그램 시작");
		t.start();
		t.interrupt(); // 4초동안 잘 수 있었는데, interrupt로 깨워버려서 바로 실행
		
		System.out.println("프로그램 종료???");
		// DaemonThread가 아니기 때문에, mainThread가 끝나도, 할 일이 남아 있기 때문에 나중에 끝남.
	}
}
