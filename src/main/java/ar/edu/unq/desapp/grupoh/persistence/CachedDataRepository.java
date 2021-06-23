package ar.edu.unq.desapp.grupoh.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CachedDataRepository {
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	public void save(String contentId, String data) {
        this.redisTemplate.opsForValue().set(contentId, data);
    }
	
	public String findById(String id) {
        return this.redisTemplate.opsForValue().get(id);
    }
}
