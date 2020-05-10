package edu.tcu.cs.hogwartsartifacts.controller;

import edu.tcu.cs.hogwartsartifacts.domain.Artifact;
import edu.tcu.cs.hogwartsartifacts.domain.Result;
import edu.tcu.cs.hogwartsartifacts.domain.StatusCode;
import edu.tcu.cs.hogwartsartifacts.service.ArtifactService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artifacts")
public class ArtifactController {

    private ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping
    public Result findAll() {
        List<Artifact> all = artifactService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", all);
        return result;
    }

    @GetMapping("/{artifactId}")
    public Result findById(@PathVariable String artifactId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", artifactService.findById(artifactId));
    }

    @PostMapping
    public Result save(@RequestBody Artifact newArtifact) {
        artifactService.save(newArtifact);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{artifactId}")
    public Result update(@PathVariable String artifactId, @RequestBody Artifact updatedArtifact) {
        artifactService.update(artifactId, updatedArtifact);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{artifactId}")
    public Result delete(@PathVariable String artifactId) {
        artifactService.delete(artifactId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}