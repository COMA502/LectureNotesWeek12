package edu.dmacc.dsmcode.coma510.examples;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InstructorServiceTest {

    @Test
    public void exampleTest() {
        assertEquals("Test", "Test");
    }

    @Test
    public void shouldReturnStubInstructorNames() {
        InstructorService service = new InstructorService(
                null, new StubDatabase());

        List<String> instructorNames = service.getInstructorNames();

        assertEquals(2, instructorNames.size());
        assertEquals("Greg", instructorNames.get(0));
        assertEquals("John", instructorNames.get(1));
    }
}
