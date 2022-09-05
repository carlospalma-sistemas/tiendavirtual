package com.tiendavirtual;

import com.tiendavirtual.entidades.Categoria;
import com.tiendavirtual.servicios.CategoriaServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class TiendavirtualApplicationTests {

    @Autowired
    private CategoriaServicio servicio;
    
    //------------- PRUEBAS DE CREACIÓN -----------------
    
    @Test
    @Disabled("Registro creado y probado")
    void probarSiSeCreaUnaNuevaCategoria() {
        Categoria c = new Categoria("Camisas para dama", 1, true);
        Assertions.assertDoesNotThrow(()-> {
            servicio.crearNuevaCategoria(c);
        }, "No se pudo crear una nueva categoría");
    }
    
    @Test
    void probarSiNoSeCreaUnaCategoriaRepetida() {
        Categoria c = new Categoria("Camisas para dama", 1, true);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevaCategoria(c);
        }, "Se esperaba error de violación de integridad");
    }
    
    @Test
    void probarSiNoSeCreaUnaCategoriaNoValida() {
        Categoria c = new Categoria(null, 1, true);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevaCategoria(c);
        }, "Se esperaba error de violación de integridad");
    }

    //------------- PRUEBAS DE BÚSQUEDA -----------------
    
    @Test
    void probarSiEncuentroCategorias() {
        List<Categoria> listado = servicio.consultarCategorias();
        Assertions.assertTrue(listado.size() > 0, "No se encontraron categorías");
    }
    
    @Test
    void probarSiEncuentroCategoriaEspecifica() {
        List<Categoria> listado = servicio.consultarCategorias("dama");
        Assertions.assertTrue(listado.size() > 0, "No se encontró categoría con la palabra dama");
    }
    
    @Test
    void probarSiNoEncuentroCategoriaEspecifica() {
        List<Categoria> listado = servicio.consultarCategorias("XYZ");
        Assertions.assertTrue(listado.isEmpty(), "Se encontró categoría XYZ que no existe");
    }
    
    @Test
    void probarSiEncuentroCategoriaConId() {
        Categoria encontrado = servicio.consultarCategorias(1);
        Assertions.assertNotNull(encontrado, "No se encontró categoría con id 1");
    }
    
    @Test
    void probarSiNoEncuentroCategoriaConId() {
        Categoria encontrado = servicio.consultarCategorias(1000000);
        Assertions.assertNull(encontrado, "Se encontró categoría con id 1000000 que no existe");
    }
    
    //------------- PRUEBAS DE ACTUALIZACIÓN -----------------
    
    @Test
    void probarSiActualizoUnaCategoriaExistente() {
        Categoria encontrado = servicio.consultarCategorias(1);
        boolean valorInicial = encontrado.isHab();
        encontrado.setHab(!valorInicial);
        servicio.actualizarCategoria(encontrado);
        
        Categoria actualizado = servicio.consultarCategorias(1);
        Assertions.assertEquals(actualizado.isHab(), !valorInicial, "No se actualizó hab en categoría 1");
    }
    
    @Test
    void probarSiNoActualizoUnaCategoriaExistenteConDataInvalida() {
        Categoria encontrado = servicio.consultarCategorias(1);
        encontrado.setNombre(null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.actualizarCategoria(encontrado);
        }, "Se esperaba error de violación de integridad");
    }
}
