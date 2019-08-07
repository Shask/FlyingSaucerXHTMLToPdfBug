package com.shask.flyingsaucer;

import com.lowagie.text.DocumentException;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.SimpleXmlSerializer;
import org.htmlcleaner.TagNode;
import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DirtyDirtyFix {

   private HtmlCleaner htmlCleaner = new HtmlCleaner();
   private File xhtmlFile = new File(getClass().getClassLoader().getResource("centered-image.html").getFile());

    @Test
    public void dirtyFix() throws IOException {
        String htmlContent = Files.lines(xhtmlFile.toPath(),UTF_8).collect(Collectors.joining(""));

        htmlContent = addWidthToTheImage(htmlContent);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        try (FileOutputStream os = new FileOutputStream("result_dirty_fix.pdf")) {
            renderer.createPDF(os);
        } catch (DocumentException e) {
            throw new IOException("Cannot create pdf", e);
        }
    }

    protected String addWidthToTheImage(String html) {
        TagNode node = htmlCleaner.clean(html);

        final List<? extends TagNode> imgList = node.getElementListByName("img", true);
        if (imgList != null) {
            for (TagNode img : imgList) {
                img.addAttribute("width", "100px");
            }
        }
        return new SimpleXmlSerializer(htmlCleaner.getProperties()).getAsString(node, "UTF-8");
    }
}
