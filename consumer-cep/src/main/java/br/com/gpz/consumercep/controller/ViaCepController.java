package br.com.gpz.consumercep.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.gpz.consumercep.dto.EnderecoDTO;

@RestController
public class ViaCepController implements Serializable {

	private static final long serialVersionUID = 1L;

	@GetMapping(value = "/getCep/{cep}")
	public ResponseEntity<EnderecoDTO> doObterCep(@PathVariable(name = "cep") String cep) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = "http://viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);

		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);

		return new ResponseEntity<EnderecoDTO>(enderecoDTO, HttpStatus.OK);
	}
}