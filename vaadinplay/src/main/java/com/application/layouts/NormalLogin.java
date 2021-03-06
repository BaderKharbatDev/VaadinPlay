package com.application.layouts;

import org.apache.log4j.Logger;

import com.application.authentication.AccessControl;
import com.application.authentication.AccessControlFactory;
import com.application.beatseshDB.User;
import com.application.database.Manager;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("BeatSesh Login")
@HtmlImport("MainBoxLayoutStyle.html")
public class NormalLogin extends VerticalLayout implements BeforeEnterObserver {
    private static final long serialVersionUID = 4767522515196076677L;
    protected static Logger logger = Logger.getLogger(NormalLogin.class);

    public NormalLogin() {
        logger.info("");
        _loadBackGround();
        _loadView();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        AccessControl accessControl = AccessControlFactory.getInstance().getAccessControl();

        if (accessControl.isUserSignedIn()) {
            try {
                event.rerouteTo(Panel.class);
            } catch (IllegalArgumentException e) {
                accessControl.signOut();
            } catch (NullPointerException e) {
                accessControl.signOut();
            }

        }
    }

    private void _loadBackGround() {
        getStyle().set("background-image", "url(frontend/shattered-island.gif)");
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void _loadView() {
        Div allDiv = new Div();

        Div otherDiv = new Div();
        Button otherButton = new Button("Sign In As a DJ", e -> {
            UI.getCurrent().navigate(DJLogin.class);
        });
        otherButton.addClassName("other");
        otherDiv.add(otherButton);
        allDiv.add(otherDiv);

        Div titleDiv = new Div();
        Label title = new Label("BeatSesh");
        title.addClassName("title");
        titleDiv.addClassName("titleDiv");
        titleDiv.add(title);
        allDiv.add(titleDiv, new Hr());

        Div normalDiv = new Div();
        TextField nameField = new TextField();
        nameField.setPlaceholder("Nickname");
        TextField codeField = new TextField();
        codeField.setPlaceholder("Party Code");
        Button joinButton = new Button("Join Party", e -> {
            logger.info("");
            try {
                Manager database = new Manager();
                User currentUser = database.makeNormalUser(Integer.parseInt(codeField.getValue()),
                                nameField.getValue());

                AccessControl accessControl = AccessControlFactory.getInstance().getAccessControl();
                accessControl.signInNormal(currentUser);

                //Navigate
                UI.getCurrent().navigate(Panel.class);

                nameField.setValue("");
                codeField.setValue("");
                Notification.show("Joined Party Successfully");
            } catch (IllegalArgumentException e1) {
                Notification.show("Invalid Code or Nickname");
            }
        });
        joinButton.addClassName("button");
        nameField.addClassName("input");
        codeField.addClassName("input");
        normalDiv.add(nameField, new Hr(), codeField, new Hr(), joinButton);
        allDiv.add(normalDiv);

        allDiv.addClassName("all");
        add(allDiv);
    }

    //    @Override
    //    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
    //        logger.info("event.location: '" + event.getLocation().getPath() + "'");
    //
    //        // UI.getCurrent().navigate(NormalLogin.class);
    //        // event.rerouteTo(NormalLogin.class);
    //        return HttpServletResponse.SC_NOT_FOUND;
    //    }
}
