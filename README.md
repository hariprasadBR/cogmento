# cogmento

Test → setDriver("chrome")
     → DriverFactory.getDriver("chrome")
     → new ChromeManager()
     → browserinitialization()
     → new ChromeDriver()
     → stored in ThreadLocal

Test → getDriver()
     → returns WebDriver for current thread
