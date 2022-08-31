package com.tiendavirtual.servicios;

import com.tiendavirtual.entidades.Categoria;
import com.tiendavirtual.repositorios.ICategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio {
    
    @Autowired
    private ICategoriaRepository repo;
    
    public Categoria crearNuevaCategoria(Categoria c) {
        Categoria cat = repo.save(c);
        return cat;
    }
    
    public List<Categoria> consultarCategorias() {
        List<Categoria> lista = repo.findAll();
        return lista;
    }
    
    public List<Categoria> consultarCategorias(String criterio) {
        List<Categoria> lista = repo.findByNombreContaining(criterio);
        return lista;
    }
    
    public Categoria consultarCategorias(int id) {
        Categoria c = repo.findById(id).get();
        return c;
    }
    
    public Categoria actualizarCategoria(Categoria c) {
        Categoria cat = repo.save(c);
        return cat;
    }
    
    public void eliminarCategoria(Categoria c) {
        repo.deleteById(c.getId());
    }
}
