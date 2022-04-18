package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	@GetMapping("/http/lombok")
	public String getLombok() {
		Member m = Member.builder().username("test").email("email").password("1234").build();
		return "롬복테스트";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 : "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	@PostMapping("/http/post") 
	public String postTest(@RequestBody Member m) {
		return "post 요청 : "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
