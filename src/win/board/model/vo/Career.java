package win.board.model.vo;

public class Career {
	private String ca_name; // 기업이름
	private String ca_work; // 분야
	private String ca_rank; // 직급
	private String ca_exper; // 경력
	private String status; // 재직 여부('Y' 또는 'N')
	private int no; // 경력번호
	
	public Career () {}

	public Career(String ca_name, String ca_work, String ca_rank, String ca_exper, String status, int no) {
		super();
		this.ca_name = ca_name;
		this.ca_work = ca_work;
		this.ca_rank = ca_rank;
		this.ca_exper = ca_exper;
		this.status = status;
		this.no = no;
	}

	public String getCa_name() {
		return ca_name;
	}

	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
	}

	public String getCa_work() {
		return ca_work;
	}

	public void setCa_work(String ca_work) {
		this.ca_work = ca_work;
	}

	public String getCa_rank() {
		return ca_rank;
	}

	public void setCa_rank(String ca_rank) {
		this.ca_rank = ca_rank;
	}

	public String getCa_exper() {
		return ca_exper;
	}

	public void setCa_exper(String ca_exper) {
		this.ca_exper = ca_exper;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Career [ca_name=" + ca_name + ", ca_work=" + ca_work + ", ca_rank=" + ca_rank + ", ca_exper=" + ca_exper
				+ ", status=" + status + ", no=" + no + "]";
	}

	
	
	
}	
