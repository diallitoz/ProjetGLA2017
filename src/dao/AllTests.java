package dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreationClientTest.class, CreationCompteTest.class, CrediterCompteTest.class, PayementTest.class })
public class AllTests {

}
