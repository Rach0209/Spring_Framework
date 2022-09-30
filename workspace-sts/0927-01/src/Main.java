public class Main {
	public static void main(String[] args) {
//		List<String> list;
		MyHolder<String> h1 = new MyHolder<>("스트링값 가지는 객체");
		MyHolder<Integer> h2 = new MyHolder<Integer>(199);
	
		
		MyPair<String, Integer> p1 = new MyPair<>("키값", 456);
		MyPair<String, String> p2 = new MyPair<>("스트링키", "스트링밸류");
		MyPair<String, MyPair<String, String>> p3;
		
		
//		MyHolder h3 = new MyHolder();
//		h3.setO(o);
	}
}
