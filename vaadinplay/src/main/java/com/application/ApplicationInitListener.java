package com.application;

import org.apache.log4j.Logger;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

/**
 * This class is used to listen to BeforeEnter event of all UIs in order to check whether a user is signed in or not
 * before allowing entering any page. It is registered in a file named com.vaadin.flow.server.VaadinServiceInitListener
 * in META-INF/services.
 */
public class ApplicationInitListener implements VaadinServiceInitListener {
    private static final long serialVersionUID = -5153701302647654880L;
    protected static Logger logger = Logger.getLogger(ApplicationInitListener.class);

    @Override
    public void serviceInit(ServiceInitEvent initEvent) {
        //        final AccessControl accessControl = AccessControlFactory.getInstance().getAccessControl();

        logger.info("initEvent: '" + initEvent.getSource() + "'");
        //        initEvent.getSource().addUIInitListener(uiInitEvent -> {
        //            uiInitEvent.getUI().addBeforeEnterListener(enterEvent -> {
        //                if (!accessControl.isUserSignedIn()) {
        //                    logger.info("target: '" + enterEvent.getNavigationTarget() + "'");
        //
        //                    if (NormalLogin.class.equals(enterEvent.getNavigationTarget())) {
        //                        enterEvent.rerouteTo(NormalLogin.class);
        //                    } else if (DJLogin.class.equals(enterEvent.getNavigationTarget())) {
        //                        enterEvent.rerouteTo(DJLogin.class);
        //                    }
        //                }
        //            });
        //        });
    }
}
