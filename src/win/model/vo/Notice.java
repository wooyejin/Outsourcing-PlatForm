package win.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4091242581743464738L;
		private int nno;
		private String ncontent;
		private String nwriter;
		private String ntitle;
		private int ncount;
		private Date ndate;
		
		public Notice() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		/**
		 * 목록 불러올 때
		 * @param nno
		 * @param ncontent
		 * @param nwriter
		 * @param ntitle
		 * @param ncount
		 * @param ndate
		 */
		
		public Notice(int nno, String ncontent, String nwriter, String ntitle, int ncount, Date ndate) {
			super();
			this.nno = nno;
			this.ncontent = ncontent;
			this.nwriter = nwriter;
			this.ntitle = ntitle;
			this.ncount = ncount;
			this.ndate = ndate;
		}


		public int getNno() {
			return nno;
		}


		public void setNno(int nno) {
			this.nno = nno;
		}


		public String getNcontent() {
			return ncontent;
		}


		public void setNcontent(String ncontent) {
			this.ncontent = ncontent;
		}


		public String getNwriter() {
			return nwriter;
		}


		public void setNwriter(String nwriter) {
			this.nwriter = nwriter;
		}


		public String getNtitle() {
			return ntitle;
		}


		public void setNtitle(String ntitle) {
			this.ntitle = ntitle;
		}


		public int getNcount() {
			return ncount;
		}


		public void setNcount(int ncount) {
			this.ncount = ncount;
		}


		public Date getNdate() {
			return ndate;
		}


		public void setNdate(Date ndate) {
			this.ndate = ndate;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public String toString() {
			return "Notice [nno=" + nno + ", ncontent=" + ncontent + ", nwriter=" + nwriter + ", ntitle=" + ntitle
					+ ", ncount=" + ncount + ", ndate=" + ndate + "]";
		}
		
		

		
	
}
