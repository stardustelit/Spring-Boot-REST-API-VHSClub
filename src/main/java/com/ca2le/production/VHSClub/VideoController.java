package com.ca2le.production.VHSClub;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class VideoController {

    private final VideoRepository repository;

    VideoController(VideoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/inventory")
    List<VideoCassette> all() {
        return repository.findAll();
    }
    @PostMapping("/add")
    VideoCassette newVideoCasette(@RequestBody VideoCassette newVideoCasette) {
        return repository.save(newVideoCasette);
    }
    @GetMapping("/video/{id}")
    VideoCassette one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new VideoCasetteNotFoundException(id));
    }
    @PutMapping("/replacevideo/{id}")
    VideoCassette replaceVideoCassette(@RequestBody VideoCassette newVideoCassette, @PathVariable Long id) {

        return repository.findById(id)
                .map(videoCassette -> {
                    videoCassette.setTitle(videoCassette.getTitle());
                    return repository.save(videoCassette);
                })
                .orElseGet(() -> {
                    newVideoCassette.setId(id);
                    return repository.save(newVideoCassette);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteVideoCassette(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
