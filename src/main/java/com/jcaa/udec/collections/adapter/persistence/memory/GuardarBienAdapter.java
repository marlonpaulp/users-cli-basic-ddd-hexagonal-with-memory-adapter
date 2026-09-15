package com.jcaa.udec.collections.adapter.persistence.memory;
import com.jcaa.udec.collections.domain.core.model.Bien;
import com.jcaa.udec.collections.domain.port.out.GuardarBienPort;
import java.util.List;
import java.util.Objects;

public class GuardarBienAdapter implements GuardarBienPort {
    private final List<Bien> bienes = BienesMemoria.obtenerBienes();

    @Override
    public void guardar(Bien bien) {
        for (Bien bienRegistrado : bienes) {
            if (Objects.equals(bienRegistrado.getId(), bien.getId())) {
                throw new RuntimeException("El bien ya existe");
            }
        }

        bienes.add(bien);
    }

}
