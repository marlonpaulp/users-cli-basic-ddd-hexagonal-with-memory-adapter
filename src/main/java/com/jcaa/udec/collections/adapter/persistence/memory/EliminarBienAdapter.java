package com.jcaa.udec.collections.adapter.persistence.memory;
import com.jcaa.udec.collections.domain.core.exception.BienNoExisteException;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.EliminarBienPort;
import java.util.List;
import java.util.Objects;

public class EliminarBienAdapter implements EliminarBienPort {
    private final List<Bien> bienes = BienesMemoria.obtenerBienes();

    @Override
    public void eliminar(String id) {
        for (int i = 0; i < bienes.size(); i++) {
            if (Objects.equals(bienes.get(i).getId(), id)) {
                bienes.remove(i);
                return;
            }
        }

        throw new BienNoExisteException();
    }
}
