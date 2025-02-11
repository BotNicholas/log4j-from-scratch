package com.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Root {
  private Logger logger = LogManager.getLogger(Root.class);

  public void log() {
    logger.log(Level.INFO, "HELLO FROM ROOT");
  }
}
