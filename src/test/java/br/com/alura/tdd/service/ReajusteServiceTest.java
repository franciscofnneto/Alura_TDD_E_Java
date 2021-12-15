package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	//Inicializar as variáveis (roda antes de cada @Test)
	@BeforeEach
	public void inicializar() {
		System.out.println("Inicializa!");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Francisco", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	//Roda depois de cada @Test
	@AfterEach
	public void fim() {
		System.out.println("Fim!");
	}
	
	//Roda antes de TODOS os @Test
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS OS TESTES");
	}
	
	//Roda depois de TODOS os @Test
		@AfterAll
		public static void depoisDeTodos() {
			System.out.println("DEPOIS DE TODOS OS TESTES");
		}

	@Test
	// Reajuste de 3% quando o desempenho do funcionário for "A Desejar"
	public void reajusteTresPorcento() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	// Reajuste de 15% quando o desempenho do funcionário for "Bom"
	public void reajusteQuinzePorcento() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	// Reajuste de 20% quando o desempenho do funcionário for "Ótimo"
	public void reajusteVintePorcento() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
