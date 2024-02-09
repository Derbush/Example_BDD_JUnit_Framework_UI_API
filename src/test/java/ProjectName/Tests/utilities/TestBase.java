package ProjectName.Tests.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class TestBase {

    public Logger log = LogManager.getLogger(this.getClass());
}
