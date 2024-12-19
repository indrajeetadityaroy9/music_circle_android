package com.service.music_circle_backend.exceptions.event;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(Long id) { super("Could not find event " + id); }
}

