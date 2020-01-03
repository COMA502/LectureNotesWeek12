package edu.dmacc.dsmcode.coma510.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class InstructorServiceTest {

    @Test
    public void exampleTest() {
        assertEquals("Test", "Test");
    }

    @Test
    public void shouldReturnStubInstructorNames() {
        InstructorService service = new InstructorService(
                mock(NamingService.class), new StubDatabase());

        List<String> instructorNames = service.getInstructorNames();

        assertEquals(2, instructorNames.size());
        assertEquals("Greg", instructorNames.get(0));
        assertEquals("John", instructorNames.get(1));
    }

    @Test
    public void shouldReturnEmptyListForNoInstructors() {
        Database database = mock(Database.class);
        doReturn(null).when(database).getNextResults();
        InstructorService service = new InstructorService(mock(NamingService.class), database);

        List<String> instructorNames = service.getInstructorNames();

//        assertTrue(instructorNames.isEmpty());
        assertEquals(0, instructorNames.size());
    }

    @Test
    public void shouldReturnMockInstructorNames() {
        Database database = mock(Database.class);
        doReturn(new String[] {"Greg", "2"})
                .doReturn(new String[] {"John", "1"})
                .doReturn(null)
                .when(database)
                .getNextResults();
        InstructorService service = new InstructorService(
                mock(NamingService.class), database);

        List<String> instructorNames = service.getInstructorNames();

        assertEquals(2, instructorNames.size());
        assertEquals("Greg", instructorNames.get(0));
        assertEquals("John", instructorNames.get(1));
    }

    @Test
    public void shouldOpenConnectionOnCreation() {
        Database database = mock(Database.class);
        NamingService namingService = mock(NamingService.class);
        String expectedName = "DatabaseName";
        doReturn(expectedName).when(namingService).getDatabaseName();

        new InstructorService(namingService, database);

//        verify(database, times(1)).connect();
        verify(database).connect(expectedName);//default is times(1)
    }

//    @Test
//    public void shouldQueryAllInstructors() {
//        Database database = mock(Database.class);
//
//        new InstructorService(null)
//    }
}
