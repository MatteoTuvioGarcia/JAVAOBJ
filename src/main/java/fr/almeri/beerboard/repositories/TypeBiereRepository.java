package fr.almeri.beerboard.repositories;

import fr.almeri.beerboard.models.TypeBiere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBiereRepository extends CrudRepository<TypeBiere,String> {
}
