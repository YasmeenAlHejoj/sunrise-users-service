package com.yasmeenhj.poc.usersservice.users.data.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class UserRepoConfig {

    @Bean
    @ConditionalOnProperty(prefix = "application.userRepo", name = "type",havingValue  = "JPA")
    public UsersRepo usersRepoJpa() {
        return new UserRepoDatabaseImpl();
    }

    @Bean
    @ConditionalOnProperty(prefix = "application.userRepo", name = "type", havingValue  = "NoSQL")
    public UsersRepo usersRepoNoSql() {
        return new UserRepoInNoSqlImpl();
    }

    @Bean
    @ConditionalOnProperty(prefix = "application.userRepo", name = "type", havingValue  = "InMemory")
    public UsersRepo usersRepoInMemory() {
        return new UserRepoInMemoryImpl();
    }


    @Bean
    @ConditionalOnProperty(prefix = "application.userRepo", name = "type", havingValue  = "FeignClint")
    public UsersRepo usersRepoFeignClint(UserFeignClient client) {
        return new UserRepoFeignImpl(client);
    }
}
