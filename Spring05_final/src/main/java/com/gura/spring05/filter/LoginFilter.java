package com.gura.spring05.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/users/private/*"})
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		
		//httpsession 개체의 참조값을 얻어낸다.
		HttpSession session =  req.getSession();
		//로그인된 아이디가 있는지 얻어와본다.
		String id = (String)session.getAttribute("id");
		if(id!= null) { //로그인되었다.
			chain.doFilter(request, response);
		}else { //로그인되지않았다.
			/*
			 * 로그인 페이지로 강제로 리다이렉트 했다면 로그인 성공후에 원래 가려던
			 * 목적지로 다시 보내야하고
			 * GET 방식 전송되는 파라미터가 있다면 파라미터 정보도 같이 가지고 다녀야 한다. 
			 * 파라미터도 끌고가야한다.
			 */
			
			//원래 가려던 url 정보 읽어보기
			String url = req.getRequestURI();
			//Get 방식 전송 파라미터를 query string으로 얻어오기
			String query = req.getQueryString();
			//인코딩을 한다.
			String encodedUrl = null;
			if(query == null) { //전송 파라미터가 없다면 
				encodedUrl = URLEncoder.encode(url);
			}else {
				encodedUrl = URLEncoder.encode(url + "?" + query);
			}
			//로그인 폼으로 리다이렉트 이동하라고 응답
			HttpServletResponse res = (HttpServletResponse)response;
			String cPath = req.getContextPath();
			res.sendRedirect(cPath + "/users/loginform.do?url=" + encodedUrl);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
