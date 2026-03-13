package kr.GenAi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.GenAi.web.dto.BoardCreateRequest;
import kr.GenAi.web.entity.Board;
import kr.GenAi.web.service.BoardService;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/board")
// @CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*") 
@CrossOrigin(origins = "http://10.1.1.6", allowedHeaders = "*") // 비동기통신 공인서버의 사설 IP입력
public class BoardRestController {
	
	@Autowired
	private BoardService service;

	@GetMapping("/")
	public String index() {
		return "Hello~Spring Boot!";
	}
	
	@GetMapping("/list")
	public List<Board> list() {
		
		System.out.println(service.getList());
		
		return  service.getList();
	}
	
	@PostMapping(value="/register", consumes = "multipart/form-data")
	public String register(@ModelAttribute BoardCreateRequest req) throws Exception {
		
		System.out.println("제목>>" + req);
		
		try {
			service.register(req);
			return "success";
		
		}catch (Exception e) {
			return "fail";
		}
		
	}
	
	
}
