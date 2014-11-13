package com.tutorials.spring.upload;

import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


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
		    
		String result = mpf.getOriginalFilename() +" uploaded! - " + mpf.getBytes().length;
		
    	logger.debug(result);
	    
    	return new ResponseEntity<String>(result, HttpStatus.OK);
	 }
}