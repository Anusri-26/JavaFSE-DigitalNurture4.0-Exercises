//Week-1
//Exercise-1: Implementing the Singleton Pattern

public class SingletonPatternExample {

    static class LogManager {

        private static LogManager singleInstance;

        private LogManager() {
            System.out.println("Logger has been set up successfully.");

            if (singleInstance != null) {
                throw new RuntimeException("Please use getInstance() to create the logger.");
            }
        }

        public static LogManager getInstance() {
            if (singleInstance == null) {
                singleInstance = new LogManager();
            }
            return singleInstance;
        }

        public void writeLog(String message) {
            System.out.println("Log: " + message);
        }
    }

 
    public static void main(String[] args) {

        LogManager logger1 = LogManager.getInstance();
        logger1.writeLog("Starting the system...");

        LogManager logger2 = LogManager.getInstance();
        logger2.writeLog("Performing some tasks...");

        if (logger1 == logger2) {
            System.out.println("Confirmed: Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("Warning: logger1 and logger2 are different instances.");
        }
    }
}

