package com.example.gradinfo.controller;

import com.example.gradinfo.dto.response.ExamTableDataResponse;
import com.example.gradinfo.dto.response.NonCourseEventTableDataResponse;
import com.example.gradinfo.service.NonCourseEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping(path = "noncourseevent")
@CrossOrigin(origins = "*")
public class NonCourseEventController {

    private NonCourseEventService nonCourseEventService;

    public NonCourseEventController(NonCourseEventService nonCourseEventService) {
        this.nonCourseEventService = nonCourseEventService;
    }

    @GetMapping(path = "/getNonCourseRelatedEventTableDataByIDAndPostNumber")
    public ResponseEntity<List<NonCourseEventTableDataResponse>> getNonCourseRelatedEventTableDataByIDAndPostNumber(@RequestParam String studentId, String spPostNumber) {

        List<NonCourseEventTableDataResponse> response = nonCourseEventService.getNonCourseRelatedEventTableDataByIDAndPostNumber(studentId,spPostNumber);

        return new ResponseEntity<List<NonCourseEventTableDataResponse>>(response, HttpStatus.OK);
    }
    @GetMapping(path = "/getExamCommitteeTableDataByIDAndPostNumber")
    public ResponseEntity<List<ExamTableDataResponse>> getExamCommitteeTableDataByIDAndPostNumber(@RequestParam String studentId, String spPostNumber) {
        List<ExamTableDataResponse> responses = nonCourseEventService.getExamCommitteeTableDataByIDAndPostNumber(studentId, spPostNumber);
        return new ResponseEntity<List<ExamTableDataResponse>>(responses, HttpStatus.OK);
    }
}
