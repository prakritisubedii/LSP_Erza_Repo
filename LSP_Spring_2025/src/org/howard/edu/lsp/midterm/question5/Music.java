package org.howard.edu.lsp.midterm.question5;

public class Music implements Streamable {
    private String title;
    
    public Music(String title) {
        this.title = title;
    }
    
 
    public void play() {
        System.out.println("Playing music: " + title);
    }
    

    public void pause() {
        System.out.println("Paused music: " + title);
    }
    
 
    public void stop() {
        System.out.println("Stopped music: " + title);
    }
    
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}