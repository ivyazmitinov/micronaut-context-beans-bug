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

// Works (always, somehow)
@Factory
public class ConfigOne
{
    @Context
    @Bean
    @Named("one")
    public ContainerClass containerClass(@Named("one") Set<StrategyClass> strategyClasses)
    {
        return new ContainerClass(strategyClasses);
    }

    @Context
    @Bean
    @Named("one")
    StrategyClass strategyClassOne()
    {
        return new StrategyClassImplOne();
    }

    @Context
    @Bean
    @Named("one")
    StrategyClass strategyClassTwo()
    {
        return new StrategyClassImplTwo();
    }
}
