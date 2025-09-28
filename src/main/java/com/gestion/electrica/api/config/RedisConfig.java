package com.gestion.electrica.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        
        // Establece la fábrica de conexiones
        template.setConnectionFactory(connectionFactory);
        
        // Configura el serializador para las claves (keys) a String
        template.setKeySerializer(new StringRedisSerializer());
        
        // Configura el serializador para los valores (values) a JSON
        // Esto permite guardar objetos Java como JSON en Redis
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        // También para las claves y valores de tipo Hash
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        template.afterPropertiesSet();
        
        return template;
    }
}
