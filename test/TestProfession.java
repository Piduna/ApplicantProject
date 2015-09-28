import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Profession;
import org.sourceit.entities.Speciality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeriu on 19.09.2015.
 */
public class TestProfession {

    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public  void testDeleteProfession() throws Exception {
          provider.deleteProfession(50);
     }

    @Test
    public void testSaveProfessions () throws Exception {
         Profession profession = new Profession();
         profession.setProfessionName("C++");
         profession.setId(1);
         provider.saveProfession(profession);
     }

    @Test
    public void testGetProfession () throws Exception {
             Profession profession = null;
             profession = provider.getProfession(1);
             Assert.assertNotNull(profession);
    }

    @Test
    public void testListProfessions() throws Exception {
        List<Profession> professions = new ArrayList<>();
        professions = provider.getProfessions();
        Assert.assertNotNull(professions);
    }
    }