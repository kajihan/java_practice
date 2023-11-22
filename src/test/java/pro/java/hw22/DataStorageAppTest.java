package pro.java.hw22;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import pro.java.hw22.storages.collection_storage.InMemoryDataStorage;
import pro.java.hw22.storages.db_storage.DatabaseDataStorage;
import pro.java.hw22.storages.file_storage.FileDataStorage;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;


public class DataStorageAppTest {
    private final String TEST_FILE = "test.txt";
    private final String TEST_DATA1 = "Test Data";
    private final String TEST_DATA2 = "123";

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testInMemorySave() {
        InMemoryDataStorage inMemoryDataStorage = new InMemoryDataStorage();
        List<String> data = List.of(TEST_DATA1, TEST_DATA2);

        inMemoryDataStorage.save(data);
        List<String> savedData = inMemoryDataStorage.getDataList();

        assertEquals(data, savedData);
    }

    @Test
    public void testFileSave() throws IOException {
        String testFile = tempFolder.newFile(TEST_FILE).getPath();
        FileDataStorage fileDataStorage = new FileDataStorage(testFile);

        List<String> testData = List.of(TEST_DATA1, TEST_DATA2);
        fileDataStorage.save(testData);

        List<String> savedData;
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            savedData = reader.lines().collect(Collectors.toList());
            System.out.println("Saved data in file: " + savedData);
        }

        assertEquals(testData, savedData);
    }

    @Test
    public void testDBSave() throws SQLException {
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);

        when(mockConnection.prepareStatement(any())).thenReturn(mockPreparedStatement);
        DatabaseDataStorage databaseDataStorage = new DatabaseDataStorage(mockConnection);

        List<String> data = List.of(TEST_DATA1, TEST_DATA2);
        databaseDataStorage.save(data);

        verify(mockConnection).prepareStatement(anyString());

        verify(mockPreparedStatement, times(data.size())).setString(eq(1), any());
        verify(mockPreparedStatement, times(data.size())).executeUpdate();
    }

    @Test()
    public void testInvalidChoice() {
        InputStream in = new ByteArrayInputStream(TEST_DATA2.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, DataStorageApp::getStorageMethod);
    }
}
