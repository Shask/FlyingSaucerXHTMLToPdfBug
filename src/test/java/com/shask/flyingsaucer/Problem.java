package com.shask.flyingsaucer;

import com.itextpdf.text.DocumentException;
import org.junit.Test;
import org.xhtmlrenderer.simple.PDFRenderer;

import java.io.File;
import java.io.IOException;

public class Problem {
    File xhtmlFile = new File(getClass().getClassLoader().getResource("centered-image.html").getFile());

    @Test
    public void shouldBeCentered() throws IOException, DocumentException {
        PDFRenderer.renderToPDF(xhtmlFile, "should_be_centered_but_is_not.pdf");
    }

}
