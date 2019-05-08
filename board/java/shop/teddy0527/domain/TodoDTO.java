package shop.teddy0527.domain;

import java.util.Date;


import lombok.Data;

@Data
public class TodoDTO {
	private String title;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
}
