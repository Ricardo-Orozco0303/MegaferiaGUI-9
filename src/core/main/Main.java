package core.main;

import com.formdev.flatlaf.FlatDarkLaf;
import core.controllers.ApplicationController;
import core.controllers.utils.DependencyInjector;
import javax.swing.UIManager;

public class Main {

    private static final String FLATLAF_NATIVE_LIBRARY_PROPERTY = "flatlaf.useNativeLibrary";

    public static void main(String[] args) {
        configureUserInterfaceTheme();
        
        DependencyInjector dependencyContainer = new DependencyInjector().initialize();
        ApplicationController applicationController = new ApplicationController(dependencyContainer);
        
        applicationController.start();
    }

    private static void configureUserInterfaceTheme() {
        System.setProperty(FLATLAF_NATIVE_LIBRARY_PROPERTY, "false");
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo inicializar el tema FlatLaf");
        }
    }
}
