package com.tutorials.spring.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.io.Files;


@Controller
public class FileUploadController {

	private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> upload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{               

		Object exception = request.getAttribute("EXCEPTION_KEY");
	    if (exception != null && FileUploadBase.SizeLimitExceededException.class.equals(exception.getClass())) {
	    	return new ResponseEntity<String>("Unable to upload such a size .. !", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		    
		Iterator<String> itr =  request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());
		
		String fileName=mpf.getOriginalFilename().replace(" ", "_");
		File file =  new File(fileName);
		logger.debug("File created on " + file.getAbsolutePath());
		
		Files.write(mpf.getBytes(), file);
		
		//We delete file in x seconds
		deleteUploadedFile(file, 5, TimeUnit.SECONDS);
		
		return new ResponseEntity<String>( fileName, HttpStatus.OK);
	}

	private void deleteUploadedFile(File file, int delay, TimeUnit unit) {
		logger.debug("Ready to delete file " + file.getAbsolutePath() + " in " + delay + " " + unit);
		final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		executor.schedule(new Runnable() {
		    @Override
		    public void run() {
		       if(file!=null)
		    	   file.delete();
		       logger.debug("File deleted...");
		    }
		}, delay, unit);
	}
	
	@RequestMapping(value = "/download/{file_name:.+}", method = RequestMethod.GET)//tips :.+ added else extension is deleted...
	public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) throws IOException {
		
		File file =  new File(fileName);
		
		if(!file.exists()){
			manageFileRemoved(response, file);
			return;
		}
		logger.debug("Download file " + file.getAbsolutePath());
		
		response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition","attachment;filename="+fileName);
	    InputStream is = new FileInputStream(file);
	    IOUtils.copy(is, response.getOutputStream());
	    response.flushBuffer();
	}

	private void manageFileRemoved(HttpServletResponse response, File file)
			throws IOException {
		logger.debug("File " + file.getAbsolutePath() + " doesn't exist anymore");
		String myString = "Your file " + file.getName() + " has been removed from our server";
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition","attachment;filename=error.txt");
		ServletOutputStream out = response.getOutputStream();
		out.println(myString);
		out.flush();
		out.close();
	}
}