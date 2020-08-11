package com.gura.spring04;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileTestController {

	//<input type="file" name="myFile"/> 하나만 전송되는 경우
	@RequestMapping("/upload")
	public String upload(@RequestParam MultipartFile myFile,
			HttpServletRequest request, @RequestParam String title) {
		//원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		//파일의 크기
		long fileSize = myFile.getSize();
		
		// webapp/upload 폴더 까지의 실제 경로
		String realPath = request.getServletContext().getRealPath("/upload");
		
		//저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 개체 생성
		File upload = new File(filePath);
		if(!upload.exists()) {
			upload.mkdir();
		}
		//저장할 파일 명을 구성한다.
		String saveFileName = 
				System.currentTimeMillis() + orgFileName;
		try {
			//upload 폴더에 파일을 저장한다. 
			//myFile이란 파일을 전달인자로 옮긴다.
			myFile.transferTo(new File(filePath + saveFileName));
			System.out.println(filePath + saveFileName);
		}catch(Exception e)
		{
			System.out.println("파일 저장 오류");
			e.printStackTrace();
		}
		
		request.setAttribute("orgFileName", orgFileName);
		request.setAttribute("saveFileName", saveFileName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("title", title);
		return "upload";
	}
	
	
	@RequestMapping("/upload2")
	public String upload2(HttpServletRequest request, FileDto dto) {
		MultipartFile myFile = dto.getMyFile();
		//원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		dto.setOrgFileName(orgFileName);
		//파일의 크기
		long fileSize = myFile.getSize();
		dto.setFileSize(fileSize);
		//파일의 이름
		String title = dto.getTitle();
		
		// webapp/upload 폴더 까지의 실제 경로
		String realPath = request.getServletContext().getRealPath("/upload");
		
		//저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 개체 생성
		File upload = new File(filePath);
		if(!upload.exists()) {
			upload.mkdir();
		}
		//저장할 파일 명을 구성한다.
		String saveFileName = 
				System.currentTimeMillis() + orgFileName;
		dto.setSaveFileName(saveFileName);
		try {
			//upload 폴더에 파일을 저장한다. 
			//myFile이란 파일을 전달인자로 옮긴다.
			myFile.transferTo(new File(filePath + saveFileName));
			System.out.println(filePath + saveFileName);
		}catch(Exception e)
		{
			System.out.println("파일 저장 오류");
			e.printStackTrace();
		}
		
		request.setAttribute("orgFileName", orgFileName);
		request.setAttribute("saveFileName", saveFileName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("title", title);
		
		//request 영역에 file dto담기
		request.setAttribute("dto", dto);
		return "upload2";
	}
}
