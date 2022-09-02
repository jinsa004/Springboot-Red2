package site.metacoding.red.web.dto.request.boards;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateDto {
	private String title;
	private String content;
	private Timestamp updatedAt;
}
