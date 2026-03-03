package com.example.extensions;

import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback, TestWatcher {

  private static final Logger log = LoggerFactory.getLogger(LoggingExtension.class);

  @Override
  public void beforeTestExecution(ExtensionContext context) {
    log.info("=== START {} ===", displayName(context));
  }

  @Override
  public void afterTestExecution(ExtensionContext context) {
    // TestWatcher handles pass/fail; this can stay empty or be used for timing.
  }

  @Override
  public void testSuccessful(ExtensionContext context) {
    log.info("=== PASS  {} ===", displayName(context));
  }

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    log.error("=== FAIL  {} ===", displayName(context), cause);
  }

  private String displayName(ExtensionContext context) {
    return context.getDisplayName();
  }
}