package be.vdab.countries.exceptions;

public class InvalidCountryCodeException extends RuntimeException {

	private static final long serialVersionUID=1L; 

	public InvalidCountryCodeException(String code) {
		super("Invalid code:" + code); 
	} 
	
}
