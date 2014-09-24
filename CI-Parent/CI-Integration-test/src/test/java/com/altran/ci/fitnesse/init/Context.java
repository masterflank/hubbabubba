package com.altran.ci.fitnesse.init;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.cdise.api.CdiContainer;

public class Context {
	static CdiContainer cdiContainer;

	public static void initCdiContainer(CdiContainer diContainer) {
		cdiContainer = diContainer;
	}

	public static DiContainer dIContainer() {
		return new DiContainer() {

			@SuppressWarnings("unchecked")
			@Override
			public <T> T getBeanByClass(Class<?> clazz) {
				BeanManager beanManager = cdiContainer.getBeanManager();

				Set<Bean<?>> beans = beanManager.getBeans(clazz);
				if (!beans.isEmpty()) {
					Bean<?> bean = beans.iterator().next();
					CreationalContext<?> ctx = beanManager
							.createCreationalContext(beans.iterator().next());
					return (T) beanManager.getReference(bean, clazz, ctx);
				}
				return null;
			}
		};
	}

}
