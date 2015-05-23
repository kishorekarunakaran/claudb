package tonivade.db.data;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tonivade.db.data.DatabaseValue.string;

import java.util.HashMap;

import org.junit.Test;

public class DatabaseTest {

    private Database database = new Database(new HashMap<String, DatabaseValue>());

    @Test
    public void testDatabase() throws Exception {
        database.put("a", string("value"));

        assertThat(database.get("a").getValue(), is("value"));
        assertThat(database.containsKey("a"), is(true));
        assertThat(database.containsKey("b"), is(false));
        assertThat(database.isEmpty(), is(false));
        assertThat(database.size(), is(1));
    }

}
