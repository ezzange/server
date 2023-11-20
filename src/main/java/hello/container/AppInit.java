package hello.container;

import jakarta.servlet.ServletContext;

public interface AppInit {
    void onstartup(ServletContext servletContext);
}
