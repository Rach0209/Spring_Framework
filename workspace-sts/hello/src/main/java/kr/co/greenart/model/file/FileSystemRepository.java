package kr.co.greenart.model.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	private final File saveFolder = new File("d:\\temp\\");
	private final Path root = Paths.get("d:\\temp\\");
	
	@Override
	public Resource getByName(String fileName) {
		// 원하는 것 파일 이름으로 가져오기
		// 쉽게 사용할 수 있는 UrlResource; 특정 경로에 있는것을 가져올 수 있따.
		// 경로는 밑에사용한 것을 가져와서 씀.
		try {
			return new UrlResource(new File(saveFolder.getAbsolutePath()
						+ File.separatorChar
						+ fileName).toURI());
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public List<String> getAllnames() {
//		listFiles()는 파일 배열을 반환해준다.
//		listFiles(FileFilter filter); 파일 필터를 사용할 수 있다.
		File[] filearr = saveFolder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
//				폴더가 아닐때 반환하기.
				return !pathname.isDirectory();
			}			
		});
		
		List<String> list = new ArrayList<>();
		for (File f : filearr) {
			if (!f.isDirectory()) {
				list.add(f.getName());
			}
		}
		return list;
		
		
//		stream에는 필터가 있는데, '함수'라는 것을 넣어주어야 하는데 자바는 '함수'를 넣을 수 없다. => 객체가 아니기 때문.
//		함수를 표현하기 위해서 인터페이스 형태로 정의하여, 구현하게되면 함수를 표현할 수 있다.
//		자바 8버전에서는 함수를 인터페이스 형태로 구현 가능하고, '람다식 표현'으로 구현할 수 있다.
//		8버전부터 함수형 프로그래밍을 도입하여 람다식이 가능해진 것. 
//		x(인자,파라미터값) -> (함수영역)
//		filter에 함수(람다식)를 사용하여 계속해서 걸러내서 원하는 값만 가져올 수 있다.
//		map은 stream에 있는 원소들을 매핑할 수 있음. 여기선 pathStream//
//		walk는 해당경로에 있는 것들을 다 가져옴(?)
//		자기 자신을 똑같이 반환해줌(??)//
//		try {
//			return Files.walk(root, 1)
//				.filter(t -> !t.equals(this.root))
//				.filter(x -> Files.isDirectory(x))
//				.map(y -> y.toString())
//				.collect(Collectors.toList());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
	}

	// MultipartResolver를 WebConfig.java에서 Bean 등록 하였다.
	// pom에서 의존성 등록하여도 Bean 등록 해주어야 사용 가능.
	@Override
	public int save(MultipartFile file) {
		File saveFolder = new File("d:\\temp\\");
		if (!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		try {
			// separator를 해주지 않았을 때, 파일 이름에 temp가 붙어서 d드라이브에 저장 되었었다!
			file.transferTo(new File(saveFolder.getAbsolutePath()
					+ File.separator
					+ file.getOriginalFilename()));
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		
		// 둘 중 하나의 방법으로 하기~ 나중에 밑에 방법이 더 편할 거임.
//		Path saveFolder = Paths.get("d:\\");
//		try {
////			createDirectories Option검색해서 사용 할 수 있음
////			Files.createDirectories(saveFolder, option);
//			// 옵션이 찾기 힘들어서 if로 처리해놨음.
//			if (!Files.exists(saveFolder)) {
//				Files.createDirectories(saveFolder);
//			}
//			file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename())).normalize());
//			return 1;
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//			return 0;
//		}
	}
	
}
