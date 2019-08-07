package com.shask.flyingsaucer;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Itext5Test {

    File xhtmlFile = new File(getClass().getClassLoader().getResource("centered-image.html").getFile());

    @Test
    public void itext5Test() throws IOException, DocumentException {

        String k = Files.lines(xhtmlFile.toPath(), UTF_8).collect(Collectors.joining(""));
        OutputStream file = new FileOutputStream(new File("result_itext5_test.pdf"));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, file);
        document.open();
        InputStream is = new ByteArrayInputStream(k.getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
        document.close();
        file.close();

    }
}
