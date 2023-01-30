package com.bangbang.controller;

import com.bangbang.domain.broadcast.Broadcast;
import com.bangbang.domain.replay.Replay;
import com.bangbang.dto.replay.ReplayListResponseDto;
import com.bangbang.dto.replay.ReplayResponseDto;
import com.bangbang.dto.replay.ReplaySaveRequestDto;
import com.bangbang.service.ReplayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "ReplayRestController-Version1")
public class ReplayRestController {
    private final ReplayService replayService;

    //다시보기 등록
    @ApiOperation(value = "다시보기 등록", notes = "다시보기를 등록합니다.")
    @PostMapping(value = "/replays/new")
    public ResponseEntity<?> newReplay(@RequestBody ReplaySaveRequestDto requestDto) throws Exception {

        replayService.newReplay(requestDto);

        return new ResponseEntity<Object>(new HashMap<String, Object>() {{
            put("result", true);
            put("msg", "다시보기 등록에 성공하였습니다.");
        }}, HttpStatus.OK);
    }

    //전체 다시보기 조회
    @ApiOperation(value = "다시보기 전체 조회", notes = "모든 다시보기를 조회합니다.")
    @GetMapping(value = "/replays")
    public List<ReplayListResponseDto> searchReplayAll(){return replayService.searchReplayAll();}

    //해당 다시보기 조회
    @ApiOperation(value = "해당 다시보기 조회", notes = "해당 다시보기를 조회합니다.")
    @GetMapping(value = "/replays/{replayId}")
    public ReplayResponseDto replayDetail(@PathVariable Long replayId){
        return replayService.replayDetail(replayId);
    }
}