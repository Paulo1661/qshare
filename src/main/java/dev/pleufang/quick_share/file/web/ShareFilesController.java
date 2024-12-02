package dev.pleufang.quick_share.file.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class ShareFilesController {
    @GetMapping
    public String shareFilesIndex(Model model) {
        return "share_files";
    }
}
