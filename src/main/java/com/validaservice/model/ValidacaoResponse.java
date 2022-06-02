package com.validaservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ValidacaoResponse implements Serializable {
    private UsuarioDto usuarioDto;
    private boolean isValid;
    private List<String> error;

    public ValidacaoResponse(UsuarioDto usuarioDto, boolean isValid, List<String> error) {
        this.usuarioDto = usuarioDto;
        this.isValid = isValid;
        this.error = error;
    }
}
