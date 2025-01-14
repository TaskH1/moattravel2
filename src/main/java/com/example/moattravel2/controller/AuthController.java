package com.example.moattravel2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.moattravel2.form.SignupForm;
import com.example.moattravel2.service.UserService;

@Controller
public class AuthController {
	private final UserService userService;
	
	//Inject the UerServce dependency into the AuthController
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "auth/signup";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute @Validated SignupForm signupForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		//if email is already registered, add the error to BindingResult object
		if(userService.isEmailRegistered(signupForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録ずみのメールアドレスです");
			bindingResult.addError(fieldError);
		}
		
		//if password and passwordConfirmation aren't matched, add error to the BindingResult object
		if(!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが一致しません。");
			bindingResult.addError(fieldError);
		}
		
		if (bindingResult.hasErrors()) {
			return "auth/signup";
		}
		
		userService.create(signupForm);
		redirectAttributes.addFlashAttribute("successMessage", "会員登録が完了しました。");
		
		return "redirect:/";
		
	}

}
