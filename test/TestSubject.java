import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.Subject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeriu on 19.09.2015.
 */
public class TestSubject {

    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testDeleteSubject() throws Exception {
        provider.deleteSubject(50);
    }

    @Test
    public void testSaveSubject() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectName("Ukr");
        subject.setId(1);
        provider.saveSubject(subject);
    }

    @Test
    public void testGetSubject() throws Exception {
        Subject subject = null;
        subject = provider.getSubject(1);
        Assert.assertNotNull(subject);
    }

    @Test
    public void testListSubject() throws Exception {
        List<Subject> subjects = new ArrayList<>();
        subjects = provider.getSubjects();
        Assert.assertNotNull(subjects);
    }
}
