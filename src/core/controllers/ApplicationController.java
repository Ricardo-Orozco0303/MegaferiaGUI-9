package core.controllers;

import core.controllers.handlers.ErrorHandler;
import core.controllers.handlers.FormHandler;
import core.controllers.handlers.MessageHandler;
import core.controllers.handlers.RefreshDataHandler;
import core.controllers.handlers.SelectionHandler;
import core.controllers.interfaces.IApplicationController;
import core.controllers.utils.DependencyInjector;
import core.views.MegaferiaFrame;
import core.controllers.ResponseProcessor;

/**
 * Orquesta la aplicación utilizando el inyector
 */
public class ApplicationController implements IApplicationController {

    private final DependencyInjector dependencyContainer;

    public ApplicationController(DependencyInjector injector) {
        this.dependencyContainer = injector;
    }

    @Override
    public void start() {
        launchUserInterface();
    }

    @Override
    public MegaferiaFrame getMainFrame() {
        return dependencyContainer.getMainFrame();
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return dependencyContainer.getErrorHandler();
    }

    @Override
    public MessageHandler getMessageHandler() {
        return dependencyContainer.getMessageHandler();
    }

    @Override
    public FormHandler getFormHandler() {
        return dependencyContainer.getFormHandler();
    }

    @Override
    public RefreshDataHandler getRefreshDataHandler() {
        return dependencyContainer.getRefreshDataHandler();
    }

    @Override
    public SelectionHandler getSelectionHandler() {
        return dependencyContainer.getSelectionHandler();
    }

    public ResponseProcessor getResponseProcessor() {
        return dependencyContainer.getResponseProcessor();
    }

    private void launchUserInterface() {
        java.awt.EventQueue.invokeLater(() -> 
            dependencyContainer.getMainFrame().setVisible(true)
        );
    }
}

