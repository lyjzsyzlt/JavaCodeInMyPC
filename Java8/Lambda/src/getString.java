import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class getString {
    public static String processFile(BufferReaderProcessor p) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String args[]) throws IOException {
        String oneLine=processFile((BufferedReader br)->br.readLine());
        String twoLine=processFile((BufferedReader br)->br.readLine()+'\t'+br.readLine());

        System.out.println(oneLine);
        System.out.println(twoLine);
    }
}
