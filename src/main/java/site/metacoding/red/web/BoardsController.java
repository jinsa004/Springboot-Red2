package site.metacoding.red.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.web.dto.request.boards.UpdateDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.response.RespDto;

@RequiredArgsConstructor
@RestController
public class BoardsController {
	private final BoardsDao boardsDao;
		
	@PostMapping("/boards")
	public RespDto<?> insert(WriteDto writeDto){
		boardsDao.insert(writeDto);
		return new RespDto<>(1, "글작성완료", null);
	}
	
	@GetMapping("/boards/{id}")
	public RespDto<?> getBoards(@PathVariable Integer id){
		return new RespDto<>(1, "작성목록 보기", boardsDao.findByIdtoDetail(id));
	}
	
	@GetMapping("/boards")
	public RespDto<?> getBoardsList(){
		return new RespDto<>(1, "작성목록 모두보기", boardsDao.findAll());
	}
	
	@PutMapping("/boards/{id}")
	public RespDto<?> update(@PathVariable Integer id, UpdateDto updateDto){
		//영속화
		Boards boardsPS = boardsDao.findById(id);
		//변경
		boardsPS.전체수정(updateDto);
		//업데이트
		boardsDao.update(boardsPS);
		
		return new RespDto<>(1,"수정성공", null);
	}
	
	@DeleteMapping("/boards/{id}")
	public RespDto<?> delete(@PathVariable Integer id){
		boardsDao.delete(id);
		return new RespDto<>(1,"삭제성공", null);
	}
}
