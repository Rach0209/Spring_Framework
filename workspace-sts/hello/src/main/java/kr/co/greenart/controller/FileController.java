package kr.co.greenart.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.greenart.model.file.FileRepository;

// 파일 업로드를 위해. pom.xml에 라이브러리 의존성 추가하기. ( commons fileupload 검색)

// 메모; resources폴더에서 log4j.xml에 value값을 debug로 변경해서 콘솔에 로그로 디버깅 할 수 있는 거 같음. 쌤하는거 보고메모;


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
	public String submit(@RequestParam/* 이름 주고 싶을 때(value = "upload")*/ MultipartFile upload) {
//		String filename = upload.getOriginalFilename(); // 실제 파일이름 / getName()은 파라미터의 이름이다.
		int result = repo.save(upload);
		
		
		
		return "redirect:file/result";
	}
	
	@GetMapping("/result")
	public String view(Model model) {
//		model에 어트리뷰트 형태로 심어놓기.
		List<String> list = repo.getAllnames();
		model.addAttribute("list", list);
		
		return "fileView";
	}
	
//	파일이름이나, 파일의 형태를 받아서 가져와야함
//	view 페이지에 링크를 넣어 주었다.
	@GetMapping("/down")
	public ResponseEntity<Resource> down(@RequestParam String item) {
		// 파일이름으로 가져올 수 있게 하기.
		Resource resource = repo.getByName(item);
		
		if (resource == null) {
			return (ResponseEntity<Resource>) ResponseEntity.notFound();
		}
		
		HttpHeaders headers = new HttpHeaders();
		// 2진 데이터를 사용할 것이라서 MediaType.APPLICATION_OCTET_STREAM 사용
		// MediaType.APPLICATION_OCTET_STREAM_VALUE가 되면 String으로 반환되니 주의
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// header부분에 한글로 들어가면 안되서, item을 URL인코딩.
		try {
			headers.add("Content-Disposition", "attachement; filename=" + URLEncoder.encode(item, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// body와 header와 응답코드를 넣을 수 있음.
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
}
