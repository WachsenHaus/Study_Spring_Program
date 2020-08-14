package com.gura.spring05.users.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
			//dto 개체에 비밀번호를 암호화해서 넣어준다.
			String inputPwd = dto.getPwd();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPwd = encoder.encode(inputPwd);
			dto.setPwd(encodedPwd);
			
			return dao.insert(dto);
		}

		@Override
		public void loginProcess(UsersDto dto, ModelAndView mView, HttpSession session) {
			//입력한 정보가 유효한 정보인지 여부를 저장할 지역변수
			boolean isValid = false;
			//DB에 저장된 암호화된 비밀번호를 읽어온다.
			UsersDto resultDto = dao.getData(dto.getId());
			if(resultDto != null) { //아이디는 존재하는 경우(아이디는 일치)
				//DB에 저장된 암호화된 비밀번호
				String encodedPwd = resultDto.getPwd();
				//로그인폼에 입력한 비밀번호
				String inputPwd = dto.getPwd();
				System.out.println(inputPwd);
				//Bcrypt 클래스를 이용해서 암호화된 비밀번호와 원시 비밀번호를 비교한다.
				isValid = BCrypt.checkpw(inputPwd, encodedPwd);
			}	
			
			
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

		@Override
		public void updateUser(HttpSession session, UsersDto dto) {
			//로그인된 아이디를 읽어와서
			String id = (String)session.getAttribute("id");
			//UsersDto에 담고
			dto.setId(id);
			//dao를 이용해서 수정반영하기.
			dao.update(dto);
		}

		@Override
		public void updateUserPwd(HttpSession session, UsersDto dto, ModelAndView mView) {
			String id = (String)session.getAttribute("id");
			dto.setId(id);
			//dao를 이용해서 비밀번호를 수정한다.(실패 가능성 있음)
			boolean isSuccess = false;
			//1.기존 비밀번호와 암호화된 비밀번호가 일치하는지 확인
			//입력한 정보가 유효한 정보인지 여부를 저장할 지역변수
			UsersDto resultDto = dao.getData(id);
			//DB에 저장된 암호화된 비밀번호를 읽어온다.
			String encodedPwd = resultDto.getPwd();
			//로그인폼에 입력한 비밀번호
			String inputPwd = dto.getPwd();
			//Bcrypt 클래스를 이용해서 암호화된 비밀번호와 원시 비밀번호를 비교한다.
			boolean isValid = BCrypt.checkpw(inputPwd, encodedPwd);
			//2. 만일 일치한다면 새로운 비밀번호를 암호화해서 저장한다.
			if(isValid) {
				//새로운 비밀번호를 암호화한다.
				BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
				String encodedNewPwd = encode.encode(dto.getNewPwd());
				//암호화된 새 비밀번호를 dto에 다시 넣어준다.
				dto.setNewPwd(encodedNewPwd);
				//dao를 이용해서 DB에 반영한다.
				dao.updatePwd(dto);
				//성공
				isSuccess = true;
			}
			//mView 개체에 성공 여부를 담는다.
			mView.addObject("isSuccess",isSuccess);
		}
		
		
}
