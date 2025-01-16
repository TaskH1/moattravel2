package com.example.moattravel2.form;

import java.time.LocalDate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	@NotBlank(message = "チェックイン日とチェックアウト日を選択して下さい。")
	private String fromCheckinDateToCheckoutDate;
	
	@NotNull(message = "宿泊人数を入力して下さい")
	private Integer numberOfPeople;
	
	//get checkin date
	public LocalDate getCheckinDate() {
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split(" to ");
		return LocalDate.parse(checkinDateAndCheckoutDate[0]);
	}
	
	//get checkout date
	public LocalDate getCheckoutDate() {
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split(" to ");
		return LocalDate.parse(checkinDateAndCheckoutDate[1]);
	}
 	

}
