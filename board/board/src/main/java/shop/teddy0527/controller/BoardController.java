package shop.teddy0527.controller;

import java.io.InputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.BoardVo;
import shop.teddy0527.domain.Criteria;
import shop.teddy0527.domain.PageDTO;
import shop.teddy0527.service.BoardService;

@Controller @Log4j @RequestMapping("/board/*") @AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model, @Qualifier("cri") Criteria cri) {
		log.info("list");
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVo vo, RedirectAttributes rttr) {
		log.info("register :: " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo vo, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		log.info("modify :: " + vo); 
		
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum()); getListLink
//		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		log.info("modify :: " + bno); 
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum()); getListLink
//		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@GetMapping("sample")
	public void sample() {}
	
	@GetMapping("proxy")
	public void proxy() {}
	
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://rss.joins.com/sonagi/joins_sonagi_world_list.xml");
		InputStream is = url.openStream();
		int b = 0;
		while((b = is.read()) != -1) {
			System.out.write(b);		
		}
		is.close();
	}
}
