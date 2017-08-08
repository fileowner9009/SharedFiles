package com.nisum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nisum.dto.FileInfo;
import com.nisum.gitAPIResponse.File;

@RestController
@EnableAutoConfiguration
@RequestMapping("/fileViewer" )
public class DirectoryViewer {

	private static String API_GET_FILES = "https://api.github.com/repos/fileowner9009/sharedFiles/contents/";
	private static String FILES_DIR = "sharedFiles/Files";
	
	public static void main( String[] args) {
		SpringApplication.run(DirectoryViewer.class, args);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces="application/json" )
	/**
	 * 
	 *  // GET /repos/:owner/:repo/readme
	 * @return contents of the directory
	 */
	List<FileInfo> getDirectoryContents () {
		
		/**
		FileInfo[] files = new FileInfo[]{ new FileInfo("file1", "filePath")};
		return Arrays.asList(files);
		
		**/
		
		RestTemplate restTemplate = new RestTemplate();
		File[] files = restTemplate.getForObject(API_GET_FILES + FILES_DIR, File[].class);
		List<FileInfo> fileInfos = new ArrayList<FileInfo>(files.length);
		
		System.out.println("Number of files found:" + files.length);
		
		for(File file : files){
			fileInfos.add(new FileInfo(file.getName(), file.getPath()));
			System.out.println("Name:" +  file.getName());
			System.out.println("Path:" + file.getPath() + "\n");
			
		}
			
		return fileInfos;
	}

}
