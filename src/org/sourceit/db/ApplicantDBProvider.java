package org.sourceit.db;

import org.sourceit.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public enum ApplicantDBProvider {

    INSTANCE;

    private Connection connection;

    private ApplicantDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "quake3arena");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public Subject getSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;
        Subject subject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM subject WHERE subject_id=?");
            preparedStatement.setInt(1, (int) subjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return subject;
    }

    public List<Subject> getSubjects() throws Exception {
        Statement statement = null;

        List<Subject> subjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subject");
            Subject subject = null;
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
                subjects.add(subject);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return subjects;
    }

    public void saveSubject(Subject subject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (subject.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO subject (subject_name) VALUES (?) ");
                preparedStatement.setString(1, subject.getSubjectName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE subject SET subject_name=? WHERE subject_id=?");
                preparedStatement.setString(1, subject.getSubjectName());
                preparedStatement.setInt(2, (int) subject.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM subject WHERE subject_id=?");
            preparedStatement.setInt(1, (int) subjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Profession getProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;
        Profession profession = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM profession WHERE profession_id=?");
            preparedStatement.setInt(1, (int) professionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return profession;
    }

    public List<Profession> getProfessions() throws Exception {
        Statement statement = null;

        List<Profession> professions = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM profession");
            Profession profession = null;
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
                professions.add(profession);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return professions;
    }

    public void saveProfession(Profession profession) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (profession.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO profession (profession_name) VALUES (?) ");
                preparedStatement.setString(1, profession.getProfessionName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE profession SET profession_name=? WHERE profession_id=?");
                preparedStatement.setString(1, profession.getProfessionName());
                preparedStatement.setInt(2, (int) profession.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM profession WHERE profession_id=?");

            preparedStatement.setInt(1, (int) professionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Applicant getApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;
        Applicant applicant = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM applicant WHERE applicant_id=?");
            preparedStatement.setInt(1, (int) applicantId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionId(resultSet.getInt("profession_id"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicant;
    }

    public List<Applicant> getApplicants() throws Exception {
        Statement statement = null;
        List <Applicant> applicants = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select a.applicant_id, a.first_name, a.last_name, a.entrance_year, p.profession_name from applicant a join profession p on a.profession_id = p.profession_id");
            Applicant applicant = null;
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionName(resultSet.getString("profession_name"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                applicants.add(applicant);

            }

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return applicants;
    }

    public void saveApplicant(Applicant applicant) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicant.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO applicant (first_name, last_name, profession_id, entrance_year) VALUES (?,?,?,?)");
                preparedStatement.setString(1, applicant.getFirstName());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setInt(3, (int)applicant.getProfessionId());
                preparedStatement.setInt(4, applicant.getEntranceYear());

            } else {
                preparedStatement = connection.prepareStatement("UPDATE applicant SET first_name=?, last_name=?, profession_id=?, entrance_year=?  WHERE applicant_id=?");
                preparedStatement.setString(1, applicant.getFirstName());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setInt(3, (int) applicant.getProfessionId());
                preparedStatement.setInt(4, applicant.getEntranceYear());
                preparedStatement.setInt(5, (int) applicant.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant WHERE applicant_id=?");
            preparedStatement.setInt(1, (int) applicantId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Speciality getSpeciality(long specialityId) throws Exception {
        PreparedStatement preparedStatement = null;
        Speciality speciality = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM speciality_subject WHERE sp_sb_id=?");
            preparedStatement.setInt(1, (int) specialityId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                speciality = new Speciality();
                speciality.setId(resultSet.getInt("sp_sb_id"));
                speciality.setProfessionSubject(resultSet.getInt("profession_id"));
                speciality.setSubjectId(resultSet.getInt("subject_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return speciality;
    }

    public List<Speciality> getSpecialitys() throws Exception {
        Statement statement = null;
        List <Speciality> specialitys = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ss.SP_SB_ID, p.PROFESSION_NAME, s.SUBJECT_NAME FROM speciality_subject ss JOIN (profession p, subject s) ON ss.SUBJECT_ID = s.SUBJECT_ID AND ss.PROFESSION_ID = p.PROFESSION_ID");
            Speciality speciality = null;
            while (resultSet.next()) {
                speciality = new Speciality();
                speciality.setId(resultSet.getInt("sp_sb_id"));
                speciality.setProfessionName(resultSet.getString("profession_name"));
                speciality.setSubjectName(resultSet.getString("subject_name"));
                specialitys.add(speciality);

            }

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return specialitys;
    }

    public void saveSpeciality (Speciality speciality) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (speciality.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO speciality_subject (profession_id, subject_id) VALUES (?,?)");
                preparedStatement.setInt(1, (int) speciality.getProfessionSubject());
                preparedStatement.setInt(2, (int) speciality.getSubjectId());

            } else {
                preparedStatement = connection.prepareStatement("UPDATE speciality_subject SET profession_id=?, subject_id=?  WHERE sp_sb_id=?");
                preparedStatement.setInt(1, (int) speciality.getProfessionSubject());
                preparedStatement.setInt(2, (int) speciality.getSubjectId());
                preparedStatement.setInt(3, (int) speciality.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteSpeciality(long specialityId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM speciality_subject WHERE sp_sb_id=?");

            preparedStatement.setInt(1, (int) specialityId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Result getResult(long resultId) throws Exception {
        PreparedStatement preparedStatement = null;
        Result result = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM applicant_result WHERE applicant_result_id=?");
            preparedStatement.setInt(1, (int) resultId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new Result();
                result.setId(resultSet.getInt("applicant_result_id"));
                result.setApplicantId(resultSet.getInt("applicant_id"));
                result.setSubjectId(resultSet.getInt("subject_id"));
                result.setMark(resultSet.getInt("mark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return result;
    }

    public List<Result> getResults() throws Exception {
        Statement statement = null;
        List <Result> results = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ar.APPLICANT_RESULT_ID, a.FIRST_NAME, a.LAST_NAME, a.ENTRANCE_YEAR, s.SUBJECT_NAME, ar.MARK FROM applicant_result ar JOIN (applicant a, subject s) ON ar.APPLICANT_ID = a.APPLICANT_ID AND ar.SUBJECT_ID = s.SUBJECT_ID");
            Result result = null;
            while (resultSet.next()) {
                result = new Result();
                result.setId(resultSet.getInt("applicant_result_id"));
                result.setFirstName(resultSet.getString("first_name"));
                result.setLastName(resultSet.getString("last_name"));
                result.setEntranceYear(resultSet.getInt("entrance_year"));
                result.setSubjectName(resultSet.getString("subject_name"));
                result.setMark(resultSet.getInt("mark"));
                results.add(result);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return results;
    }

    public void saveResult (Result result) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (result.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO applicant_result(applicant_id, subject_id, mark) VALUES (?,?,?)");
                preparedStatement.setInt(1, (int) result.getApplicantId());
                preparedStatement.setInt(2, (int) result.getSubjectId());
                preparedStatement.setInt(3,  result.getMark());

            } else {
                preparedStatement = connection.prepareStatement("UPDATE applicant_result SET applicant_id=?, subject_id=?, mark=? WHERE applicant_result_id=?");
                preparedStatement.setInt(1, (int) result.getApplicantId());
                preparedStatement.setInt(2, (int) result.getSubjectId());
                preparedStatement.setInt(3, result.getMark());
                preparedStatement.setInt(4, (int) result.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteResult(long resultId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant_result WHERE applicant_result_id=?");
            preparedStatement.setInt(1, (int) resultId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
