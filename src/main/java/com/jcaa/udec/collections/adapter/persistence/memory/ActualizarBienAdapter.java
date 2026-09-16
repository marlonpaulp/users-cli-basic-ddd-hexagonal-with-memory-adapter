package com.jcaa.udec.collections.adapter.persistence.memory;
import com.jcaa.udec.collections.domain.core.exception.BienNoExisteException;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.ActualizarBienPort;
import java.util.List;
import java.util.Objects;

public class ActualizarBienAdapter implements ActualizarBienPort {
    private final List<Bien> bienes = BienesMemoria.obtenerBienes();

    @Override
    public void actualizar(Bien bien) {
        for (int i = 0; i < bienes.size(); i++) {
            if (Objects.equals(bienes.get(i).getId(), bien.getId())) {
                bienes.set(i, bien);
                return;
            }
        }

        throw new BienNoExisteException();
    }

}
