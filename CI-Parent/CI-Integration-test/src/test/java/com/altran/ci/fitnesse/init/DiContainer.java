package com.altran.ci.fitnesse.init;

/**
 * Interface to retrieve dependency injected class instances from the CDI framework. This way the system can dynamically find
 */
public interface DiContainer {

    /**
     *
     * @param clazz Class of the desired dependency injected instance.
     * @param <T> Generic type
     * @return Fully injected instance of class clazz.
     */
    public <T> T getBeanByClass(Class<?> clazz);
}
