package br.com.webank.webank.service;

import java.util.List;

public interface CRUDService<Req, Res> {
    
    List<Res> obterTodos();

    Res obterPorId(Long id);

    Res adicionar(Req requestDto);

    Res atualizar(long id, Req requestDto);

    void deletar(long id);

}
