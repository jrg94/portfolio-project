import static org.junit.Assert.*;

import org.junit.Test;

public class StudySessionTrackerTest {

    @Test
    public void testSimpleSession() {
        // create a new tracker
        StudySessionTracker1L tracker = new StudySessionTracker1L();

        // run a session for Math
        tracker.startSession("Math");
        tracker.endSession();

        // check total time is 5
        assertEquals(5, tracker.getTotalTime("Math"));

        // check Math is tracked
        assertTrue(tracker.hasSubject("Math"));
    }

    @Test
    public void testMultipleSessions() {
        // create a new tracker
        StudySessionTracker1L tracker = new StudySessionTracker1L();

        // do two sessions for English
        tracker.startSession("English");
        tracker.endSession();
        tracker.startSession("English");
        tracker.endSession();

        // check total time is 10
        assertEquals(10, tracker.getTotalTime("English"));

        // check most studied subject is English
        assertEquals("English", tracker.getMostStudiedSubject());
    }
}
