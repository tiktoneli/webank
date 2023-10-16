package br.com.webank.webank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webank.webank.dto.contaBancaria.ContaBancariaRequestDTO;
import br.com.webank.webank.dto.contaBancaria.ContaBancariaResponseDTO;
import br.com.webank.webank.model.ContaBancaria;
import br.com.webank.webank.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @Autowired
    private ModelMapper mapper;


    public List<ContaBancariaResponseDTO> obterTodos() {

        // bucas todas as contas no repo, jogar pra uma variável array
        List<ContaBancaria> contasModel = contaBancariaRepository.findAll();

        // criar outra variável array vazia que vai receber as contas convertidas pra
        // DTO
        List<ContaBancariaResponseDTO> contasResponse = new ArrayList<>();

        for (ContaBancaria contas : contasModel) {
            // pra cada conta no repo, converter pro DTO de respostas e tacar na variável
            // que foi criada vazia
            contasResponse.add(mapper.map(contas, ContaBancariaResponseDTO.class));
            // converter 1- o quê?, 2- pra que?
        }

        return contasResponse;
    }

    public ContaBancariaResponseDTO obterPorId(long id) {
        Optional<ContaBancaria> optContaBancaria = contaBancariaRepository.findById(id);

        if (optContaBancaria.isEmpty()) {
            throw new RuntimeException("Nenhum registro encontrado para o ID: " + id);
        }

        // tira da caixa, converte e retorna.
        return mapper.map(optContaBancaria.get(), ContaBancariaResponseDTO.class);
    }

    // O save serve tanto para adicionar quanto para atualizar.
    // se tiver id, ele atualiza, s enão tiver id ele adiciona.
    public ContaBancariaResponseDTO adicionar(ContaBancariaRequestDTO contaBancariaRequest) {

        ContaBancaria contaModel = mapper.map(contaBancariaRequest, ContaBancaria.class);
        contaModel = contaBancariaRepository.save(contaModel);

        // contaBancariaRequest.setId(0);
        return mapper.map(contaModel, ContaBancariaResponseDTO.class);
    }

    public ContaBancariaResponseDTO atualizar(long id, ContaBancariaRequestDTO contaBancariaRequest) {

        // Se não lançar exception é porque o cara existe no banco.
        ContaBancariaResponseDTO encontrada = obterPorId(id);
        contaBancariaRequest.setIdTitular(encontrada.getIdTitular());
        ContaBancaria contaModel = mapper.map(contaBancariaRequest, ContaBancaria.class);
        
        contaModel.setId(id);
        contaBancariaRepository.save(contaModel);
        return mapper.map(contaModel, ContaBancariaResponseDTO.class);
    }

    public void deletar(Long id) {
        obterPorId(id);

        contaBancariaRepository.deleteById(id);
    }

}
