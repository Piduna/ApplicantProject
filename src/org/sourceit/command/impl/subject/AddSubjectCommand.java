package org.sourceit.command.impl.subject;

import org.sourceit.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSubjectCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/edit_subject.jsp";
    }
}
