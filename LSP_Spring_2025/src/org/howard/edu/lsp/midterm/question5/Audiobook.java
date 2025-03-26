package org.howard.edu.lsp.midterm.question5;

public class Audiobook implements Streamable {
    private String title;

    public Audiobook(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}