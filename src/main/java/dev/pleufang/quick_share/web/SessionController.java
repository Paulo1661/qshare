package dev.pleufang.quick_share.web;

import dev.pleufang.quick_share.text.model.ShareTextSession;
import dev.pleufang.quick_share.text.repository.ShareTextSessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    private final ShareTextSessionRepository sessionRepository;

    public SessionController(ShareTextSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping
    public List<ShareTextSession> getSessions() {
        return (List<ShareTextSession>) sessionRepository.findAll();
    }
}
