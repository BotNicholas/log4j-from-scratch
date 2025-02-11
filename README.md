# log4j-from-scratch
This is a test project where I try to configure it from scratch...

Also here I veryfy how log4j binds logger to classes, namely:
1) Define a named logger that will be used by **_com.example.logger.Named_** class
2) Define a logger for **_com.example_** package - it will be assignrd to **_com.example.logger.B_** class
3) Define a logger for **_com.example.logger.A_** that will be assigned to correspondiung **_com.example.logger.A_** class
4) Define a root logger that will be assigned to **_com.test.Root_** class

   This way I tryed out on practice how exactly Log4J assignes logger in different cases...


   ### What Also?
* Also I tried out different log levels (trace and error)
* Configured logger tith help of XML like this
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!-- Extra logging related to initialization of Log4j.
   Set to debug or trace if log4j initialization is failing. -->
  <Configuration status="warn">
    <Properties>
      <Property name="basePath">C:/temp/logs</Property>
    </Properties>
  
    <Appenders>
      <!-- Console appender configuration -->
      <Console name="console" target="SYSTEM_OUT">
        <PatternLayout
          pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n ITS SIMPLE CONSOLE" />
      </Console>
      <Console name="consoleRoot" target="SYSTEM_OUT">
        <PatternLayout
          pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n FROMROOT" />
      </Console>
      <Console name="consoleNamed" target="SYSTEM_OUT">
      <PatternLayout
        pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n IT's FROMNAMED!!!!" />
    </Console>
      <RollingFile name="fileLogger"
        fileName="${basePath}/app.log"
        filePattern="${basePath}/app-%d{yyyy-MM-dd}.log">
        <PatternLayout>
          <pattern>[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n FILE
          </pattern>
        </PatternLayout>
        <Policies>
          <TimeBasedTriggeringPolicy interval="1" modulate="true" />
          <SizeBasedTriggeringPolicy size="10MB" />
        </Policies>
        <!-- Max 10 files will be created everyday -->
        <DefaultRolloverStrategy max="10">
          <Delete basePath="${basePathr}" maxDepth="10">
            <!-- Delete all files older than 30 days -->
            <IfLastModified age="30d" />
          </Delete>
        </DefaultRolloverStrategy>
      </RollingFile>
    </Appenders>
  
    <Loggers>
      <!-- Root logger referring to console appender -->
      <Root level="info" additivity="false">
        <AppenderRef ref="consoleRoot" />
      </Root>
      <Logger level="trace" additivity="false" name="com.example">
        <AppenderRef ref="fileLogger" />
      </Logger>
      <Logger level="trace" additivity="false" name="com.example.logger.A">
        <AppenderRef ref="console" />
      </Logger>
      <Logger level="error" additivity="false" name="NAMED_LOGGER">
        <AppenderRef ref="consoleNamed" />
      </Logger>
    </Loggers>
  </Configuration>
  ```
