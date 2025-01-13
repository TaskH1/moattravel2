package com.example.moattravel2.form;

import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HouseRegisterForm {
	@NotBlank(message = "民宿名を入力して下さい")
	private String name;
	
	private MultipartFile imageFile;
	
	@NotBlank(message = "説明を入力して下さい")
	private String description;
	
	@NotNull(message = "宿泊料金を入力して下さい")
	@Min(value = 1, message ="宿泊料金は１円以上に設定して下さい")
	private Integer price;
	
	@NotNull(message= "定員を入力して下さい")
	@Min(value = 1, message = "定員は１人以上に設定して下さい")
	private Integer capacity;
	
	@NotBlank(message = "郵便番号を入力して下さい")
	private String postalCode;
	
	@NotBlank(message = "住所を入力して下さい")
	private String address;
	
	@NotBlank(message = "電話番号を入力して下さい")
	private String phoneNumber;
}
