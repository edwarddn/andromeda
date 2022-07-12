package br.com.triersistemas.andromeda.repository;

import br.com.triersistemas.andromeda.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
