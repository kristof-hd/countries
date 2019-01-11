package be.vdab.countries.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.countries.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	Optional<Country> findByCode(String code);
}
