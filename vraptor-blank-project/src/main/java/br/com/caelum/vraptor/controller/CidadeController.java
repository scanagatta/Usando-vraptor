package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.modelo.Banco;
import br.edu.unoesc.modelo.Cidade;

@Controller
@Path("/cidade")
public class CidadeController {

	@Inject
	private Result result;

	// tem que ter sempre esse primeiro metodo em branco é a primeira URL
	// ele vai ir para a pag jsp onde de lá o form envia os dados para o metodo
	// cadastrar
	@Get("/formulario")
	public void formulario() {
	}

	

	@Post("/cadastrar")
	public void cadastrar(Cidade cidade) {
		Banco.cidades.add(cidade);
		// chama o jsp que mostra a lista
		result.redirectTo(this).listar();
	}
	
	@Get("/listar")
	public void listar() {
		// seta na variavel do jsp a lista
		result.include("cidades", Banco.cidades);

	}


}
