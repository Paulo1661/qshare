package dev.pleufang.quick_share.text.repository;

import dev.pleufang.quick_share.text.model.ShareTextSession;
import org.springframework.data.repository.CrudRepository;

public interface ShareTextSessionRepository extends CrudRepository<ShareTextSession, String> {
}
