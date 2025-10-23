public interface MusicPlaylist extends MusicPlaylistKernel { {
    /**
     * Reports whether a song is considered a favorite
     * (i.e., its rating ≥ FAVORITE_RATING).
     *
     * @param title
     *            the song title
     * @return true if the song is a favorite, false otherwise
     * @requires title is in this
     * @ensures reports whether title’s rating ≥ FAVORITE_RATING
     */
    boolean isFavorite(String title);
}
