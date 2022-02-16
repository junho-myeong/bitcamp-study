package com.eomcs.app2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class ClientAppTest {
  @Test public void appHasAGreeting() {
    ClientApp classUnderTest = new ClientApp();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
  }
}
