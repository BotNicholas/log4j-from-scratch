package com.example.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Named {
  private Logger logger = LogManager.getLogger("NAMED_LOGGER");

  public void log() {
    logger.log(Level.INFO, "HELLO FROM NAMED");
  }

  public void logError() {
    logger.log(Level.ERROR, "HELLO FROM NAMED BUT IT'S ERROR!!!");
  }

}
