import java.util.HashMap;
import java.util.Map;


//This is a mock where i implement a couple of methods, and have a bit of an idea of what I want to do




public class mockMethods {

    private Map<String, Song> songs;

    // base rating for favorite song
    public static final int FAVORITE_RATING = 4;

    /**
     * creating playCount and rating systme.
     */
    private class Song {
        int playCount;
        int rating;

        Song() {
            this.playCount = 0;
            this.rating = 0;
        }
    }

    /**
     * object creation.
     *
     * @ensures this.songs is initialized as an empty map
     */
    public mockMethods() {
        this.createNewRep();
    }

    /**
     * Initializes the representation of this.
     *
     * @updates this
     * @ensures this.songs is a new, empty map
     */
    private void createNewRep() {
        this.songs = new HashMap<>();
    }

    // KERNEL METHODS (addSong and songCount for now).

    /**
     * Adds a song to this playlist.
     *
     * @param name name of song
     * @updates this
     * @ensures this.songs a new entry for each name
     */
    public void addSong(String name) {
        if (!this.songs.containsKey(name)) {
            this.songs.put(name, new Song());
        }
    }

    /**
     * Plays a song once (increments play count).
     *
     * @param name the song name
     * @updates this
     * @ensures songCount increases each time a song is played
     */
    public void songCount(String name) {
        if (this.songs.containsKey(name)) {
            this.songs.get(name).playCount++;
        } else {
            this.addSong(name);
            this.songCount(name);
        }
    }

    // SECONDARY METHOD (isFavorite for now).

    /**
     * tests whether a song can be considered a favorite.
     *
     * @param name song name
     * @return true if favorite, false otherwise
     */
    public boolean isFavorite(String name) {
        if (!this.songs.containsKey(name)) {
            return false;
        }
        //changes favorite song if rating is higher than favorite rating threshold.
        return this.songs.get(name).rating >= FAVORITE_RATING;
    }


    public static void main(String[] args) {
        mockMethods playlist = new mockMethods();

        // kernel methods
        playlist.addSong("Espresso");
        playlist.addSong("Blinding Lights");

        playlist.songCount("Espresso");
        playlist.songCount("Blinding Lights");
        playlist.songCount("Blinding Lights");

        // secondary method
        System.out.println("Blinding Lights is one of your favorite songs!" + playlist.isFavorite("Blinding Lights"));
    }
}
