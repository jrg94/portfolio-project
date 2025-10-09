import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlaylistManager {

    private static class Song {
        String title;
        String artist;
        int playCount;

        Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
            this.playCount = 0;
        }

        void play() {
            playCount++;
            System.out.println("Playing: " + title + " by " + artist + " (Play count: " + playCount + ")");
        }
    }
    private ArrayList<Song> playlist;

    public PlaylistManager() {
        this.playlist = new ArrayList<>();
    }

    public void addSong(Song s) {
        playlist.add(s);
    }
    public void removeSong(String title) {
        playlist.removeIf(s -> s.title.equalsIgnoreCase(title));
    }
    public boolean isEmpty() {
        return playlist.isEmpty();
    }

    public void shuffle() {
        Collections.shuffle(playlist);
        System.out.println("Playlist shuffled!");
    }

    public void sortByArtist() {
        playlist.sort(Comparator.comparing(s -> s.artist.toLowerCase()));
        System.out.println("Playlist sorted by artist!");
    }

    public void playNext() {
        if (!playlist.isEmpty()) {
            Song next = playlist.remove(0);
            next.play();
        } else {
            System.out.println("No more songs!");
        }
    }

    public void showPlaylist() {
        System.out.println("Current Playlist:");
        for (Song s : playlist) {
            System.out.println(" - " + s);
        }
    }

    public static void main(String[] args) {
        PlaylistManager myPlaylist = new PlaylistManager();

        Song s1 = new Song("Sky", "Playboi Carti");
        Song s2 = new Song("9", "Drake");
        Song s3 = new Song("Starboy", "The Weeknd");

        myPlaylist.addSong(s1);
        myPlaylist.addSong(s2);
        myPlaylist.addSong(s3);

        myPlaylist.showPlaylist();
        myPlaylist.shuffle();
        myPlaylist.playNext();
        myPlaylist.sortByArtist();
        myPlaylist.showPlaylist();
        myPlaylist.removeSong("Starboy");
        myPlaylist.showPlaylist();
    }
}
