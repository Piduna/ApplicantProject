package org.sourceit.command.impl.speciality_subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Speciality;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class SaveSpecialityCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        Speciality speciality = new Speciality();

        speciality.setProfessionSubject(Long.parseLong(request.getParameter("profession_name")));
        speciality.setSubjectId(Long.parseLong(request.getParameter("subject_name")));
        if (request.getParameter("sp_sb_id") != null) {
            speciality.setId(Long.parseLong(request.getParameter("sp_sb_id")));
        }

        try {
            provider.saveSpeciality(speciality);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=specialitys";
    }
}
