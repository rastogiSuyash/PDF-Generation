package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;



@Service
public class PdfService {
	private Logger log=LoggerFactory.getLogger(getClass().getName());
	public ByteArrayInputStream genPdf() {
		log.info("Generate PDF started:");
		String title="Welcome to new channel";
		String content="Please subscribe to our channel. ";
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		Document doc=new Document();
		try {
			
			PdfWriter.getInstance(doc, out);
			doc.open();
			Font font=FontFactory.getFont(FontFactory.HELVETICA,20);
			Paragraph para=new Paragraph(title,font);
			para.setAlignment(Element.ALIGN_CENTER);
			doc.add(para);
			
			
			Font font1=FontFactory.getFont(FontFactory.HELVETICA,18);
			Paragraph para2=new Paragraph(content,font1);
			//para.setAlignment(Element.ALIGN_CENTER);
			para2.add(new Chunk("This ia a new chunk."));
			doc.add(para2);
			doc.close();
			return new ByteArrayInputStream(out.toByteArray());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
