package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditApplicantCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<Profession> professions = null;

        try {
            Long applicantId = Long.parseLong(request.getParameter("id"));
            Applicant applicant = provider.getApplicant(applicantId);

            professions = provider.getProfessions();

            request.setAttribute("applicant", applicant);
            request.setAttribute("professions", professions);

        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "pages/edit_applicant.jsp";
    }
}
