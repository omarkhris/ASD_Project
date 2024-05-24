package edu.mum.cs.cs525.labs.exercises.project.console.framework.internal;

import java.io.Serializable;

public class NotificationService  implements Serializable {
    private static final long serialVersionUID = 1L;
    //perform email sending logic
    public void sendEmail(String email, String message) {
        System.out.println("Email sent to " + email + " with message: " + message);
    }
}