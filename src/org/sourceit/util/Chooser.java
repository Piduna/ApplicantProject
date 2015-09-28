package org.sourceit.util;

import org.sourceit.command.ICommand;
import org.sourceit.command.impl.applicant.*;
import org.sourceit.command.impl.applicant_result.*;
import org.sourceit.command.impl.profession.*;
import org.sourceit.command.impl.speciality_subject.*;
import org.sourceit.command.impl.subject.*;

import java.util.HashMap;
import java.util.Map;


public enum Chooser {

    INSTANCE;

    private Map<String, ICommand> commandMap = new HashMap<>();

    private Chooser() {

        // commands for profession
        commandMap.put("professions", new ProfessionCommand());
        commandMap.put("addProfession", new AddProfessionCommand());
        commandMap.put("saveProfession", new SaveProfessionCommand());
        commandMap.put("deleteProfession", new DeleteProfessionCommand());
        commandMap.put("editProfession", new EditProfessionCommand());

        // commands for applicants
        commandMap.put("applicants", new ApplicantCommand());
        commandMap.put("addApplicant", new AddApplicantCommand());
        commandMap.put("saveApplicant", new SaveApplicantCommand());
        commandMap.put("deleteApplicant", new DeleteApplicantCommand());
        commandMap.put("editApplicant", new EditApplicantCommand());

        // commands for subject
        commandMap.put("subjects", new SubjectCommand());
        commandMap.put("addSubject", new AddSubjectCommand());
        commandMap.put("saveSubject", new SaveSubjectCommand());
        commandMap.put("deleteSubject", new DeleteSubjectCommand());
        commandMap.put("editSubject", new EditSubjectCommand());

        // commands for speciality subject
        commandMap.put("specialitys", new SpecialityCommand());
        commandMap.put("addSpeciality", new AddSpecialityCommand());
        commandMap.put("saveSpeciality", new SaveSpecialityCommand());
        commandMap.put("deleteSpeciality", new DeleteSpecialityCommand());
        commandMap.put("editSpeciality", new EditSpecialityCommand());

        // commands for applicant result
        commandMap.put("results", new ResultCommand());
        commandMap.put("addResult", new AddResultCommand());
        commandMap.put("saveResult", new SaveResultCommand());
        commandMap.put("deleteResult", new DeleteResultCommand());
        commandMap.put("editResult", new EditResultCommand());

    }

    public ICommand chooseCommand(String command) {
        return commandMap.get(command);
    }

}
