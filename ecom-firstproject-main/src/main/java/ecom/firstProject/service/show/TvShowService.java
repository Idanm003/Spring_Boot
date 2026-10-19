package ecom.firstProject.service.show;

import ecom.firstProject.responses.show.TvMazeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "tvMazeService",
        url = "${externalApi.tvMaze.url}"
)

public interface TvShowService {
    @GetMapping(value = "/shows/{id}")
    TvMazeResponse getShowById(@PathVariable Integer id);
}
