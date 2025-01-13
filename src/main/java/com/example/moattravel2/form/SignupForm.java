package com.example.moattravel2.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "氏名を入力して下さい")
	private String name;
	
	@NotBlank(message = "フリガナを入力して下さい。")
	private String furigana;
	
	@NotBlank(message = "郵便番号を入力して下さい")
	private String postalCode;
	
	@NotBlank(message = "住所を入力して下さい")
	private String address;
	
	@NotBlank(message = "電話番号を入力して下さい")
	private String phoneNumber;
	
	@NotBlank(message = "メールアドレスを入力して下さい")
	@Email(message = "メールアドレスは正しい形式で入力して下さい")
	private String email;
	
	@NotBlank(message = "パスワードを入力して下さい。")
	@Length(min = 8, message = "パスワードは8文字以上で入力して下さい")
	private String password;
	
	@NotBlank(message = "パスワード（確認用）を入力して下さい")
	private String passwordConfirmation;

}
