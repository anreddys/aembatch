package com.aem.employ.core.schedulers;

import java.util.Date;

import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.employ.core.devloperimpl.ReadXMLFilesImpl;



@Component(immediate = true,service =Runnable.class)
public class SimpleEmployDataSchedular implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(SimpleEmployDataSchedular.class);

	@Reference
	private ReadXMLFilesImpl readXmls;
	
	private BundleContext bundleContext;

	@Reference
	private Scheduler scheduler;

	

	public void run() {
		log.info("Running...");
	}

	protected void activate(ComponentContext ctx) {
		this.bundleContext = ctx.getBundleContext();

		// Schedule a Sling Job to invoke an MBean operation to obtain number of Stale
		// Workflow items
		// case 3: with fireJobAt(): executes the job at a specific date (date of
		// deployment + delay of 30 seconds)
		String jobName3 = "case3";

		String schedulingExpression ="0 * * * * ?";

		final Date fireDate = new Date();

		final Runnable job = new Runnable() {
			public void run() {

				readXmls.getXMLFiles();

				log.info("--------------writeToFile Executed Successfully------------------");

			}
		};
		try {
			// Add the Job
			this.scheduler.addJob("myJob", job, null, schedulingExpression, true);
			

		} catch (Exception e) {
			job.run();
		}

	}

	protected void deactivate(ComponentContext ctx) {
		this.bundleContext = null;
	}

}
