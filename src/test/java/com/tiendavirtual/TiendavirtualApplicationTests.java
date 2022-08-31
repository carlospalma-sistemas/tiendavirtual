package com.tiendavirtual;

import com.tiendavirtual.entidades.Categoria;
import com.tiendavirtual.servicios.CategoriaServicio;
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
    @Disabled
    void probarSiSeCreaUnaNuevaCategoria() {
        Categoria c = new Categoria("Camisas para dama", 1, true);
        Categoria guardado = servicio.crearNuevaCategoria(c);
        Assertions.assertTrue(guardado.getId() > 0, "ERROR, No se guardó el nuevo objeto");
    }

}
