package com.altran.ci.fitnesse.init;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;

public class FitnesseInit {
	static CdiContainer cdiContainer;

	public boolean init() throws Exception {
		cdiContainer = CdiContainerLoader.getCdiContainer();
		if (cdiContainer.getBeanManager() == null) {
			cdiContainer.boot();
		}

		Context.initCdiContainer(cdiContainer);
		
		return true;
	}
}
