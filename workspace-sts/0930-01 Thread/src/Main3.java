public class Main3 {
	public static void printThreadStatus() {
		Thread current = Thread.currentThread();
		
		System.out.println(current.getName());
		System.out.println(current.getId()); // 각각의 쓰레드마다 id번호가 고유하게 보유.
		System.out.println(current.isAlive()); // 살아 움직이는지 확인.
		System.out.println(current.getState()); // 상태; RUNNABLE : 일을 할 수 있는 상태.
		System.out.println(current.getPriority()); //선호도를 나타낸다. 1-10까지 존재한다. 숫자가 클 수록 작업 중요도가 높다.
	    											// 왜 필요한가? 할 일은 많은데 자원은 한정되어 있기 때문에!
		// setter로 name과, Priority는 존재함.
		System.out.println(current.isDaemon()); // DaemonThread 이거나 아니거나의 상태.
		// DaemonThread의 특징 : 처음에 메인 스레드는 언제나 존재한다.
		// main 스레드가 할 일을 다 하고 나면 main스레드가 종료된다.
		// DaemonThread 설정이 되어있다면 => main Thread가 종료될 때, DaemonThread들이 다같이 종료된다. - 할 일이 남아있어도 종료!
		// DaemonThread가 아닌 thread들은 main thread가 종료되더라도, 해야 할 일이 남아 있다면 계속 작업을 한다.
		// 기본값으로 False이며, main thread가 종료되더라도 작업을 끝까지 완료 해야 한다면 false를 유지.
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread another = new Thread(new Runnable() {
			@Override
			public void run() {
				printThreadStatus(); // start가 되기전이라 Runnable하지 않지만 살아있는 상태.
			}
		}); // 쓰레드 객체를 만든 것.
		another.start(); // Runnable 상태가 되는 시점.
		another.join(); // throws 해줌. // join()으로 흐름을 제어 해주었다.
		// another라는 작업이 종료될 때까지 기다려 준다.
		// main스레드는 Block 상태가 된다.
		// => 흐름이 막힌 상태. Thread는 작업을 다 하고나면 죽는데, 작업이 끝나면 Block되어있는 Thread에 Interrupt라는게 발생.
		// => 쉽게 말하면, 자고 있는 메인 쓰레드를 깨워서 다시 Runnable한 상태로 만들어 준다.
		System.out.println("-----------------------");
		printThreadStatus();
		
		System.out.println("새 쓰레드의 현재 상태 : " + another.getState());
		// 모든 thread들이 죽어 있다. => 프로세스의 종료.
	}
}
