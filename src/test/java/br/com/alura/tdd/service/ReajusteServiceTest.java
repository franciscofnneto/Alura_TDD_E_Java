package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	@Test
	// Reajuste de 3% quando o desempenho do funcionário for "A Desejar"
	public void reajusteTresPorcento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Francisco", LocalDate.now(), new BigDecimal("1000.00"));

		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	// Reajuste de 15% quando o desempenho do funcionário for "Bom"
	public void reajusteQuinzePorcento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Francisco", LocalDate.now(), new BigDecimal("1000.00"));

		service.concederReajuste(funcionario, Desempenho.BOM);

		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	// Reajuste de 20% quando o desempenho do funcionário for "Ótimo"
	public void reajusteVintePorcento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Francisco", LocalDate.now(), new BigDecimal("1000.00"));

		service.concederReajuste(funcionario, Desempenho.OTIMO);

		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
