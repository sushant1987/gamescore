/**
 * 
 */
package com.accedo.gamescore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accedo.gamescore.dataobject.HighScore;
import com.accedo.gamescore.exception.UnprocessableEntityException;
import com.accedo.gamescore.service.HighScoreDefaultService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * @author Sushant Kumar Singh
 *
 */
@RestController
@RequestMapping("/v1/highscores")
public class HighScoreController {
	
	Logger log = LoggerFactory.getLogger(HighScoreController.class);

	@Autowired
	private HighScoreDefaultService highScoreDefaultService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<HighScore> get() {
		return highScoreDefaultService.findAll();
	}

	@Operation(summary = "Fetching a list of highscores for a title with rank of user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of Score", content = @Content(mediaType = "text/plain;charset=UTF-8")) })
	@GetMapping
	@RequestMapping("/titles/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<HighScore> getByUser(@PathVariable String id) {
		return highScoreDefaultService.findByTitleByScoreDesc(id);

	}

	@Operation(summary = "Registering a score for a title and user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Score created", content = @Content(mediaType = "text/plain;charset=UTF-8")),
			@ApiResponse(responseCode = "400", description = "Bad Resquest", content = @Content(mediaType = "text/plain;charset=UTF-8")),
			@ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content(mediaType = "text/plain;charset=UTF-8")) })
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@Valid @RequestBody HighScore highScore) throws UnprocessableEntityException {
		highScoreDefaultService.save(highScore);
	}

}
