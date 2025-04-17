import java.util.HashMap;
import java.util.Map;

// this class helps track how much time you've spent studying different subjects
public class StudySessionTracker {

    // keeps track of the subject you're currently studying
    private String currentSubject = "";
    // tells us if a session is running or not
    private boolean inSession = false;
    // total study time pr subject
    private Map<String, Integer> subjectTimes;

    public StudySessionTracker() {
        this.subjectTimes = new HashMap<>();
    }

    // starts a study session for a given subject
    public void startSession(String subject) {
        // only start if nothing is already running
        if (!this.inSession) {
            this.currentSubject = subject;
            this.inSession = true;
            System.out.println("Started studying: " + subject);
        } else {
            System.out.println("A session is already in progress.");
        }
    }

    // this ends the current sesion and adds 5 min (just for testing)
    public void endSession() {
        if (this.inSession) {
            // get existing time or 0
            int currentTime = this.subjectTimes.getOrDefault(this.currentSubject, 0);
            // add 5 minutes
            this.subjectTimes.put(this.currentSubject, currentTime + 5);
            System.out.println("Ended studying: " + this.currentSubject + " (added 5 minutes)");
            // reset subject
            this.currentSubject = "";
            // reset subject
            this.inSession = false;
        } else {
            System.out.println("No session to end.");
        }
    }

    // checks if you're currently in a session
    public boolean isStudying() {
        return this.inSession;
    }

    // checks if a subject has been tracked before
    public boolean hasSubject(String subject) {
        return this.subjectTimes.containsKey(subject);
    }

    // returns total minutes studied for subject
    public int getTotalTime(String subject) {
        return this.subjectTimes.getOrDefault(subject, 0);
    }

    // finds the subject you've studied the most
    public String getMostStudiedSubject() {
        String mostStudied = "";
        int maxTime = 0;
        for (String subject : this.subjectTimes.keySet()) {
            if (this.subjectTimes.get(subject) > maxTime) {
                maxTime = this.subjectTimes.get(subject);
                mostStudied = subject;
            }
        }
        return mostStudied;
    }

    // resets everything
    public void resetSessions() {
        this.subjectTimes.clear();
        this.currentSubject = "";
        this.inSession = false;
        System.out.println("All study sessions have been cleared.");
    }

    // this is the main method that runs and shows how everything works
    public static void main(String[] args) {
        // making a new tracker
        StudySessionTracker tracker = new StudySessionTracker();

        tracker.startSession("Math");
        tracker.endSession();

        tracker.startSession("Science");
        tracker.endSession();

        tracker.startSession("Math");
        tracker.endSession();

        System.out.println("Total Math time: " + tracker.getTotalTime("Math") + " minutes");
        System.out.println("Most studied subject: " + tracker.getMostStudiedSubject());

        // clears everything
        tracker.resetSessions();
    }
}
