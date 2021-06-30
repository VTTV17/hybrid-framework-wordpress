package commons;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class TestNGAppender extends AppenderSkeleton{

	@Override
	public void close() {
		// TODO Auto-generated method stub
		Reporter.log("Logging appender is closed");
	}

	@Override
	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void append(LoggingEvent arg0) {
		// TODO Auto-generated method stub
		Reporter.log(getLayout().format(arg0));
	}
	
	public void info(String message) {
		Reporter.log(message);
	}
}
