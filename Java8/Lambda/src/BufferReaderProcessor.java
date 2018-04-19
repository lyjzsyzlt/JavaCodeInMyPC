import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Consumer;
public interface BufferReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
