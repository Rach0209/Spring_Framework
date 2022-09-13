package kr.co.greenart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.greenart.model.file.FileRepository;

// 파일 업로드를 위해. pom.xml에 라이브러리 의존성 추가하기. ( commons fileupload 검색)

@Controller
@RequestMapping("/file")
// 파일(이진데이터)을 다루기.
public class FileController {
	@Autowired
	private FileRepository repo;
	
	@GetMapping
	public String fileForm() {
		return "fileForm";
	}
	
	// 파일을 업로드 하기 위해서는 MultipartFile가 필요하다.
	@PostMapping
	public String submit(@RequestParam/* 이름 주고 싶을 때(value = "asdf")*/ MultipartFile upload) {
		String filename = upload.getOriginalFilename(); // 실제 파일이름 / getName()은 파라미터의 이름이다.
		int result = repo.save(upload);
		
		return "redirect:file/result";
	}
	
	@GetMapping("/result")
	public String view( ) {
		
		return "fileView";
	}
}
