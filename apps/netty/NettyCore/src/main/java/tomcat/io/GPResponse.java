package tomcat.io;

import java.io.IOException;
import java.io.OutputStream;

public class GPResponse {

    private OutputStream outputStream;

    public GPResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String s) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(s);
        this.outputStream.write(stringBuilder.toString().getBytes());
    }
}
