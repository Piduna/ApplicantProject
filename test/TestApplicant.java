import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Subject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeriu on 19.09.2015.
 */
public class TestApplicant {

    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testDeleteApplicant() throws Exception {
        provider.deleteApplicant(50);
    }

    @Test
    public void testSaveApplicant() throws Exception {
        Applicant applicant = new Applicant();
        applicant.setFirstName("Duke");
        applicant.setLastName("Nukem");
        applicant.setEntranceYear(2);
        applicant.setProfessionId(1);
        applicant.setId(1);
        provider.saveApplicant(applicant);
    }

    @Test
    public void testGetApplicant() throws Exception {
        Applicant applicant = null;
        applicant = provider.getApplicant(1);
        Assert.assertNotNull(applicant);
    }

    @Test
    public void testListApplicant() throws Exception {
        List<Applicant> applicants = new ArrayList<>();
        applicants = provider.getApplicants();
        Assert.assertNotNull(applicants);
    }
}
