package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveResultCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        Result result = new Result();

        result.setApplicantId(Long.parseLong(request.getParameter("last_name")));
        result.setSubjectId(Long.parseLong(request.getParameter("subject_name")));
        result.setMark(Integer.parseInt(request.getParameter("mark")));

        if (request.getParameter("applicant_result_id") != null) {
            result.setId(Long.parseLong(request.getParameter("applicant_result_id")));
        }

        try {
            provider.saveResult(result);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=results";
    }
}
