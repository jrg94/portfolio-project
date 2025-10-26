/**
 * Kernel interface for the PlaylistManager component.
 *
 */
public interface PlaylistManagerKernel extends Standard<PlaylistManager> {

    /**
     * Adds a song to the playlist.
     *
     * @param title  the title of the song
     * @param artist the artist of the song
     * @requires title and artist are not null or empty
     * @ensures this = #this with (title, artist) added to the end of the playlist
     */
    void addSong(String title, String artist);

    /**
     * Removes the song with the given title from the playlist.
     *
     * @param title the title of the song to remove
     * @requires title is not null or empty
     * @ensures if a song with title existed in #this, it is removed
     */
    void removeSong(String title);

    /**
     * Reports whether this playlist is empty.
     *
     * @return true if the playlist is empty
     * @ensures isEmpty = (|this| = 0)
     */
    boolean isEmpty();

    /**
     * Plays the next song in the playlist.
     *
     * @requires this is not empty
     * @ensures the first song in #this is removed from this and "played" once
     */
    void playNext();
}
