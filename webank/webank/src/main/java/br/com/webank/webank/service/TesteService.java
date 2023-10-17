package br.com.webank.webank.service;

import java.util.List;

import br.com.webank.webank.dto.endereco.EnderecoRequestDTO;
import br.com.webank.webank.dto.endereco.EnderecoResponseDTO;

public class TesteService implements CRUDService<EnderecoRequestDTO, EnderecoResponseDTO>{

    @Override
    public List<EnderecoResponseDTO> obterTodos() {

        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }

    @Override
    public EnderecoResponseDTO obterPorId(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'obterPorId'");
    }

    @Override
    public EnderecoResponseDTO adicionar(EnderecoRequestDTO requestDto) {

        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }

    @Override
    public EnderecoResponseDTO atualizar(long id, EnderecoRequestDTO requestDto) {

        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(long id) {

        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
