package com.fiap.Java_GlobalSolution;

import com.fiap.Java_GlobalSolution.model.*;
import com.fiap.Java_GlobalSolution.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class JavaGlobalSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGlobalSolutionApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(
			SensorRepository sensorRepository,
			AlertaRepository alertaRepository,
			UsuarioRepository usuarioRepository,
			AreaRiscoRepository areaRiscoRepository,
			EquipeRespostaRepository equipeRespostaRepository
	) {
		return args -> {
			// Áreas de risco
			AreaRisco area1 = areaRiscoRepository.save(AreaRisco.builder()
					.nomeArea("Zona Leste")
					.tipoRisco("Incêndio")
					.latitude(-23.55)
					.longitude(-46.60)
					.descricao("Área industrial com risco de incêndio")
					.statusArea("Ativo")
					.build());

			AreaRisco area2 = areaRiscoRepository.save(AreaRisco.builder()
					.nomeArea("Zona Norte")
					.tipoRisco("Inundação")
					.latitude(-23.50)
					.longitude(-46.62)
					.descricao("Área residencial sujeita a enchentes")
					.statusArea("Ativo")
					.build());

			AreaRisco area3 = areaRiscoRepository.save(AreaRisco.builder()
					.nomeArea("Centro Antigo")
					.tipoRisco("Desabamento")
					.latitude(-23.54)
					.longitude(-46.63)
					.descricao("Prédios antigos com risco estrutural")
					.statusArea("Ativo")
					.build());

			// Usuários
			Usuario usuario1 = usuarioRepository.save(Usuario.builder()
					.nome("João Silva")
					.email("joao.silva@email.com")
					.telefone("11999990001")
					.cargo("Coordenador")
					.senha("senha1")
					.ativo('S')
					.build());

			Usuario usuario2 = usuarioRepository.save(Usuario.builder()
					.nome("Maria Souza")
					.email("maria.souza@email.com")
					.telefone("11999990002")
					.cargo("Técnica")
					.senha("senha2")
					.ativo('S')
					.build());

			// Usuario3 é apenas usuário do sistema (não vinculado à equipe)
			Usuario usuario3 = usuarioRepository.save(Usuario.builder()
					.nome("Carlos Pereira")
					.email("carlos.pereira@email.com")
					.telefone("11999990003")
					.cargo("Supervisor")
					.senha("senha3")
					.ativo('S')
					.build());

			// Equipe de resposta (com dois usuários)
			EquipeResposta equipe = equipeRespostaRepository.save(EquipeResposta.builder()
					.nomeEquipe("Alfa")
					.areaAtuacao("Zona Leste")
					.contato("11988880001")
					.usuarios(Arrays.asList(usuario1, usuario2))
					.build());

			// Sensores
			sensorRepository.save(Sensor.builder()
					.tipoSensor("Temperatura")
					.marca("Acme")
					.localizacao("Galpãos")
					.unidadeMedida("Celsius")
					.dataInstalacao(LocalDate.now())
					.statusSensor("Ativo")
					.valorLidoSensor(25.0)
					.dataHoraLeituraSensor(LocalDateTime.now())
					.areaRisco(area1)
					.build());

			sensorRepository.save(Sensor.builder()
					.tipoSensor("Umidade")
					.marca("Acme")
					.localizacao("Cobertura")
					.unidadeMedida("Percentual")
					.dataInstalacao(LocalDate.now())
					.statusSensor("Ativo")
					.valorLidoSensor(80.0)
					.dataHoraLeituraSensor(LocalDateTime.now())
					.areaRisco(area2)
					.build());

			sensorRepository.save(Sensor.builder()
					.tipoSensor("Movimentação")
					.marca("Acme")
					.localizacao("Subterrâneo")
					.unidadeMedida("Movimentos/min")
					.dataInstalacao(LocalDate.now())
					.statusSensor("Ativo")
					.valorLidoSensor(2.0)
					.dataHoraLeituraSensor(LocalDateTime.now())
					.areaRisco(area3)
					.build());

			// Alertas fictícios
			alertaRepository.save(Alerta.builder()
					.nomeTipoAlerta("Temperatura Alta")
					.descricaoTipoAlerta("Detectada temperatura acima do permitido")
					.nivelGravidadeAlerta(3)
					.dataGeracao(LocalDate.now())
					.mensagem("Temperatura perigosa no galpão!")
					.statusAlerta("Ativo")
					.valorGatilho(60.0)
					.dataInicioAtuacao(LocalDateTime.now())
					.dataFimAtuacao(null)
					.observacaoAtuacao("Aguardando vistoria.")
					.areaRisco(area1)
					.equipeResposta(equipe)
					.build());

			alertaRepository.save(Alerta.builder()
					.nomeTipoAlerta("Alagamento")
					.descricaoTipoAlerta("Umidade excessiva detectada")
					.nivelGravidadeAlerta(2)
					.dataGeracao(LocalDate.now())
					.mensagem("Risco de alagamento identificado!")
					.statusAlerta("Ativo")
					.valorGatilho(90.0)
					.dataInicioAtuacao(LocalDateTime.now())
					.dataFimAtuacao(null)
					.observacaoAtuacao("Monitorar nível de água.")
					.areaRisco(area2)
					.equipeResposta(equipe)
					.build());

			alertaRepository.save(Alerta.builder()
					.nomeTipoAlerta("Risco de Desabamento")
					.descricaoTipoAlerta("Estrutura comprometida detectada por sensores.")
					.nivelGravidadeAlerta(4)
					.dataGeracao(LocalDate.now())
					.mensagem("Atenção: Estrutura do prédio pode ceder. Evacuação recomendada!")
					.statusAlerta("Ativo")
					.valorGatilho(1.0)
					.dataInicioAtuacao(LocalDateTime.now())
					.dataFimAtuacao(null)
					.observacaoAtuacao("Isolar o local e acionar Defesa Civil.")
					.areaRisco(area3)
					.equipeResposta(equipe)
					.build());

			System.out.println("Dados Salvos");

		};
	}

}
