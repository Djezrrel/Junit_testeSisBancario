package negocio;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import negocio.ContaCorrente;
import negocio.GerenciadoraContas;
import java.util.ArrayList;
import java.util.List;

public class GerenciadoraContasTest {

    private GerenciadoraContas gerenciadoraContas;
    private List<ContaCorrente> contasDoBanco;

    @Before
    public void setUp() {
        contasDoBanco = new ArrayList<>();
        gerenciadoraContas = new GerenciadoraContas(contasDoBanco);
    }

    @Test
    public void testAdicionaConta() {
        ContaCorrente novaConta = new ContaCorrente(1, 100.0, true);
        gerenciadoraContas.adicionaConta(novaConta);

        List<ContaCorrente> contas = gerenciadoraContas.getContasDoBanco();
        assertTrue(contas.contains(novaConta));
    }

    @Test
    public void testRemoveConta() {
        ContaCorrente conta = new ContaCorrente(1, 100.0, true);
        contasDoBanco.add(conta);

        assertTrue(gerenciadoraContas.removeConta(1));

        List<ContaCorrente> contas = gerenciadoraContas.getContasDoBanco();
        assertFalse(contas.contains(conta));
    }

    @Test
    public void testContaAtiva() {
        ContaCorrente contaAtiva = new ContaCorrente(1, 100.0, true);
        ContaCorrente contaInativa = new ContaCorrente(2, 200.0, false);
        contasDoBanco.add(contaAtiva);
        contasDoBanco.add(contaInativa);

        assertTrue(gerenciadoraContas.contaAtiva(1));
        assertFalse(gerenciadoraContas.contaAtiva(2));
    }

    @Test
    public void testTransfereValor() {
        ContaCorrente contaOrigem = new ContaCorrente(1, 200.0, true);
        ContaCorrente contaDestino = new ContaCorrente(2, 100.0, true);
        contasDoBanco.add(contaOrigem);
        contasDoBanco.add(contaDestino);

        assertTrue(gerenciadoraContas.transfereValor(1, 100.0, 2));

        assertEquals(100.0, contaOrigem.getSaldo(), 0.001);
        assertEquals(200.0, contaDestino.getSaldo(), 0.001);
    }

    @Test
    public void testPesquisaConta() {
        ContaCorrente conta = new ContaCorrente(1, 100.0, true);
        contasDoBanco.add(conta);

        ContaCorrente encontrada = gerenciadoraContas.pesquisaConta(1);
        assertNotNull(encontrada);
        assertEquals(1, encontrada.getId());
    }
}
