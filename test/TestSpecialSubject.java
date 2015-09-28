import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Speciality;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeriu on 19.09.2015.
 */
public class TestSpecialSubject {

    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testDeleteSpeciality() throws Exception {
        provider.deleteSpeciality(50);
    }

    @Test
    public void testSaveSpeciality() throws Exception {
        Speciality speciality = new Speciality();
        speciality.setSubjectId(1);
        speciality.setProfessionSubject(1);
        speciality.setId(1);
        provider.saveSpeciality(speciality);
    }

    @Test
    public void testGetSpeciality() throws Exception {
        Speciality speciality = null;
        speciality = provider.getSpeciality(1);
        Assert.assertNotNull(speciality);
    }

    @Test
    public void testListSpeciality() throws Exception {
        List<Speciality> specialitys = new ArrayList<>();
        specialitys = provider.getSpecialitys();
        Assert.assertNotNull(specialitys);
    }

}
