package com.nisum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.nisum.dto.FileContentsBean;
import com.nisum.dto.FileInfo;
import com.nisum.dto.FileRow;
import com.nisum.gitAPIRequest.UpdateFileContentRequest;


@Controller
public class FilesController {

		private static String API_GET_FILES = "https://api.github.com/repos/fileowner9009/sharedFiles/contents/";
		private static String FILES_DIR = "sharedFiles/Files";
		private Map<String, String> fileNameToDownloadUrl;
		
		/**
		 *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    n
		 *  // GET /repos/:owner/:repo/readme
		 * @return contents of the directory
		 */
		@GetMapping("/")
		public String getDirectoryContents (Model model) {
			
			FileInfo[] files = new FileInfo[]{ new FileInfo("file1", "filePath", "https://raw.githubusercontent.com/fileowner9009/SharedFiles/master/sharedFiles/Files/file1.txt", "dcfadbbaf6dc740c814692cee1a5250d451e8e05"), 
					                           new FileInfo("file2", "filePath2", "https://raw.githubusercontent.com/fileowner9009/SharedFiles/master/sharedFiles/Files/file2.txt", "03630bfad6429b1c2e505ff4da888588c07a73eb")};
			
			for(FileInfo file : files){
				System.out.println("Name:" +  file.getName());
				System.out.println("Path:" + file.getPath() + "\n");
				System.out.println("DownloadURL:" + file.getDownloadUrl() + "\n");
				System.out.println("SHA:" + file.getSha() + "\n");
			}
			
			Map<String, String> fileInfoMap = new HashMap<String, String>();
			for(FileInfo fileInfo : files){
				fileInfoMap.put(fileInfo.getName(), fileInfo.getDownloadUrl());
			}
			this.fileNameToDownloadUrl = fileInfoMap;
			
			model.addAttribute("files", Arrays.asList(files));
			model.addAttribute("message", "My message");
			return ("viewFiles");
		}
		
			/**
			RestTemplate restTemplate = new RestTemplate();
			File[] files = restTemplate.getForObject(API_GET_FILES + FILES_DIR, File[].class);
			List<FileInfo> fileInfos = new ArrayList<FileInfo>(files.length);
			
			System.out.println("Number of files found:" + files.length);
			
				fileInfos.add(new FileInfo(file.getName(), file.getPath(), file.getDownload_url()));
			for(File file : files){
				System.out.println("Name:" +  file.getName());
				System.out.println("Path:" + file.getPath() + "\n");
				System.out.println("Path:" + file.getDownload_url() + "\n");
				
			}
				
			return fileInfos;
		}
			**/
		
		@GetMapping("/viewFile/{fileName}")
		public String getFileContents(@PathVariable String fileName, Model model) {
			System.out.println("In getFileContents");
			RestTemplate restTemplate = new RestTemplate();
			String fileDownloadUrl = fileNameToDownloadUrl.get(fileName);
			if(fileDownloadUrl == null){
				
			}
			
			/**restTemplate.getInterceptors().add((request, body, execution) -> {
	            ClientHttpResponse response = execution.execute(request,body);
	            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
	            return response;
	        });
	        
	        
			FileRow[] fileRows = restTemplate.getForObject(fileDownloadUrl, FileRow[].class);
			**/
			
			FileRow[] fileRows = new FileRow[3];
			fileRows[0] = new FileRow("San Jose", "California", "United States");
			fileRows[1] = new FileRow("Milpitas", "California", "United States");
			fileRows[2] = new FileRow("Sunnyvale", "California", "United States");
			
			FileContentsBean fileContentsBean = new FileContentsBean();
			fileContentsBean.setFileRows(Arrays.asList(fileRows));
			model.addAttribute("fileContentsBean", fileContentsBean);
			return "fileInfo";
		}
		
		public void saveOnGit(@PathVariable String filePath, @RequestBody FileRow[] filesRows){
			///repos/:owner/:repo/contents/:path
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("");
			/**
			 * {
	  				"message": "my commit message",
	  				"committer": {
	    				"name": "Scott Chacon",
	    				"email": "schacon@gmail.com"
	  				},
	  				"content": "bXkgdXBkYXRlZCBmaWxlIGNvbnRlbnRz",
	  				"sha": "329688480d39049927147c162b9d2deaf885005f"
				}
			
			UpdateFileContentRequest request = new UpdateFileContentRequest("");
			restTemplate.put(API_GET_FILES + FILES_DIR, ); */
			
		}
	   @PostMapping(value = "/saveFile")	
	   public String saveFile( @ModelAttribute FileContentsBean fileContentsBean, Model model) {
			System.out.println("In save file");
			
			if(fileContentsBean.getFileRows() == null || fileContentsBean.getFileRows().isEmpty()){
				fileContentsBean.setMessage("File Contents are empty!!");
				return "fileInfo";
			}
			
			System.out.println("fileContentsBean.getNewCityName():"+ fileContentsBean.getNewCityName());
			System.out.println("fileContentsBean.getNewStateName():"+ fileContentsBean.getNewStateName());
			System.out.println("fileContentsBean.getNewCountryName():"+ fileContentsBean.getNewCountryName());
			
			if(fileContentsBean.getNewCityName() != null && fileContentsBean.getNewCountryName() != null && fileContentsBean.getNewStateName() != null){
				System.out.println("Added new row to fileContentsBean");
				fileContentsBean.getFileRows().add(new FileRow(fileContentsBean.getNewCityName(), fileContentsBean.getNewStateName(), fileContentsBean.getNewCountryName()));
				fileContentsBean.setNewCityName(null);
				fileContentsBean.setNewStateName(null);
				fileContentsBean.setNewCountryName(null);
				model.addAttribute("fileContentsBean", fileContentsBean);
				System.out.println("returning fileInfo");
				return "fileInfo";
			}
			
			for( FileRow row: fileContentsBean.getFileRows()){
				System.out.println(row.getCity() + " "  + row.getState() + " " + row.getCountry());
			}
			
			/**UpdateFileContentRequest request = new UpdateFileContentRequest( message, committerName committerEmail, content,  sha);
			restTemplate.put(API_GET_FILES + FILES_DIR, )**/
			return "fileInfo";
			
		}
	   
	 /**  @PostMapping(value = "/add", )	
	   public String saveFile( @ModelAttribute FileContentsBean fileContentsBean) {
			System.out.println("In save file");
			
			if(fileContentsBean.getFileRows() == null || fileContentsBean.getFileRows().isEmpty()){
				fileContentsBean.setMessage("File Contents are empty!!");
				return "fileInfo";
			}
			
			if(fileContentsBean.getNewCityName() != null && fileContentsBean.getNewCountryName() != null && fileContentsBean.getNewStateName() != null){
				fileContentsBean.getFileRows().add(new FileRow(fileContentsBean.getNewCityName(), fileContentsBean.getNewStateName(), fileContentsBean.getNewCountryName()));
			}
			
			for( FileRow row: fileContentsBean.getFileRows()){
				System.out.println(row.getCity() + " "  + row.getState() + " " + row.getCountry());
			}
			//UpdateFileContentRequest request = new UpdateFileContentRequest( message, committerName committerEmail, content,  sha);
			//restTemplate.put(API_GET_FILES + FILES_DIR, )
			return "fileInfo";
			
		} **/
	   
	/**@PostMapping(value = "/add")
	public String addFileContents(@ModelAttribute FileRow fileRow) {
		System.out.println("In add file row");

		if (fileRow == null || fileRow.getCity() != null) {
			System.out.println("Contents is empty");
			return "fileInfo";
		}

		System.out.println(fileRow.getCity() + " " + fileRow.getState() + " " + fileRow.getCountry());

		// UpdateFileContentRequest request = new UpdateFileContentRequest(
		// message, committerName committerEmail, content, sha);
		// restTemplate.put(API_GET_FILES + FILES_DIR, )
		return "fileInfo";

	}**/
}
