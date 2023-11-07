package pro.java;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pro.java.hw21.Client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ClientAppTest {
    private Client client;
    ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
    @Mock
    private PrintStream mockPrintStream;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setErr(new PrintStream(mockOutputStream));
        client = new Client("localhost", 8080);
        client.out = mockPrintStream;
    }

    @Test
    public void testSendMessage() {
        String message = "Test Message";
        client.sendMessage(message);
        Mockito.verify(mockPrintStream).println(message);
    }

    @Test
    public void testUnknownHost() {
        System.setErr(new PrintStream(mockOutputStream));
        new Client("invalid_server_address", 8080);

        assertTrue(mockOutputStream.toString().contains("Unknown host: invalid_server_address"));
    }

    @Test
    public void testExitMessage() {
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        client.out = new PrintStream(errorOutput);
        client.sendMessage("-exit");

        assertEquals("-exit", errorOutput.toString().trim());
    }

    @Test
    public void testSocketException() throws IOException {
        Socket mockSocket = Mockito.mock(Socket.class);
        when(mockSocket.getInputStream()).thenThrow(new SocketException("Socket closed"));
        String expectedMessage = "Socket was closed by userConnection refused: connect";

        assertEquals(expectedMessage, mockOutputStream.toString().trim());
    }
}
