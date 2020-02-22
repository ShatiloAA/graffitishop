package com.spring.core;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger {
    List<EventLogger> loggers;
    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        loggers.stream().forEach(eventLogger -> {
            try {
                eventLogger.logEvent(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setLoggers(FileEventLogger loggers) {
    }
}
