import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Result;
import org.sourceit.entities.Speciality;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeriu on 19.09.2015.
 */
public class TestApplicantResult {

    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testDeleteResult() throws Exception {
        provider.deleteResult(50);
    }

    @Test
    public void testSaveResult() throws Exception {
        Result result = new Result();
        result.setFirstName("Duke");
        result.setLastName("Nukem");
        result.setEntranceYear(2008);
        result.setApplicantId(1);
        result.setSubjectId(1);
        result.setId(1);
        provider.saveResult(result);
    }

    @Test
    public void testGetResult() throws Exception {
        Result result = null;
        result = provider.getResult(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void testListResult() throws Exception {
        List<Result> results = new ArrayList<>();
        results = provider.getResults();
        Assert.assertNotNull(results);
    }
}
