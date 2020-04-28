package ufv.dis.parcialfinal.PruebaPC;

import java.io.FileNotFoundException;

import javax.servlet.annotation.WebServlet;

import com.itextpdf.text.DocumentException;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	Lista l = new Lista();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");
        final TextField apellido = new TextField();
        apellido.setCaption("Type your Lastname here:");
        final TextField edad = new TextField();
        edad.setCaption("Type your age here:");
        
        Button button = new Button("Generate Pdf");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
            Usuario u = new Usuario(name.getValue(), apellido.getValue(), Integer.parseInt(edad.getValue()));
            l.addUsuario(u);
            
            try {
				GeneradorPDF.pdf(u);
			} catch (FileNotFoundException | DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        layout.addComponents(name, apellido, edad, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
