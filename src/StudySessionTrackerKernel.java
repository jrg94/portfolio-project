import components.standard.Standard;

/**
 * Kernel interface for StudySessionTracker component.
 */
public interface StudySessionTrackerKernel
        extends Standard<StudySessionTracker> {

    /**
     * Starts a new study session for the given subject.
     *
     * @param subject
     *            the subject being studied
     * @requires not isStudying()
     * @ensures isStudying() and currentSubject = subject
     */
    void startSession(String subject);

    /**
     * Ends the current study session.
     *
     * @requires isStudying()
     * @ensures not isStudying()
     */
    void endSession();

    /**
     * Checks if a session is currently active.
     *
     * @return true if studying; false otherwise
     * @ensures isStudying = [true iff session is active]
     */
    boolean isStudying();

    /**
     * Returns true if the subject has been studied before.
     *
     * @param subject
     *            the subject name
     * @return whether the subject exists in the record
     * @ensures [true if subject is tracked]
     */
    boolean hasSubject(String subject);
}
