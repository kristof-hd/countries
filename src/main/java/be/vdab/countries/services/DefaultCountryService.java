package be.vdab.countries.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.countries.entities.Country;
import be.vdab.countries.repositories.CountryRepository;

@Service
@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
class DefaultCountryService implements CountryService {

	private final CountryRepository repository;
	
	DefaultCountryService(CountryRepository repository) {
		this.repository=repository; 
	}
	
	@Override
	public Optional<Country> read(String code) {
		return repository.findByCode(code);
	}
	
}