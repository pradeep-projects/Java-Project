package pradeepshah.SpringProject.demo.Config;


import java.util.logging.Logger;

public class LoggerConfig {
    private static LoggerConfig instance;
    private void LoggerConfig(){
    }
    public static LoggerConfig getLoggerInstance(){
            if(instance == null){
                synchronized (Logger.class){
                    if(instance == null) {
                        instance = new LoggerConfig();
                        System.out.println( " initiated by :  "  + Thread.currentThread().getName());
                    }
                }
            }
            return instance;
    }

    public void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
