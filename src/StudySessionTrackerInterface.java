public interface StudySessionTrackerInterface
        extends StudySessionTrackerKernel {
    int getTotalTime(String subject);

    String getMostStudiedSubject();

    void resetSessions();
}
