package com.bug.config;

import com.bug.ContainerClass;
import com.bug.StrategyClass;
import com.bug.StrategyClassImplOne;
import com.bug.StrategyClassImplTwo;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;

import javax.inject.Named;
import java.util.Set;

// Doesn't work
@Factory
public class ConfigTwo
{
    @Context
    @Bean
    @Named("two")
    public ContainerClass containerClass(@Named("two") Set<StrategyClass> strategyClasses)
    {
        return new ContainerClass(strategyClasses);
    }

    @Context
    @Bean
    @Named("two")
    StrategyClass strategyClasstwo()
    {
        return new StrategyClassImplOne();
    }

    @Context
    @Bean
    @Named("two")
    StrategyClass strategyClassTwo()
    {
        return new StrategyClassImplTwo();
    }
}
