package com.readdata.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.readdata.Entity.Account;
import com.readdata.Helper.ReaderUtill;
import com.readdata.Helper.UploadHelper;

@Controller
public class HomeController {
	
	@Autowired
	private UploadHelper uploadHelper;
	@Autowired
	private ReaderUtill readerUtill;
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public String homepost(Model mode,@RequestParam("file") MultipartFile file) throws IOException
	{
		List<Account> usList=null;
		String line = "";  
		String splitBy = ",";  
		if(file.isEmpty()) {
			mode.addAttribute("class1","danger");
			mode.addAttribute("message","Please Choose The File First");
			
		}else {
			String nameString=file.getOriginalFilename();
			
			int exString=nameString.lastIndexOf(".");
			if(exString>1) {
				String extension = nameString.substring(exString + 1);
				boolean status=uploadHelper.uploadcsv(file, extension);
				String name=uploadHelper.UPLOAD_DIR+"/"+extension+"/"+file.getOriginalFilename();
				if(extension.equals("csv")) {
					
					usList=readerUtill.getList(name);
					mode.addAttribute("message","Csv Data In Table Form Given Below");
					mode.addAttribute("class1","success");
					mode.addAttribute("list",usList);
				}
				if(extension.equals("xlsx")) {
					usList=readerUtill.readExcel(name);
					mode.addAttribute("list",usList);
					mode.addAttribute("class1","success");
					
					mode.addAttribute("message","Excel Data In Table Form Given Below");
					
				}
				if(extension.equals("pdf")) {
					System.out.println("PDF Reader");
					String dataString=readerUtill.readPdf(name);
					mode.addAttribute("class1","success");
					mode.addAttribute("data",dataString);
					mode.addAttribute("message","PDF Data  Given Below");
				}
				if(extension.equals("txt")) {
					String dataString=readerUtill.textRead(name);
					mode.addAttribute("class1","success");
					mode.addAttribute("data",dataString);
					mode.addAttribute("message","Read The Text File Given Below");
				
				}
				if(extension.equals("doc")) {
					String dataString=readerUtill.textRead(name);
					mode.addAttribute("class1","success");
					mode.addAttribute("data",dataString);
					mode.addAttribute("message","Word File Data Given Below");
				
				}
				
				if(extension.equals("rtf")) {
					String dataString=readerUtill.textRead(name);
					mode.addAttribute("class1","success");
					mode.addAttribute("data",dataString);
					mode.addAttribute("message","Word File Data Given Below");
				
				}
				System.out.println(extension);
					
				
			}
			
			
		}
		return "home";
	}

}
