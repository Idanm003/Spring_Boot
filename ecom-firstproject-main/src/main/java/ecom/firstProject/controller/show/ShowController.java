package ecom.firstProject.controller.show;

import ecom.firstProject.responses.show.TvMazeResponse;
import ecom.firstProject.service.show.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shows")
public class ShowController {

    @Autowired
    private TvShowService tvMazeService;

    @GetMapping(value = "/{id}")
    TvMazeResponse getTvShowsById(@PathVariable Integer id){
        return tvMazeService.getShowById(id);
    }

}
