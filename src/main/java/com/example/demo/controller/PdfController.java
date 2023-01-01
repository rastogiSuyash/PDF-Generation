package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.PdfService;

@Controller
@RequestMapping("/pdf")
public class PdfController {
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/generate")
	public ResponseEntity<InputStreamResource> generatePdf() {
		ByteArrayInputStream pdf= pdfService.genPdf();
		
		HttpHeaders httpHeader=new HttpHeaders();
		httpHeader.add("content_despo", "inline;file=suyash.pdf");
		return ResponseEntity
				.ok()
				.headers(httpHeader).contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
	}

}
