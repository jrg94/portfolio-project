public interface musicPlaylist {
    /**
     * adds song to playlist
     *
     * @param name
     *            the title of the song
     * @updates this
     * @ensures this contains a new song name
     */
    void addSong(String name);

    /**
     * Plays a song once.
     *
     * @param name
     *            the title of the song
     * @updates this
     * @ensures the play count of name increases by 1
     */
    void songCount(String name);
}
