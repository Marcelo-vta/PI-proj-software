package br.insper.ferramenta;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FerramentaRepository extends MongoRepository<Ferramenta, String> {
    Optional<Ferramenta> deleteByEmailUsuario(String email);
}
