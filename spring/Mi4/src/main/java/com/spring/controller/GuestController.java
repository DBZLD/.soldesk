package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.GuestDto;
import com.spring.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")	//프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.  
@AllArgsConstructor	//2-1. 모든 매개 변수를 초기화 시켜주는 생성자 함수를 자동으로 생성함 
@Controller
public class GuestController {
	
	//2-2. 2-1 = public GuestController(GuestService service){
		// this.service = service;
	// }
	private GuestService service; // 1-1. GuestService는 인터페이스여서 service가 비어있기 때문에
							      // spring에서 자동으로 IoC컨테이너 에서 같은 타입의 Bean을 검색함
	
	@GetMapping("/getList")	// 프로젝트 루트 경로 이하 /guest/getList url 진입 시 여기로 진입하게 됨.
	public void getList(@RequestParam(value = "currentPage", defaultValue = "1")int currentPage, Model model) {	// 매개변수에 Model m 식으로 작성하게 되면, 스프링이 알아서 모델 객체를 만들어서 넘겨줌.
		model.addAttribute("blp", service.getList(currentPage));
	}	
	// 위 /getList 와 동일한 jsp파일을 염. 상위 경로 포함(/guest). 즉 PJ루트/guest/getList.jsp 파일을 염.
	// 그리고 이 파일은 
	// PJ\src\main\webapp\WEB-INF\views\guest\getList.jsp
	// 에 만들어 놓으면 됨.O
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		service.del(bno);
		return "redirect:/guest/getList";
	}
	@GetMapping("/write")
	public void write() {
		
	}
	@PostMapping("/write")
	public String write(GuestDto dto) {
		service.write(dto);
		return "redirect:/guest/getList";
	}
	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList";
	}
}