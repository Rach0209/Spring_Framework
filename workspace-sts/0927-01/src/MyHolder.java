
public class MyHolder<T> {
	private T o;

	public MyHolder() {}
	
	public MyHolder(T o) {
		super();
		this.o = o;
	}

	public T getO() {
		return o;
	}

	public void setO(T o) {
		this.o = o;
	}	
}
