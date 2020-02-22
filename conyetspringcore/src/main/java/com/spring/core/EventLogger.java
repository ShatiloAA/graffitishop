package com.spring.core;

import java.io.IOException;

public interface EventLogger {
    public void logEvent(Event event) throws IOException;
}
