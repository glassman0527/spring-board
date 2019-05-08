package shop.teddy0527.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
public class Hotel {
	private Chef chef;
	
	public Hotel(Chef chef) {
		this.chef = chef;
	}
}
