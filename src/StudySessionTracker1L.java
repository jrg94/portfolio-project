import java.util.HashMap;
import java.util.Map;

/**
 * Kernel implementation of the StudySessionTracker component.
 *
 * Convention: - currentSubject is not null when inSession is true -
 * subjectTimes does not contain null keys or values
 *
 * Correspondence: - inSession corresponds to whether a study session is
 * currently active - currentSubject corresponds to the subject being studied -
 * subjectTimes maps each subject to total time studied (in minutes)
 */
public class StudySessionTracker1L extends StudySessionTrackerSecondary {

    // holds the subject being studied
    private String currentSubject;

    // tells us if a session is running
    private boolean inSession;

    // total time tracked for each subject
    private Map<String, Integer> subjectTimes;

    // constructor: sets everything to default
    public StudySessionTracker1L() {
        this.currentSubject = "";
        this.inSession = false;
        this.subjectTimes = new HashMap<>();
    }

    // starts a new study session for the given subject
    @Override
    public void startSession(String subject) {
        assert !this.isStudying() : "Violation of: not isStudying()";

        this.currentSubject = subject;
        this.inSession = true;
    }

    // ends the current study session
    @Override
    public void endSession() {
        assert this.isStudying() : "Violation of: isStudying()";

        int currentTime = this.subjectTimes.getOrDefault(this.currentSubject,
                0);
        this.subjectTimes.put(this.currentSubject, currentTime + 5);

        this.currentSubject = "";
        this.inSession = false;
    }

    // checks if a study session is active
    @Override
    public boolean isStudying() {
        return this.inSession;
    }

    // checks if a subject has been studied before
    @Override
    public boolean hasSubject(String subject) {
        return this.subjectTimes.containsKey(subject);
    }
}
