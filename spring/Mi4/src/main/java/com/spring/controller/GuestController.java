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
@RequestMapping("/guest/*")	//������Ʈ ��Ʈ ��� ���� /guest ���������� ���� �� ����� �����ϰ� ��.  
@AllArgsConstructor	//2-1. ��� �Ű� ������ �ʱ�ȭ �����ִ� ������ �Լ��� �ڵ����� ������ 
@Controller
public class GuestController {
	
	//2-2. 2-1 = public GuestController(GuestService service){
		// this.service = service;
	// }
	private GuestService service; // 1-1. GuestService�� �������̽����� service�� ����ֱ� ������
							      // spring���� �ڵ����� IoC�����̳� ���� ���� Ÿ���� Bean�� �˻���
	
	@GetMapping("/getList")	// ������Ʈ ��Ʈ ��� ���� /guest/getList url ���� �� ����� �����ϰ� ��.
	public void getList(@RequestParam(value = "currentPage", defaultValue = "1")int currentPage, Model model) {	// �Ű������� Model m ������ �ۼ��ϰ� �Ǹ�, �������� �˾Ƽ� �� ��ü�� ���� �Ѱ���.
		model.addAttribute("blp", service.getList(currentPage));
	}	
	// �� /getList �� ������ jsp������ ��. ���� ��� ����(/guest). �� PJ��Ʈ/guest/getList.jsp ������ ��.
	// �׸��� �� ������ 
	// PJ\src\main\webapp\WEB-INF\views\guest\getList.jsp
	// �� ����� ������ ��.O
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ==============="+bno);
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