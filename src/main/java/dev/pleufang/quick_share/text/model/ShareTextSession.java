package dev.pleufang.quick_share.text.model;

import dev.pleufang.quick_share.SessionCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("share_text_sessions")
public record ShareTextSession(@Id String sessionCode, String sharedText, SessionCreator sessionCreator) {
    public ShareTextSession(String sessionCode, SessionCreator sessionCreator) {
        this(sessionCode, "", sessionCreator);
    }
}
