package br.com.mercadolivre.repository;

import br.com.mercadolivre.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsById(Long id);
}
