package com.ontrack.service;


import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OnTrackServiceTest {
    private OnTrackService service;

    @BeforeEach
    public void setup() {
        service = new OnTrackService();
    }

    // R - Right
    @Test
    public void testSubmitAndInbox_Right() {
        String id = service.submitTask("123", "Math Assignment");
        List<String> inbox = service.taskInbox("123");
        assertTrue(inbox.contains(id));
    }

    @Test
    public void testViewTask_Right() {
        String id = service.submitTask("123", "Science Report");
        assertEquals("Science Report", service.viewTask(id));
    }

    // B - Boundary
    @Test
    public void testEmptyInbox_Boundary() {
        assertTrue(service.taskInbox("999").isEmpty());
    }

    @Test
    public void testEmptyMessage_Boundary() {
        String id = service.submitTask("123", "Task");
        assertFalse(service.sendMessage(id, "Student", ""));
    }

    // I - Inverse
    @Test
    public void testSubmitThenRemoveInverse() {
        String id = service.submitTask("123", "Temporary Task");
        assertTrue(service.taskInbox("123").contains(id));
        // simulate removal
        service.taskInbox("123").remove(id);
        assertFalse(service.taskInbox("123").contains(id));
    }

    // C - Cross-check
    @Test
    public void testCrossCheckInboxAndViewTask() {
        String id = service.submitTask("456", "CrossCheck Task");
        String fromInbox = service.taskInbox("456").get(0);
        String taskName = service.viewTask(fromInbox);
        assertEquals("CrossCheck Task", taskName);
    }

    // E - Error Conditions
    @Test
    public void testNullInputs_Error() {
        assertNull(service.submitTask(null, "Test"));
        assertNull(service.submitTask("123", null));
    }

    @Test
    public void testSendMessageBeforeTaskExists_Error() {
        assertFalse(service.sendMessage("fakeId", "Student", "Hi"));
    }

    // P - Performance (Simple)
    @Test
    public void testPerformance_ViewTaskUnder1ms() {
        String id = service.submitTask("123", "Speed Task");
        long start = System.nanoTime();
        service.viewTask(id);
        long duration = System.nanoTime() - start;
        assertTrue(duration < 1_000_000); // <1ms
    }

    // Additional tests
    @Test
    public void testMultipleTasksSubmission() {
        String id1 = service.submitTask("789", "Task 1");
        String id2 = service.submitTask("789", "Task 2");
        List<String> inbox = service.taskInbox("789");
        assertTrue(inbox.contains(id1));
        assertTrue(inbox.contains(id2));
        assertEquals(2, inbox.size());
    }

    @Test
    public void testSendLongMessage() {
        String id = service.submitTask("123", "Long Message Task");
        String longMsg = "x".repeat(1000);
        assertTrue(service.sendMessage(id, "Student", longMsg));
    }
}
