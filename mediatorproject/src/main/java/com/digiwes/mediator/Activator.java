package com.digiwes.mediator;

import java.util.Map;

import org.apache.synapse.config.xml.MediatorFactoryFinder;
import org.apache.synapse.config.xml.MediatorSerializer;
import org.apache.synapse.config.xml.MediatorSerializerFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	public void start(BundleContext context) throws Exception {
		{
            Map<javax.xml.namespace.QName, java.lang.Class> mediatorFactoryMap = MediatorFactoryFinder.getInstance().getFactoryMap();
            mediatorFactoryMap.put(MyTestMediatorFactory.MYTEST_QNAME, MyTestMediatorFactory.class);
        }
        {
            Map<String, MediatorSerializer> mediatorSerializerMap = MediatorSerializerFinder.getInstance().getSerializerMap();
            mediatorSerializerMap.put(MyTestMediator.class.getName(), MyTestMediatorSerializer.class.newInstance());
        }
	}

	public void stop(BundleContext context) throws Exception {
		// Maybe undo what was done in the start(BundleContext) method..?
        System.out.println(this.getClass().getName() + ".stop(BundleContext) called ---------------------------------------------");
	}
}
