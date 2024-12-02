package dev.pleufang.quick_share.text.web;

import dev.pleufang.quick_share.RandomString;
import dev.pleufang.quick_share.SessionCreator;
import dev.pleufang.quick_share.text.model.ShareTextSession;
import dev.pleufang.quick_share.text.repository.ShareTextSessionRepository;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ShareTextController {

    private final ShareTextSessionRepository sessionRepository;

    public ShareTextController(ShareTextSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/text")
    public String shareTextIndex(@CookieValue(name = "session-code", defaultValue = "") String sessionCode, Model model) {
        if (sessionRepository.findById(sessionCode).isPresent())
            model.addAttribute("sessionCode", sessionCode);
        else
            model.addAttribute("sessionCode", "");
        return "share_text";
    }

    @HxRequest
    @GetMapping("/text")
    public HtmxResponse createSharingSession(HttpServletResponse response, HttpServletRequest request,  Model model) {
        String sessionCode = RandomString.generate();
        Cookie cookie = new Cookie("session-code", sessionCode);
        cookie.setMaxAge(15*60);
        response.addCookie(cookie);

        model.addAttribute("sessionCode", sessionCode);

        ShareTextSession textSession = new ShareTextSession(sessionCode,new SessionCreator(request.getRemoteAddr()));

        this.sessionRepository.save(textSession);

        return HtmxResponse.builder()
                .view("share_text :: sharing-link")
                .view("share_text :: copy-text-btn")
                .build();
    }
}
