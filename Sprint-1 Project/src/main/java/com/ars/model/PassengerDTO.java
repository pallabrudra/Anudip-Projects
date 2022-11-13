package com.ars.model;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PassengerDTO extends UserDTO{
	
	@NotNull(message = "{p.name.check}")
	@Size(min = 2, message = "{p.size.check}")
	private String name;

	@NotNull(message = "{p.phno.check}")
	@Size(max = 10,message = "{p.phnosize.check}")
	private String phno;
	
	@NotNull(message = "{p.email.check}")
	@Email
	private String email;

	public PassengerDTO(@NotNull @Size(min = 2, message = "{p.name.check}") String name,
			@NotNull @Size(max = 10, message = "{p.phno.check}") String phno,
			@NotNull @Size(min = 2, message = "{p.email.check}") @Email String email) {
		super();
		this.name = name;
		this.phno = phno;
		this.email = email;
	}

	
}
