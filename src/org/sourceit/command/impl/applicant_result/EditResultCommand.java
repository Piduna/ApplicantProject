package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Result;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditResultCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<Applicant> applicants = null;
        List<Subject> subjects = null;

        try {
            Long resultId = Long.parseLong(request.getParameter("id"));
            Result result = provider.getResult(resultId);

            applicants = provider.getApplicants();
            subjects = provider.getSubjects();

            request.setAttribute("result", result);
            request.setAttribute("applicants", applicants);
            request.setAttribute("subjects", subjects);

        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "pages/edit_applicant_result.jsp";
    }
}
