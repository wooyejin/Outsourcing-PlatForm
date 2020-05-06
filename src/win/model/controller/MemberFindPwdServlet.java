package win.model.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.exception.MemberException;
import win.model.service.MemberService;
import win.model.vo.Member;

/**
 * Servlet implementation class MemberFindPwdServlet
 */
@WebServlet("/mfindpwd.do")
public class MemberFindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String name = request.getParameter("userName");
	      String userid = request.getParameter("userId");
	      String email = request.getParameter("email");
	      
	      Member m = new Member(name, userid, email);
	      Member m2 = new Member(); //DB에서 가져온 회원정보
	      System.out.println("MemberFindPwdServlet : " + m);
	      MemberService ms = new MemberService();
	         try {
	            m2 = ms.findPwd(m);
	            System.out.println(m2.toString());
	         } catch (MemberException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	         }
	      
	      
//	      if(m.getUserId() == null || m.getUserId().equals(""))
	         //아이디가 조회되지 않았거나, (가져온 아이디가 DB에 있는 아이디와 다르고, 이메일이 DB에 없을경우)
	      if(m2.getUserId() == null )
	      {
	         request.setAttribute("msg", "아이디나 이메일 정보가 맞지 않습니다.");
	         request.getRequestDispatcher("/Member/foundPwderror.jsp").forward(request, response);
	         return;
	      }

	      // maim server 설정
	      String host = "";
	      String user = "";
	      String password ="";
	      
	      // 메일 받을 주소
	      String to_email = m2.getEmail();
	      
	      // SMTP 서버 정보를 설정한다.
	      Properties props = new Properties();
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", 465);
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.ssl.enable", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.debug", "true");
	      
	      // 인증번호 생성기
	      StringBuffer temp = new StringBuffer();
	      Random rnd = new Random();
	      for(int i=0; i<10; i++) {
	         int rIndex = rnd.nextInt(3);
	         switch(rIndex) {
	         case 0:
	            //a-z
	            temp.append((char)((int)(rnd.nextInt(26)) + 97));
	            break;
	         
	         case 1:
	            // A-X
	            temp.append((char)((int)(rnd.nextInt(26)) + 65));
	            break;
	            
	         case 2:
	            //0-9
	            temp.append((rnd.nextInt(10)));
	            break;
	         }
	      }
	      
	      String AuthenticationKey = temp.toString();
	      System.out.println(AuthenticationKey);


	              Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	                  protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                      return new javax.mail.PasswordAuthentication(user,password);
	                  }
	              });
	         
	      
	      //email 전송
	      try {
	         MimeMessage msg = new MimeMessage(session);
	         msg.setFrom(new InternetAddress(user,"WINWIN"));
	         msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
	         
	         //메일제목
	         msg.setSubject("안녕하세요 WINWIN 비밀번호 찾기 인증메일입니다.");
	         
	         //메일 내용
	         msg.setText("인증번호는 : " + temp + "입니다.");
	         
	         Transport.send(msg);
	         System.out.println("이메일 전송");
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      HttpSession saveKey = request.getSession();
	      saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
	      // 패스워드 바꿀 때 뭘 바꿀지 조건에 들어가는 id
	      request.setAttribute("id", userid );
	      HttpSession userSession = request.getSession();
	      userSession.setAttribute("member", m2);
	      request.getRequestDispatcher("/Member/findcodePwd.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
