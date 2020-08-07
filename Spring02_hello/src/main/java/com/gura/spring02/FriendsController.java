package com.gura.spring02;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendsController {

	@RequestMapping("/friends")
	public String friends(HttpServletRequest request) {
		String[] myfriends = {"최영훈","박지예","백준현"};
		request.setAttribute("myfriends", myfriends);
		return "friends"; //jsp주소
	}
}
