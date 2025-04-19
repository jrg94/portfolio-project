/**
 * Abstract class that implements the secondary methods of the
 * StudySessionTracker interface using only kernel and standard methods.
 */
public abstract class StudySessionTrackerSecondary
        implements StudySessionTrackerInterface {

    // returns the total time studied for the given subject
    @Override
    public int getTotalTime(String subject) {
        assert this.hasSubject(subject) : "Violation of: subject is tracked";
        // we return 0 as placeholder
        return 0;
    }

    // this returns the subject with the mosy study time
    @Override
    public String getMostStudiedSubject() {
        // placeholder return
        return "";
    }

    //then resets all study session data
    @Override
    public void resetSessions() {
        if (this.isStudying()) {
            this.endSession();
        }
    }

    // returns a string representation of whether a session is active
    @Override
    public String toString() {
        if (this.isStudying()) {
            return "Study session in progress.";
        } else {
            return "No study session is currently active.";
        }
    }

    // compares two trackers for equality
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StudySessionTracker) {
            StudySessionTracker other = (StudySessionTracker) obj;
            return this.isStudying() == other.isStudying();
        }
        return false;
    }
}


