package dev.pleufang.quick_share.web;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/share-text")
    public String shareTextIndex(Model model) {
        return "share_text";
    }

    @HxRequest
    @GetMapping("/share-text")
    public String htmxShareTextIndex(Model model) {
        return "share_text::main";
    }

    @GetMapping("/share-files")
    public String shareFilesIndex(Model model) {
        return "share_files";
    }

    @HxRequest
    @GetMapping("/share-files")
    public String htmxShareFilesIndex(Model model) {
        return "share_files::main";
    }
}
