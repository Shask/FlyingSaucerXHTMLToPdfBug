package com.shask.flyingsaucer;

import com.lowagie.text.DocumentException;
import org.junit.Test;
import org.xhtmlrenderer.simple.PDFRenderer;

import java.io.File;
import java.io.IOException;

public class FlyingSaucerOpenPDFTest {
    File xhtmlFile = new File(getClass().getClassLoader().getResource("centered-image.html").getFile());

    @Test
    public void shouldBeCentered() throws IOException, DocumentException {
        PDFRenderer.renderToPDF(xhtmlFile, "result_flyingsaucer_test.pdf");
    }

    @Test
    public void shouldBeCentered2() throws IOException, DocumentException {
        PDFRenderer.renderToPDF(xhtmlFile, "result_flyingsaucer_test.pdf");
    }




}
