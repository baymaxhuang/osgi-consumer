package org.hhb.osgi.consumer;

import com.google.common.collect.Lists;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.hhb.osgi.provider.impl.HelloWorldServiceImpl;

import java.util.List;

public class HelloWorldActivator implements BundleActivator {
    private HelloWorldConsumer consumer;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        //test for using third-party dependency package
        List<String> strings = Lists.newArrayList("I", "use", "guava", "here");
        System.out.println(strings);

        //test for using my customized dependency package
        //ServiceReference reference = bundleContext.getServiceReference(HelloWorldService.class.getName());
        consumer = new HelloWorldConsumer(new HelloWorldServiceImpl());
        consumer.startTimer();

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        consumer.stopTimer();
    }
}
