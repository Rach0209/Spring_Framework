package kr.co.greenart.model.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	@Override
	public Resource getByName(String fileName) {
		throw new UnsupportedOperationException("미구현");
	}

	@Override
	public List<String> getAllnames() {
		throw new UnsupportedOperationException("미구현");
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
