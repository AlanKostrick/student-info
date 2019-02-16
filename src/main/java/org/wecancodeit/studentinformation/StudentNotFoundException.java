package org.wecancodeit.studentinformation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student Not Found")
public class StudentNotFoundException extends Exception {

}
