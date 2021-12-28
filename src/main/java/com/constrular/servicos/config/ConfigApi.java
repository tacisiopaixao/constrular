package com.constrular.servicos.config;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.constrular.servicos.entities.Contato;
import com.constrular.servicos.entities.PoliticaDePrivacidade;
import com.constrular.servicos.entities.TermosDeUso;
import com.constrular.servicos.repositories.ContatoRepository;
import com.constrular.servicos.repositories.PoliticaDePrivacidadeRepository;
import com.constrular.servicos.repositories.TermosDeUsoRepository;

@Configuration
public class ConfigApi {

	@Autowired
	private PoliticaDePrivacidadeRepository politicaDePrivacidadeRepository;
	
	@Autowired
	private TermosDeUsoRepository termosDeUsoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	

	@PostConstruct
	public void bla() {

		//Politica de Privacidade.
	 List<PoliticaDePrivacidade> lista = politicaDePrivacidadeRepository.findAll();

		if (lista.size() == 0) {

			String pdp = "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.";
			PoliticaDePrivacidade p = new PoliticaDePrivacidade();
			p.setDescription(pdp);

			politicaDePrivacidadeRepository.save(p);
		}
		
		
		//Temos de Uso.
		List<TermosDeUso> lista1 = termosDeUsoRepository.findAll();

		if (lista1.size() == 0) {

			String pdp1 = "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.";
			TermosDeUso q = new TermosDeUso();
			q.setDescription(pdp1);

			termosDeUsoRepository.save(q);
		}
		//Contatos.
		
			Contato cont = new Contato();
			
		
			cont.setNome("Tarcisio");
			cont.setEmail("tarcisio.santostj@hotmail.com");
			cont.setData(LocalDateTime.now());
			cont.setMensagem("Olá tudo bem, o programas está funcionando normalmente");
			
			contatoRepository.save(cont);
		
	}
}
