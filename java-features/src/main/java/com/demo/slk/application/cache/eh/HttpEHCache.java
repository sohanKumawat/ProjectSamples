package com.demo.slk.application.cache.eh;

import org.springframework.cache.annotation.EnableCaching;



@EnableCaching // for cacheManager and related beans to get auto-configured
public class HttpEHCache {/*

    public static final int DEFAULT_MAX_CACHE_ENTRIES = 10;

    @Value("#{cacheManager.getCache('httpClient')}")
    private Cache httpClientCache;


    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
        result.setMaxTotal(20);
        return result;
    }

    @Bean
    public CacheConfig cacheConfig() {
        CacheConfig result = CacheConfig
            .custom()
            .setMaxCacheEntries(DEFAULT_MAX_CACHE_ENTRIES)
            .build();
        return result;
    }

    @Bean
    public HttpCacheStorage httpCacheStorage() {
    	Ehcache httpEhcache = (Ehcache) this.httpClientCache.getNativeCache();
        HttpCacheStorage result = new EhcacheHttpCacheStorage(httpEhcache);
        return result;
    }

    @Bean
    public HttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
        CacheConfig cacheConfig, HttpCacheStorage httpCacheStorage) {

        HttpClient result = CachingHttpClientBuilder
            .create()
            .setCacheConfig(cacheConfig)
            .setHttpCacheStorage(httpCacheStorage)
            .disableRedirectHandling()
            .setConnectionManager(poolingHttpClientConnectionManager)
            .build();
        return result;
    }

    @Bean
    public RestTemplate restTemplate(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }

*/}
