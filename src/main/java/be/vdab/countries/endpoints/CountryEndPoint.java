package be.vdab.countries.endpoints;

import java.util.Optional;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import be.vdab.countries.entities.Country;
import be.vdab.countries.exceptions.InvalidCountryCodeException;
import be.vdab.countries.services.CountryService;
import be.vdab.countries.soapmessages.GetCountryRequest;
import be.vdab.countries.soapmessages.GetCountryResponse;

@Endpoint
public class CountryEndPoint {
	private static final String NAMESPACE_URI = "http://www.be.vdab.countries";
	private final CountryService countryService;

	CountryEndPoint(CountryService countryService) {
		this.countryService = countryService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	public @ResponsePayload GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		Optional<Country> optionalCountry = countryService.read(request.getCode());
		if (!optionalCountry.isPresent()) {
			throw new InvalidCountryCodeException(request.getCode());
		}

		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryEntityToCountryDTO(optionalCountry.get()));
		return response;

	}

	private be.vdab.countries.soapmessages.Country countryEntityToCountryDTO(Country country) {
		be.vdab.countries.soapmessages.Country dto = new be.vdab.countries.soapmessages.Country();
		dto.setName(country.getName());
		dto.setCapital(country.getCapital());
		return dto;
	}

}