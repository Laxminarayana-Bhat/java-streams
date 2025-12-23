package com.learn.javastreams.patterns;

import java.util.List;

public class PatternHelper {

    //singleton - only one instance throughout
    private static PatternHelper patternHelper;

    PatternHelper() {
        System.out.println("Singleton DP");
    }

    public PatternHelper getInstance() {
        if (patternHelper == null) {
            return new PatternHelper();
        } else return patternHelper;
    }

    //Factory - abstraction, let the impl classes decide what to do with the main interface
    //Object creation without exposing its logic - pizzza factory

    //Problems without Factory:
    //Tight coupling to concrete classes
    //Large if-else or switch statements
    //Hard to add new types (SOLID -> O)

    //instead of if notif==email else if notif==call like this, we can impl notification interface.
    interface notification {
        void send();
    }

    static class Email implements notification {

        @Override
        public void send() {
            System.out.println("Email sent");
        }
    }

    static class Sms implements notification {
        @Override
        public void send() {
            System.out.println("SMS sent");
        }
    }

    //Builder - solves constructor problem
    static class User {
        private final String name;

        User(Builder builder) {
            this.name = builder.name();   // ✅ no field access
        }

        static Builder builder() {
            return new Builder();
        }

        static class Builder {
            private String uname;

            public Builder name(String n) {
                this.uname = n;
                return this;
            }

            // 👇 package-private (NOT public)
            private String name() {
                return uname;
            }

            public User build() {
                return new User(this);
            }
        }
    }

    User user = User.builder().name("hii").build();

    //Factory: Client asks factory → object created → client uses it
    //
    //Strategy: Client already has object → injects behavior → object executes it

    //Strategy - At runtime let user choose which option they want
    interface NotificationStrategy {
        void send();
    }

    class EmailS implements NotificationStrategy {
        public void send() {
            System.out.println("Email sent");
        }
    }

    class SmsS implements NotificationStrategy {
        public void send() {
            System.out.println("SMS sent");
        }
    }

    class NotificationContext {
        private NotificationStrategy strategy;

        public void setNotificationStrategy(NotificationStrategy strategy) {
            this.strategy = strategy;
        }

        public void notifyUser() {
            strategy.send(); // executes chosen behavior
        }
    }

    // Client
//    NotificationContext context = new NotificationContext();
//context.setNotificationStrategy(new

//    Email()); // Client chooses behavior
//context.notifyUser();

    //!!! Factory: The client asks the factory to create the object. The client doesn’t control the logic inside the object.
    //
    //!!! Strategy: The client already has the context and injects a behavior to change how it works.

    //Pattern	Intent (What it’s for)
    //Factory	Encapsulate object creation. The client asks the factory for an object but doesn’t know the concrete class. Focus: “Which object should I create?”
    //Strategy	Encapsulate behavior/algorithm. The client has a context object and can swap behavior dynamically. Focus: “How should I perform this action?”


    //Observer - When the subject changes state, all observers are notified automatically.
    interface Subscriber {
        void newThing();
    }

    static class Youtube implements Subscriber {

        public void newThing() {
            System.out.println("Notification on new video");
        }
    }

    public void sendNotif() {
        Youtube youtube = new Youtube();
        List<String> users = List.of();
        users.forEach(e -> youtube.newThing());
    }

    //Decorator - new functionality addition with extension
    //Add some more decoration to existing example

    static class YoutubePremium extends Youtube {
        public void premiumNotification() {
            System.out.println("Premium decorated");
        }
    }

    public void sendPremiumNotif() {
        YoutubePremium yt = new YoutubePremium();
        yt.premiumNotification();
    }

    //Adapter - incompatible interfaces to work together
// Existing class with incompatible interface
    class LegacySmsService {
        public void sendSmsMessage() {
            System.out.println("Legacy SMS sent ");
        }
    }

    class SmsAdapter extends LegacySmsService {
        LegacySmsService legacySmsService;

        public void displayLatest() {
            legacySmsService.sendSmsMessage();
        }
    }

    //Facade - The Facade Pattern provides a simplified interface to a complex subsystem.

    //its like combining all theservices and letting only 1 method to handle all

    class FacadeOfNotification{
        Email email;
        Sms sms;

        public void sendNotif(){
            email.send();
            sms.send();
        }
    }

    //use it to send all at once

    //Proxy - The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.




}
