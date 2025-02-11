package com.example.logger;

import com.test.Root;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A {
  private Logger logger = LogManager.getLogger(A.class);

  public void log() {
    logger.log(Level.INFO, "HELLO FROM A");
  }

}
