package com.eomcs.app2;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class ServerAppTest {
  @Test public void appHasAGreeting() {
    ServerApp classUnderTest = new ServerApp();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
  }
}
