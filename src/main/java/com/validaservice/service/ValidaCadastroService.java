package com.validaservice.service;

import com.validaservice.model.UsuarioDto;
import com.validaservice.model.ValidacaoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidaCadastroService {

    public ValidacaoResponse validar(UsuarioDto usuarioDto){
        if(usuarioDto.getNome() == "pedro"){
            return new ValidacaoResponse(usuarioDto,true, List.of("Nenhum erro"));
        }else {
            return new ValidacaoResponse(usuarioDto,false,List.of("Nao é o pedro"));
        }
    }
}
