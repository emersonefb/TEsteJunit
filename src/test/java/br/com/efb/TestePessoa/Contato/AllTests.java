package br.com.efb.TestePessoa.Contato;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCelular.class, TestEmailContato.class,
		TestTelefone.class, TestContato.class })
public class AllTests {

}
