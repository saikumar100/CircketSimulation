import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cricketsim.matchsimulationservice.SimulateCricketMatch;

public class SimulateCricketMatchTestClass {
	
	/*Null pointer check while adding players data into queue*/
	@Test
    void predictMatchTest() {
		SimulateCricketMatch scm = new SimulateCricketMatch();
		Assertions.assertThrows(NullPointerException.class, () -> {
		    scm.predictTheMatch();
		  });
    }
}
