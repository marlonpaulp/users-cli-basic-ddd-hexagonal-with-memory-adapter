package com.jcaa.udec.collections.application.service.ports.in;
import com.jcaa.udec.collections.domain.core.model.Bien;
import java.util.List;

public interface ListarBienesUseCase {
    List<Bien> listar();
}
