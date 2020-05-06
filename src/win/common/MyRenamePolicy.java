package win.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		// 현재 시간 기준의 파일 포맷 방식
		// 사용하기
		
		long currentTimes = System.currentTimeMillis();
		
		SimpleDateFormat sdf 
		 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		int randomNumber = (int)(Math.random() * 10000);
		
		// 확장자 명만 제외하고 이름 바꾸기
		String name = oldFile.getName();
		String body = "";  // 파일 명
		String ext = "";   // 파일 확장자
		
		// index.html ; index ; .html
		
		int dot = name.lastIndexOf('.');
		
		if(dot != -1) {
			// 확장자가 존재하는 경우
			body = name.substring(0, dot);
			
			ext = name.substring(dot);
		} else {
			// 확장자가 없을 경우
			body = name;
		}
		
		// 새로 만들어질 파일 명 생성하기
		
		String fileName = sdf.format(new Date(currentTimes))
				+ "_" + randomNumber + ext;
				
		File newFile = new File(oldFile.getParentFile(), fileName);
				
		return newFile;
	}

}










