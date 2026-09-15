package com.jcaa.udec.collections.adapter.persistence.memory;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.ObtenerBienesPort;
import java.util.List;
import java.util.Objects;

public class ObtenerBienesAdapter implements ObtenerBienesPort {
    private final List<Bien> bienes = BienesMemoria.obtenerBienes();

    @Override
    public List<Bien> obtenerTodos() {
        return List.copyOf(bienes);
    }

    @Override
    public Bien buscarPorId(String id) {
        for (Bien bien : bienes) {
            if (Objects.equals(bien.getId(), id)) {
                return bien;
            }
        }
        throw new RuntimeException("El bien no existe");
    }
}
