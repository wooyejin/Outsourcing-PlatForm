package win.board.model.vo;

public class Introduce {
	private String in_title;
	private String in_content;
	
	public Introduce() {}

	public Introduce(String in_title, String in_content) {
		super();
		this.in_title = in_title;
		this.in_content = in_content;
	}

	public String getIn_title() {
		return in_title;
	}

	public void setIn_title(String in_title) {
		this.in_title = in_title;
	}

	public String getIn_content() {
		return in_content;
	}

	public void setIn_content(String in_content) {
		this.in_content = in_content;
	}

	@Override
	public String toString() {
		return "Introduce [in_title=" + in_title + ", in_content=" + in_content + "]";
	}
	
	
	
}
