package com.altran.ci.fitnesse.init;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;

import org.apache.deltaspike.cdise.api.CdiContainer;

public class Context {
    static CdiContainer cdiContainer;

	public static void initCdiContainer(CdiContainer diContainer) {
		cdiContainer = diContainer;
	}
	
	private static boolean beansPrinted = false;
    public static DiContainer dIContainer() {
        return new DiContainer() {
        	
            @SuppressWarnings("unchecked")
            @Override
            public <T> T getBeanByClass(Class<?> clazz) {
                BeanManager beanManager = cdiContainer.getBeanManager();
                
                printAllBeans(beanManager);
                Set<Bean<?>> beans = beanManager.getBeans(clazz);
                if (!beans.isEmpty()) {
                    Bean<?> bean = beans.iterator().next();
                    CreationalContext<?> ctx = beanManager.createCreationalContext(beans.iterator().next());
                    return (T) beanManager.getReference(bean, clazz, ctx);
                }
                return null;
            }

			private void printAllBeans(BeanManager beanManager) {
				if (!beansPrinted) {
					Set<Bean<?>> beans = beanManager.getBeans(Object.class,new AnnotationLiteral<Any>() {});
			        for (Bean<?> bean : beans) {
			            String className = bean.getBeanClass().getName();
			            if (className.startsWith("net.volvocars")) {
			                System.out.println(bean.getBeanClass().getName());
			            }
			        }
			        beansPrinted = true;
				}
			}
        };
    }

}
