package com.gura.spring05.users.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dao.UsersDao;
import com.gura.spring05.users.dto.UsersDto;

@Service
public class UsersServiceImpl  implements UsersService{

		@Autowired
		private UsersDao dao;

		@Override
		public Map<String, Object> isExistId(String inputId) {
			//dao를 이용해서 아이디 존재 여부를 알아내서 변수에 할당한다. 
			boolean isExist = dao.isExist(inputId);
			//아이디가 존재하는지 여부를 Map에 담아서 리턴해 준다.
			Map<String,Object> map = new HashMap<>();
			map.put("isExit", isExist);
			return map;
		}

		@Override
		public boolean addUser(UsersDto dto) {
			return dao.insert(dto);
		}

		@Override
		public void loginProcess(UsersDto dto, ModelAndView mView, HttpSession session) {
			//dao 개체를 이용해서 id,pwd가 유효한 정보인지 여부를 얻어낸다.
			boolean isValid = dao.isValid(dto);
			if(isValid) { //만일 유효한 정보이면
				//로그인 처리를 한다.
				session.setAttribute("id", dto.getId());
				//view 페이지에서 사용할 정보
				mView.addObject("isSuccess",true);
			}else { //아니면 
				mView.addObject("isSuccess",false);
			}
		}

		@Override
		public void getInfo(HttpSession session, ModelAndView mView) {
			//로그인된 아이디를 session 개체를 이용해서 얻어온다.
			String id=(String)session.getAttribute("id");
			//dao를 이용해서 사용자 정보를 얻어오기
			UsersDto dto = dao.getData(id);
			//mView 개체에 담아준다.
			mView.addObject("dto",dto);
		}

		@Override
		public void deleteUsers(HttpSession session) {
			String id = (String)session.getAttribute("id");
			//dao에서 삭제
			dao.delete(id);
			//로그 아웃 처리
			session.invalidate();
		}

		@Override
		public Map<String, Object> saveProfileImage(MultipartFile mFile, HttpServletRequest request) {
			//원본 파일명
			String orgFileName = mFile.getOriginalFilename();
			//파일의 크기
			long fileSize = mFile.getSize();
			
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
				mFile.transferTo(new File(filePath + saveFileName));
				System.out.println(filePath + saveFileName);
			}catch(Exception e)
			{
				System.out.println("파일 저장 오류");
				e.printStackTrace();
			}
			//Map에 업로드된 이미지 파일의 경로를 담아서 리턴한다
			Map<String, Object> map = new HashMap<>();
			map.put("imageSrc", "/upload/"+ saveFileName);
			return map;
		}
		
}
