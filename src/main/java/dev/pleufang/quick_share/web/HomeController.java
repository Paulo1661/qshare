package dev.pleufang.quick_share.web;

import dev.pleufang.quick_share.text.model.ShareTextSession;
import dev.pleufang.quick_share.text.repository.ShareTextSessionRepository;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
@Validated
public class HomeController {
    private final ShareTextSessionRepository textSessionRepository;

    public HomeController(ShareTextSessionRepository textSessionRepository) {
        this.textSessionRepository = textSessionRepository;
    }

    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @GetMapping("{sessionCode}")
    public String sharingView(
            @PathVariable
            @Size(min = 4, max = 4, message = "Path variable must be exactly 4 characters long")
            String sessionCode, Model model) {

        Optional<ShareTextSession>  textSession = textSessionRepository.findById(sessionCode);
        if (textSession.isPresent()) {
            return "view_shared_text";
        } else {
            model.addAttribute("sessionCode", sessionCode);
            return "page_not_found";
        }

    }
}
