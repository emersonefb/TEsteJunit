package br.com.efb.TesteEndereco;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testePais.class, testeEstado.class, testeCidade.class,
		testeBairro.class, testeRuas.class, testeEndereco.class,
		testbuscaEndrecoPorCEP.class })
public class AllTests {

}
