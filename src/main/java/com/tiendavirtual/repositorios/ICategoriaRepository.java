package com.tiendavirtual.repositorios;

import com.tiendavirtual.entidades.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    public List<Categoria> findByNombreContaining(String criterio);
    
}
