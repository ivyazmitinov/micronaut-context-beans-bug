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

// Works
@Factory
public class ConfigThree
{
    @Context
    @Bean
    @Named("three")
    public ContainerClass containerClass(@Named("three") Set<StrategyClass> strategyClasses)
    {
        return new ContainerClass(strategyClasses);
    }

    @Context
    @Bean
    @Named("three")
    StrategyClassImplOne strategyClassOne()
    {
        return new StrategyClassImplOne();
    }

    @Context
    @Bean
    @Named("three")
    StrategyClassImplTwo strategyClassTwo()
    {
        return new StrategyClassImplTwo();
    }
}
