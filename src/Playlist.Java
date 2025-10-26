/**
 * Enhanced interface for the Playlist component.
 * Extends the kernel interface by adding sorting, shuffling, and viewing features.
 *
 */
public interface Playlist extends PlaylistManagerKernel {

    /**
     * Randomly rearranges the songs in the playlist.
     *
     * @clears this
     * @ensures this = permutation(#this)
     */
    void shuffle();

    /**
     * Sorts the playlist by artist name in ascending order.
     *
     * @ensures songs are ordered by artist name alphabetically
     */
    void sortByArtist();

    /**
     * Displays all songs currently in the playlist.
     *
     * @ensures this = #this
     */
    void showPlaylist();

    /**
     * Returns the total number of songs in the playlist.
     *
     * @return the number of songs currently stored
     * @ensures size = |this|
     */
    int size();
}
