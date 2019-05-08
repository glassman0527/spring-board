package shop.teddy0527.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
	private int tno;
	private String owner;
	private String grade;
}
