package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteResultCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long resultId = Long.parseLong(request.getParameter("id"));
            provider.deleteResult(resultId);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=results";
    }
}
