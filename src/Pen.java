
public class Pen {
	private String color;
	
	public Pen(String c) {
		color = c;
	}

	public String getColor() {
		return color;
	}

	@Override
	public boolean equals(Object obj) {
		return this.color.equals(((Pen)obj).color);
	}
}
