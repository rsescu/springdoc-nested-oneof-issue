package ro.consutsescu.springdocnestedoneofissues.apiobjects;

import lombok.Getter;

@Getter
public class Response {
    AbstractParent abstractParent;
    AbstractChild abstractChild;
}
