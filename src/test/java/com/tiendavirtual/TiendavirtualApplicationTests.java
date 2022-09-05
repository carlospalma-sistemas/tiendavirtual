package com.tiendavirtual;

import com.tiendavirtual.entidades.Categoria;
import com.tiendavirtual.servicios.CategoriaServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendavirtualApplicationTests {

    @Autowired
    private CategoriaServicio servicio;
    
    @Test
    void probarSiSeCreaUnaNuevaCategoria() {
        Categoria c = new Categoria("Camisas para dama", 1, true);
        Assertions.assertDoesNotThrow(() -> servicio.crearNuevaCategoria(c), "Error al guardar nueva categoría. ");
    }

    @Test
    @Disabled
    void probarSiEncuentroDamaEnCategorias() {
        List<Categoria> listado = servicio.consultarCategorias("dama");
        Assertions.assertTrue(listado.size() > 0, "Error, no se encontró categoría con la palabra dama");
    }
    
    @Test
    @Disabled
    void probarSiEncuentroCategoriaConId1() {
        Categoria encontrado = servicio.consultarCategorias(1);
        Assertions.assertNotNull(encontrado, "ERROR, no se encontró categoría con id 1");
    }
}
