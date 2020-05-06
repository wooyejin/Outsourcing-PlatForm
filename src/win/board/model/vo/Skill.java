package win.board.model.vo;

public class Skill {
	private String s_name; // 기술이름 (종류)
	private String s_lev; // 숙련도
	private String s_ex; // 경험(사용기간)
	private int no; // 기술번호
	
	public Skill() {}

	public Skill(String s_name, String s_lev, String s_ex, int no) {
		super();
		this.s_name = s_name;
		this.s_lev = s_lev;
		this.s_ex = s_ex;
		this.no = no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_lev() {
		return s_lev;
	}

	public void setS_lev(String s_lev) {
		this.s_lev = s_lev;
	}

	public String getS_ex() {
		return s_ex;
	}

	public void setS_ex(String s_ex) {
		this.s_ex = s_ex;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Skill [s_name=" + s_name + ", s_lev=" + s_lev + ", s_ex=" + s_ex + ", no=" + no + "]";
	}
	
	
	
}
