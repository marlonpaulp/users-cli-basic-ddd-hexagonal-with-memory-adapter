package com.jcaa.udec.collections.domain.port.out;
import com.jcaa.udec.collections.domain.core.model.Bien;
import java.util.List;

public interface ObtenerBienesPort {
    List<Bien> obtenerTodos();
    Bien buscarPorId(String id);
}
