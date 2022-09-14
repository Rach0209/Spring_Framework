package kr.co.greenart.model.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


// JdbcTemplate을 사용하여 이진데이터 다루기!!
@Repository
@Primary
public class FileDBRepository implements FileRepository {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Resource getByName(String fileName) {
		byte[] blob = jdbc.queryForObject("SELECT file FROM files WHERE name=?"
				, byte[].class
				, fileName);
		// 이진자원을 감싸주는 ByteArrayResource(byte[])
		return new ByteArrayResource(blob);
	}

	@Override
	public List<String> getAllnames() {
		// query는 mapping을 하고 잇다.
		// String 만 필요해서, queryForList를 사용해서 쉽게 그 타입의 리스트를 얻을 수 있음
		// 여러 컬럼이면, Map형태로도 받을 수 있음.
		return jdbc.queryForList("SELECT name FROM files", String.class);
	}

	@Override
	public int save(MultipartFile file) {
		try {
			return jdbc.update("INSERT INTO files (name, file) VALUES (?, ?)"
					, file.getOriginalFilename()
					, file.getBytes());
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
