package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
//인터페이스의 구현체의 클래스 정보를 넘겨주는 애노테이션
@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println( "MyContainerInitV2.onStartup");
        System.out.println( "MyContainerInitV2 c = " + c);
        System.out.println( "MyContainerInitV2 ctx = " + ctx);

        //구현체가 여러 개일 수 있으니 반복문
        //class hello,container,AppInitV1Servlet
        for (Class<?> appInitClass : c) {
            try {
                                                    //new AppInitV1Servlet()과 같은 코드
                AppInit appInit = (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                appInit.onstartup(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
