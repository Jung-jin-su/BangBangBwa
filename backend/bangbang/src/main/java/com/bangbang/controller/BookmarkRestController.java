package com.bangbang.controller;

import com.bangbang.dto.bookmark.BookmarkListResponseDto;
import com.bangbang.dto.bookmark.BookmarkResponseDto;
import com.bangbang.dto.bookmark.BookmarkSaveRequestDto;
import com.bangbang.dto.bookmark.BookmarkUpdateRequestDto;
import com.bangbang.service.BookmarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value="BookmarkRestController-Version 1")
public class BookmarkRestController {
  private final BookmarkService bookmarkService;

  @GetMapping(value = "/bookmarks")
  @ApiOperation(value = "모든 즐겨찾기 조회", notes = "즐겨찾기를 모두 조회합니다.")
  public List<BookmarkListResponseDto> searchBookmarkAll(){
    return bookmarkService.searchBookmarkAll();
  }

  @GetMapping(value = "/bookmarks/{bookmarkId}")
  @ApiOperation(value = "해당 즐겨찾기 조회", notes = "해당 즐겨찾기를 조회합니다.")
  public BookmarkResponseDto bookmarkDetail(@PathVariable Long bookmarkId){
    return bookmarkService.bookmarkDetail(bookmarkId);
  }


  @PostMapping(value = "/bookmarks/new")
  @ApiOperation(value = "즐겨찾기 등록", notes = "즐겨찾기를 등록합니다.")
  public ResponseEntity<?> newBookmark(@RequestBody BookmarkSaveRequestDto requestDto){
    bookmarkService.newBookmark(requestDto);
    return new ResponseEntity<Object>(new HashMap<String, Object>() {{
      put("result", true);
      put("msg", "즐겨찾기 등록을 성공하였습니다.");
    }}, HttpStatus.OK);
  }

  @PatchMapping(value = "/bookmarks/modify/{bookmarkId}")
  @ApiOperation(value = "즐겨찾기 수정", notes = "즐겨찾기를 수정합니다.")
  public ResponseEntity<?> modifyBookmark(@PathVariable Long bookmarkId, @RequestBody
      BookmarkUpdateRequestDto requestDto){
    bookmarkService.modifyBookmark(bookmarkId, requestDto);

    return new ResponseEntity<Object>(new HashMap<String, Object>() {{
      put("result", true);
      put("msg", "즐겨찾기 수정을 성공하였습니다.");
    }}, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bookmarks/{bookmarkId}")
  @ApiOperation(value = "즐겨찾기 삭제", notes = "즐겨찾기를 삭제합니다.")
  public ResponseEntity<?> deleteBookmark(@PathVariable Long bookmarkId){
    bookmarkService.deleteBookmark(bookmarkId);
    return new ResponseEntity<Object>(new HashMap<String, Object>() {{
      put("result", true);
      put("msg", "즐겨찾기 삭제를 성공하였습니다.");
    }}, HttpStatus.OK);
  }
}
