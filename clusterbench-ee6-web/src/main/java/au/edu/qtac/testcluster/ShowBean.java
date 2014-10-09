/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package au.edu.qtac.testcluster;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.test.clusterbench.web.cdi.SessionScopedCdiSerialBean;


/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
@Named
@RequestScoped
public class ShowBean {

    @Inject
    private SessionScopedCdiSerialBean bean;
    
    @PostConstruct
    public void init() {
        System.out.println("====request hit this instance=====");
    }
    
    public String getCurrentAndIncrease() {
        int serial = bean.getSerial();
        bean.setSerial(serial + 1);
        return String.valueOf(serial);
    }
}
