package com.shask.flyingsaucer;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Itext7Test {

    File xhtmlFile = new File(getClass().getClassLoader().getResource("centered-image.html").getFile());

    @Test
    public void itext7html2PDfTest() throws IOException {
        File pdfDest = new File("result_itext7_test.pdf");
        // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(new FileInputStream(xhtmlFile),
                new FileOutputStream(pdfDest), converterProperties);
    }
}
