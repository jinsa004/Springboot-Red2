package site.metacoding.red.domain.boards;

import java.sql.Timestamp;

import lombok.Getter;
import site.metacoding.red.web.dto.request.boards.UpdateDto;

@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private Integer usersId;
	private Timestamp createdAt;
	
	public void 전체수정(UpdateDto updateDto) {
		this.title = updateDto.getTitle();
		this.content = updateDto.getContent();
	}
	
	public void 제목수정(String title) {
		this.title = title;
	}
	
	public void 내용수정(String content) {
		this.content  = content;
	}
}
