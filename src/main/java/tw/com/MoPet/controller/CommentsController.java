package tw.com.MoPet.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.MoPet.model.Comments;
import tw.com.MoPet.service.CommentsService;
import tw.com.MoPet.service.RepliesService;

@Controller

public class CommentsController {

	@Autowired
	private CommentsService cService;
	
	@Autowired
	private RepliesService rService;
	
	@GetMapping("comments/findAll")
	@ResponseBody
	public List<Comments> findAll(){
		return cService.findAll();
	}
	
	@PostMapping("comments/add") //post送出資料
	public String addComment(@ModelAttribute("comments") Comments comments,Model model) {
		cService.insertComment(comments);
		
		Comments newcomment = new Comments();
		
		Comments lastest = cService.getLastest();
		
		model.addAttribute("comments", newcomment);
		model.addAttribute("lastest", lastest);
		
		return "redirect:/comments/all";
	}
	
	@GetMapping("comments/edit")
	public String editComment(@RequestParam("id") Integer id,Model model) {
		
		Comments comment = cService.findById(id);
		
		model.addAttribute("commemt", comment);
		
		return "editComments";
	}
	
	@PostMapping("comments/edit")
	public String postEditComments(@ModelAttribute(name="comment") Comments comment) {
		
		//取得現在時間
		   Date now = Calendar.getInstance().getTime();
		
		   comment.setCreateondate(now);
		
		cService.insertComment(comment);
		
		return "redirect:/comments/all";
	}
	
	@GetMapping("comments/delete")
	public String deleteComment(@RequestParam("id")Integer id) {
		
		cService.deleteComment(id);
		
		return "redirect:/comments/all";
	}
	
	
	

	
}
