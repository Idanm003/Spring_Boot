package ecom.firstProject.redis;

public interface CacheRepository {
    void createCacheEntity(String key, String value);
    String getCacheEntity(String key);
    void updateCacheEntity(String key, String value);
    void deleteCacheEntity(String key);
}
