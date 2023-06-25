package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.BookService;
import com.example.demo.Service.RentalService;
import com.example.demo.Service.auth.CustomDetails;

@Controller
@RequestMapping("/rental")
public class RentalController {
//
//	
	@Autowired
	RentalService rentalService;
	@Autowired
	BookService bookService;

	@GetMapping("/rentalview")
	public String moveRentalView(
			//spring Securityフレームワークを使用して認証されたユーザーの情報を取得するためのアノテーション
			//CustomDetailsはサービスのauthの中にある
			@AuthenticationPrincipal CustomDetails user_info, Model model) {
		//レンタルIDを格納する変数を宣言。ユーザー情報からユーザーIDを取得する。
		int rental_key_id = user_info.getUserList().getUser_id();
		model.addAttribute("RentalBooks", rentalService.findRentalBook(rental_key_id));
		return "rental";
		
	}
	
	@PostMapping("/{book_id}")
	public String rentalBook(
			@AuthenticationPrincipal CustomDetails user_info,
			@PathVariable int book_id) {
		int rental_key_id = user_info.getUserList().getUser_id();
		
		rentalService.rentalBook(rental_key_id, book_id);
		bookService.rentalBook(book_id);
				return null;
		
	}
	
}
