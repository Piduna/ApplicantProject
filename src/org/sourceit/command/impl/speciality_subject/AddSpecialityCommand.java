package org.sourceit.command.impl.speciality_subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddSpecialityCommand implements ICommand {

    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<Profession> professions = null;
        List<Subject> subjects = null;

        try {
            professions = provider.getProfessions();
            subjects = provider.getSubjects();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("professions", professions);
        request.setAttribute("subjects", subjects);
        return "pages/edit_speciality_subject.jsp";
    }
}
