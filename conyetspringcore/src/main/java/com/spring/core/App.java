package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

import static com.spring.core.EventType.ERROR;
import static com.spring.core.EventType.INFO;

public class App {
    Client client;
    EventLogger eventLogger;
    Map<EventType,EventLogger> loggers;


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent(INFO,"Some event for 1");
        app.logEvent(ERROR,"Some event for 1");
        app.logEvent(INFO,"Some event for 2");
        app.logEvent(ERROR,"Some event for 2");
        ctx.close();
    }

    public Map<EventType, EventLogger> getLoggers() {
        return loggers;
    }

    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = (Event) new ClassPathXmlApplicationContext("spring.xml").getBean("event");
        event.setMsg(message);
        try {
            EventLogger logger = loggers.get(type);
            if (logger == null) {
                logger = eventLogger;
            }
            logger.logEvent(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
