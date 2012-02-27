package br.com.codeit.dojo.test;
import org.junit.Assert;
import org.junit.Test;

import br.com.codeit.dojo.ContadorPalitos;


public class ContadorPalitosTest {
	
	@Test
	public void testContaPalitosNotNull() {
		Assert.assertNotNull(new ContadorPalitos().contar(9));
	}
	
	@Test
	public void testSolucaoOtimaParaEntradasSemOperacao() {
		Assert.assertEquals("|", new ContadorPalitos().contar(1));
		Assert.assertEquals("||", new ContadorPalitos().contar(2));
		Assert.assertEquals("|||", new ContadorPalitos().contar(3));
	}
	
	@Test
	public void testSolucaoRaizExata() {
		Assert.assertEquals("|||x|||", new ContadorPalitos().contar(9));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContaPalitosValorNegativo() {
		new ContadorPalitos().contar(-9);
	}
	
	@Test
	public void testContaPalitosComZero() {
		Assert.assertEquals("", new ContadorPalitos().contar(0));
	}

	@Test
	public void testSolucaoNumeroPrimo() {
		Assert.assertEquals("|||||||", new ContadorPalitos().contar(7));
		Assert.assertEquals("|||||||||||||", new ContadorPalitos().contar(13));
	}
	
	@Test
	public void testSolucaoNaoPrimoENaoRaizExata() {
		Assert.assertEquals("||||x|||||", new ContadorPalitos().contar(20));
		Assert.assertEquals("|||x||||||", new ContadorPalitos().contar(18));
		Assert.assertEquals("|||x|||||", new ContadorPalitos().contar(15));
	}
}
