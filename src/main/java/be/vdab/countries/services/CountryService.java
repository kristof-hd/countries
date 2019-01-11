package be.vdab.countries.services;

import java.util.Optional;

import be.vdab.countries.entities.Country;

public interface CountryService {
	Optional<Country> read(String code);
}
