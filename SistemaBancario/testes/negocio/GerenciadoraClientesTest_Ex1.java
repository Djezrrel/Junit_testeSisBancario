package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex1 {

	@Test //testando este metodo
	public void TestPesquisaCliente() {
		
		//Criando 2 objetos para testar
		Cliente cliente01 = new Cliente(1,"David",20,"David@gmail.com",1,true);
		Cliente cliente02 = new Cliente(2,"Marcelo",30,"Marcelo@gmail.com",2,true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesdoBanco = new ArrayList<>();
		clientesdoBanco.add(cliente01);
		clientesdoBanco.add(cliente02);
		
		//instanciando a classse que vou testar
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesdoBanco); //recebe como parametro os clientes da lista que vou testar
		
		//armazenando o meu cliente 1 na variavel cliente. || metodo que eu quero testar
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//verifique que,que o ID deste cliente e = a 1; 
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("David@gmail.com"));
		
		
	}

}
